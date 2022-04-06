package co.javeriana.taller.Libros.Libro.Application.FindById;

import co.javeriana.taller.Libros.Libro.Domain.Libro;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroNumPaginas;

import java.util.HashMap;

public class LibroFindByIdResponse {

    private Libro libro;

    public LibroFindByIdResponse(Libro libro) {
        this.libro = libro;
    }

    public HashMap<String, Object> response() {
        HashMap<String, Object> response = libro.data();
        //Random number between 200 and 1500 pages
        Integer randomPages =  (int)(Math.random()*(1500-200+1)+200);
        LibroNumPaginas numPaginas = new LibroNumPaginas(randomPages);
        response.put("libroNumpaginas", numPaginas.value());

        return response;
    }

}
