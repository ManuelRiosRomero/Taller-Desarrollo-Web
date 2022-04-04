package co.javeriana.taller.Libros.Libro.Domain.Exceptions;

public class LibroAlreadyExist extends RuntimeException{
    public LibroAlreadyExist(String message) {
        super(message);
    }
}
