package co.javeriana.taller.Libros.Libro.Domain.Exceptions;

public class FullName extends RuntimeException{
    public FullName(String message) {
        super(message);
    }
}
