package co.javeriana.taller.Libros.Libro.Domain.Ports;

import co.javeriana.taller.Libros.Libro.Domain.Libro;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroId;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroNombreAutor;

import java.util.List;
import java.util.Optional;


public interface LibroRepository {
    void save(Libro libro);
    void update(Libro libro);
    Optional<Libro> find(LibroId libroId);
    Optional<Libro> findByNombreAutor(LibroNombreAutor libroNombreAutor);
    Optional<List<Libro>> all();
    void delete(Libro libro);
}
