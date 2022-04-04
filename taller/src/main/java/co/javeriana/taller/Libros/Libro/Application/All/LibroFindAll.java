package co.javeriana.taller.Libros.Libro.Application.All;

import co.javeriana.taller.Libros.Libro.Domain.Ports.LibroRepository;
import co.javeriana.taller.Libros.Libro.Domain.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroFindAll {

    private LibroRepository repository;

    public LibroFindAll(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> execute() {
        List<Libro> libros = new ArrayList<Libro>();
        Optional<List<Libro>> optionalLibros = repository.all();
        if(optionalLibros.isPresent()) {
            libros = optionalLibros.get();
        }
        return libros;
    }
}
