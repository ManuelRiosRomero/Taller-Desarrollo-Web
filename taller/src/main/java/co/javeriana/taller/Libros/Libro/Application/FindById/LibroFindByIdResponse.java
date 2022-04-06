package co.javeriana.taller.Libros.Libro.Application.FindById;

import co.javeriana.taller.Libros.Libro.Domain.Libro;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroNumPaginas;

import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

public class LibroFindByIdResponse {

    private Libro libro;

    public LibroFindByIdResponse(Libro libro) {
        this.libro = libro;
    }

    public HashMap<String, Object> response() {
        String random = String.valueOf((int)(Math.random()*(1500-200+1)+200));

        HashMap<String, Object> response = new HashMap<>() {{
            put("descripcion", libro.data().get("libroDescripcion"));
            put("precio", libro.data().get("libroPrecio"));
            put("añoPublicacion", libro.data().get("libroPublicationDate"));
            put("numPaginas", random);
        }};
        return response;
    }

}
