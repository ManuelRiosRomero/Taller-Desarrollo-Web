package co.javeriana.taller.Libros.Libro.Application.FindById;

import co.javeriana.taller.Libros.Libro.Domain.Libro;

import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

public class LibroFindByIdResponse {

    private Libro libro;

    public LibroFindByIdResponse(Libro libro) {
        this.libro = libro;
    }

    public HashMap<String, Object> response() {
        HashMap<String, Object> response = new HashMap<>() {{
            put("descripcion", libro.data().get("libroDescripcion"));
            put("precio", libro.data().get("libroPrecio"));
            put("añoPublicacion", libro.data().get("libroPublicationDate"));
            put("numPaginas", new Random().nextInt(15000));
        }};
        return response;
    }

}
