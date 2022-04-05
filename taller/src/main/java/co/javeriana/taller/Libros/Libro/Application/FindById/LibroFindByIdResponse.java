package co.javeriana.taller.Libros.Libro.Application.FindById;

import co.javeriana.taller.Libros.Libro.Domain.Libro;

import java.util.HashMap;

public class LibroFindByIdResponse {

    private Libro libro;

    public LibroFindByIdResponse(Libro libro) {
        this.libro = libro;
    }

    public HashMap<String, Object> response() {
        HashMap<String, Object> response = libro.data();
        return response;
    }

}
