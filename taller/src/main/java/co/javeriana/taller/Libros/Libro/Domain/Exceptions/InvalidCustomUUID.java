package co.javeriana.taller.Libros.Libro.Domain.Exceptions;

public class InvalidCustomUUID extends RuntimeException{
    public InvalidCustomUUID(String message) {
        super(message);
    }
}
