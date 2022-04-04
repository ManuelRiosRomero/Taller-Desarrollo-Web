package co.javeriana.taller.Libros.Libro.Infrastructure.Controllers;

import co.javeriana.taller.Libros.Libro.Domain.Libro;
import co.javeriana.taller.Shared.Infrastruture.Schema.ErrorSchema;
import co.javeriana.taller.Libros.Libro.Application.Create.LibroCreator;
import co.javeriana.taller.Libros.Libro.Domain.Exceptions.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@Tag(name = "Libro", description = "Libro REST API")
@RequestMapping(value = "/libro")
public class LibroCreateController {

    @Autowired
    private LibroCreator creator;

    @Operation(summary = "Create a new Libro", description = "Create a new Libro in the system", tags = {"Libro"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Libro created"),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorSchema.class))),
            @ApiResponse(responseCode = "409", description = "Libro already exist", content = @Content(schema = @Schema(implementation = ErrorSchema.class)))
    })
    @PostMapping(value = "/create")
    public ResponseEntity execute(@RequestBody LibroCreatorRequest request) {
        creator.execute(request.getLibroId(), request.getLibroDescripcion(), request.getLibroNombreAutor(),
                Double.parseDouble(request.getLibroPrecio()),
                Integer.parseInt(request.getLibroPublicationDate()),
                request.getLibroTitulo()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(value = {FullName.class, InvalidCustomUUID.class, NegativePrice.class, PageSize.class, ValidYear.class, ValueLength.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap> handleBadRequest(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(LibroAlreadyExist.class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    public ResponseEntity<HashMap> handleDuplicatedLibro(RuntimeException exception) {
        HashMap<String, String> response = new HashMap<>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    static class LibroCreatorRequest {
        @Schema(description = "Libro id", example = "0f1c4b36-e610-4446-a3a3-a6083902b587")
        private String libroId;

        @Schema(description = "Libro description, No puede tener más de 200 caracteres", example = "Hola soy una descripción")
        private String libroDescripcion;

        @Schema(description = "Libro nombreAutor, Debe tener nombre y apellido", example = "Gustavo Salazar")
        private String libroNombreAutor;

        @Schema(description = "Libro precio, debe ser positivo y sin centavos", example = "45000")
        private String libroPrecio;

        @Schema(description = "Libro anio, debe tener 4 dígitos y ser menor al año actual", example = "2010")
        private String libroPublicationDate;

        @Schema(description = "Libro titulo, debe tener 5 y 100 caracteres", example = "La Biblia")
        private String libroTitulo;


        public String getLibroId() {
            return libroId;
        }

        public void setLibroId(String libroId) {
            this.libroId = libroId;
        }

        public String getLibroDescripcion() {
            return libroDescripcion;
        }

        public void setLibroDescripcion(String libroDescripcion) {
            this.libroDescripcion = libroDescripcion;
        }

        public String getLibroNombreAutor() {
            return libroNombreAutor;
        }

        public void setLibroNombreAutor(String libroNombreAutor) {
            this.libroNombreAutor = libroNombreAutor;
        }

        public String getLibroPrecio() {
            return libroPrecio;
        }

        public void setLibroPrecio(String libroPrecio) {
            this.libroPrecio = libroPrecio;
        }

        public String getLibroPublicationDate() {
            return libroPublicationDate;
        }

        public void setLibroPublicationDate(String libroPublicationDate) {
            this.libroPublicationDate = libroPublicationDate;
        }

        public String getLibroTitulo() {
            return libroTitulo;
        }

        public void setLibroTitulo(String libroTitulo) {
            this.libroTitulo = libroTitulo;
        }
    }
}
