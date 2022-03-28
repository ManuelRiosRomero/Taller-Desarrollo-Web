package co.javeriana.taller.Libros.Libro.Domain.Exceptions;

public class NegativePrice extends RuntimeException{
    public NegativePrice(String message) {
        super(message);
    }
}
