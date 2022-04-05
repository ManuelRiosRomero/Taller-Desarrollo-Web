package co.javeriana.taller.Libros.Libro.Application.Find;

import co.javeriana.taller.Libros.Libro.Domain.Libro;
import co.javeriana.taller.Libros.Libro.Domain.Ports.LibroRepository;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroNombreAutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroFindByAutor {
    private LibroRepository repository;

    public LibroFindByAutor(LibroRepository repository){this.repository = repository;}

    public List<Libro> execute(String libroNombreAutor) {
        List<Libro> libros = new ArrayList<Libro>();
        Optional<List<Libro>> optionalLibros = repository.findByNombreAutor(new LibroNombreAutor(libroNombreAutor));
        if(optionalLibros.isPresent()) {
            libros = optionalLibros.get();
        }
        return libros;
    }
}
