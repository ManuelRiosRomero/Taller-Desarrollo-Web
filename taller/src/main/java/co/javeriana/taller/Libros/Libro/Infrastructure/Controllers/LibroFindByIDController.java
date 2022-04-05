package co.javeriana.taller.Libros.Libro.Infrastructure.Controllers;

import co.javeriana.taller.Libros.Libro.Application.FindById.LibroFindById;
import co.javeriana.taller.Libros.Libro.Application.FindById.LibroFindByIdResponse;
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
public class LibroFindByIDController {

    @Autowired
    private LibroFindById findLibro;

    @GetMapping(value = "/id")
    public ResponseEntity<HashMap<String, Object>> execute(@RequestBody LibroFindByIDController.LibroFindByIdRequest request) {
        LibroFindByIdResponse response = new LibroFindByIdResponse(findLibro.execute(request.getLibroId()));
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    static class LibroFindByIdRequest {

        @Schema(description = "Debe ser un UUID valido", example = "5518418e-51a3-4da7-8dfb-e11d1abce4ba")
        private String libroId;

        public String getLibroId() {
            return libroId;
        }

        public void setLibroId(String libroId) {
            this.libroId = libroId;
        }
    }


}
