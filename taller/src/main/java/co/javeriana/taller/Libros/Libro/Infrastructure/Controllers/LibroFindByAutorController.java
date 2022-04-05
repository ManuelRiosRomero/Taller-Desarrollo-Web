package co.javeriana.taller.Libros.Libro.Infrastructure.Controllers;

import co.javeriana.taller.Libros.Libro.Application.Find.LibroFindByAutor;
import co.javeriana.taller.Libros.Libro.Application.Find.LibroFindByAutorResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Libro", description = "Libro REST API")
@RequestMapping(value = "/libro")
public class LibroFindByAutorController {

    @Autowired
    private LibroFindByAutor findAutor;

    @GetMapping(value = "/autor")
    public ResponseEntity<List<HashMap<String, Object>>> execute(@RequestBody LibroFindByAutorRequest request) {
        LibroFindByAutorResponse response = new LibroFindByAutorResponse(findAutor.execute(request.getLibroNombreAutor()));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    static class LibroFindByAutorRequest {

        @Schema(description = "Libro nombreAutor, Debe tener nombre y apellido", example = "Gustavo Salazar")
        private String libroNombreAutor;

        public String getLibroNombreAutor() {
            return libroNombreAutor;
        }

        public void setLibroNombreAutor(String libroNombreAutor) {
            this.libroNombreAutor = libroNombreAutor;
        }
    }
}
