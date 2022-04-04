package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Libros.Libro.Domain.Exceptions.DateFormatter;
import co.javeriana.taller.Libros.Libro.Domain.Exceptions.NegativePrice;
import co.javeriana.taller.Shared.Domain.DateValueObject;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;

public class LibroPublicationDate extends DateValueObject {

    public LibroPublicationDate(LocalDate value) {
        //validate(value);
        this.value = value;
    }

    private void validate(LocalDate value){
        DateFormatter(value);
    }

    private void DateFormatter(LocalDate value){
        try {
            LocalDate v = LocalDate.of(value.getDayOfMonth(), value.getMonth(), value.getYear());
        }
        catch (Exception e) {
            throw new DateFormatter("\nFormato de Fecha no valido");
        }
    }
}
