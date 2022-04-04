package co.javeriana.taller.Libros.Libro.Domain.Exceptions;

public class ValidYear extends RuntimeException{
    public ValidYear(String message) {
        super(message);
    }
}
