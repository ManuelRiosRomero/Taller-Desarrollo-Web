package co.javeriana.taller.Libros.Libro.Application.Find;

import co.javeriana.taller.Libros.Libro.Domain.Libro;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LibroFindByAutorResponse {

    private List<Libro> libros;

    public LibroFindByAutorResponse(List<Libro> libros) {
        this.libros = libros;
    }

    public List<HashMap<String, Object>> response() {
        List<HashMap<String, Object>> response = libros.stream().map(libro-> libro.data()).collect(Collectors.toList());
        return response;
    }
}
