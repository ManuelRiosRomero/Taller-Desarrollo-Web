package co.javeriana.taller.Libros.Libro.Application.FindById;

import co.javeriana.taller.Libros.Libro.Domain.Libro;
import co.javeriana.taller.Libros.Libro.Domain.Ports.LibroRepository;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroId;

import java.util.Optional;

public class LibroFindById {
    private LibroRepository repository;

    public LibroFindById(LibroRepository repository){this.repository = repository;}

    public Libro execute(String Id) {
        Libro libro = null;
        Optional<Libro> optionalLibro = repository.find(new LibroId(Id));
        if(optionalLibro.isPresent()) {
            libro = optionalLibro.get();
        }
        return libro;
    }
}
