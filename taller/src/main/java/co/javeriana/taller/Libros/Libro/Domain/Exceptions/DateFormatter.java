package co.javeriana.taller.Libros.Libro.Domain.Exceptions;

public class DateFormatter extends RuntimeException{
    public DateFormatter (String message){
        super(message);
    }
}
