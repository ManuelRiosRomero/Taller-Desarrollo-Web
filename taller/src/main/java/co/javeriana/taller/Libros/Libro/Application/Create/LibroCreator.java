package co.javeriana.taller.Libros.Libro.Application.Create;

import co.javeriana.taller.Libros.Libro.Domain.Libro;
import co.javeriana.taller.Libros.Libro.Domain.Ports.LibroRepository;
import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.*;

public class LibroCreator {

    private LibroRepository repository;

    public LibroCreator(LibroRepository repository) {
        this.repository = repository;
    }

    public void execute(String libroId, String libroDescripcion, String libroNombreAutor,
                        Double libroPrecio, Integer libroPublicationDate,
                        String libroTitulo ) {
        Libro libro = Libro.create(new LibroId(libroId), new LibroDescription(libroDescripcion),
                                new LibroNombreAutor(libroNombreAutor),
                                new LibroPrecio(libroPrecio), new LibroPublicationDate(libroPublicationDate),
                                new LibroTitulo(libroTitulo));
        repository.save(libro);
    }
}
