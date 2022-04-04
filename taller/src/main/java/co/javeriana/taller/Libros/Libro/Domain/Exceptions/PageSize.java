package co.javeriana.taller.Libros.Libro.Domain.Exceptions;

public class PageSize extends RuntimeException {
    public PageSize(String message) {
        super(message);
    }
}
