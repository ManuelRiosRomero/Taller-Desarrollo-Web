package co.javeriana.taller.Libros.Libro.Infrastructure.Adapters;

import co.javeriana.taller.Libros.Libro.Domain.Ports.LibroRepository;
import co.javeriana.taller.Libros.Libro.Domain.Libro;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroNombreAutor;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.LibroId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryLibroRepository implements LibroRepository {

    private List<Libro> libros = new ArrayList<>();

    public void save(Libro libro) {
        System.out.println("Estoy en el repo");
        System.out.println(libro.data());
        libros.add(libro);
    }

    @Override
    public void update(Libro libros) {

    }

    @Override
    public Optional<Libro> find(LibroId libroId) {
        return Optional.empty();
    }

    @Override
    public Optional<Libro> findByNombreAutor(LibroNombreAutor libroNombreAutor) {
        System.out.println(libroNombreAutor.value());
        libros.stream().forEach(libro -> System.out.println(libro.data().get("libroNombreAutor")));
        return Optional.ofNullable(libros.stream().filter(libro -> libro.data().get("nombreAutor").equals(libroNombreAutor.value())).collect(Collectors.toList()).get(0));
    }

    @Override
    public Optional<List<Libro>> all() {
        return Optional.ofNullable(libros);
    }

    @Override
    public void delete(Libro libro) {

    }

}
