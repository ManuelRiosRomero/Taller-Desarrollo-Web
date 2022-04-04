package co.javeriana.taller.Libros.Libro.Infrastructure.Controllers;

import co.javeriana.taller.Libros.Libro.Application.All.LibroFindAll;
import co.javeriana.taller.Libros.Libro.Application.All.LibroFindAllResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Tag(name = "Libro", description = "Libro REST API")
@RequestMapping(value = "/Libro")
public class LibroFinderAllController {

    @Autowired
    private LibroFindAll all;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap<String, Object>>> execute() {
        LibroFindAllResponse response = new LibroFindAllResponse(all.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}
