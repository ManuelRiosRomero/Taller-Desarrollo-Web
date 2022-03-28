package co.javeriana.taller.Libros.Libro.Domain.Exceptions;

public class ValueLength extends RuntimeException{
    public ValueLength(String message) {
        super(message);
    }
}
