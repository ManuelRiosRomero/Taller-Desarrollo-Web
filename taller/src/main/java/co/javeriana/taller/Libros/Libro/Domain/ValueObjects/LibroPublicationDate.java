package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Libros.Libro.Domain.Exceptions.DateFormatter;
import co.javeriana.taller.Libros.Libro.Domain.Exceptions.NegativePrice;
import co.javeriana.taller.Libros.Libro.Domain.Exceptions.PageSize;
import co.javeriana.taller.Libros.Libro.Domain.Exceptions.ValidYear;
import co.javeriana.taller.Shared.Domain.DateValueObject;
import co.javeriana.taller.Shared.Domain.IntegerValueObject;
import org.apache.tomcat.jni.Local;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class LibroPublicationDate extends IntegerValueObject {

    private LibroPublicationDate(){}

    public LibroPublicationDate(Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(Integer value) {
        ValidYear(value);
    }

    private void ValidYear(Integer value) {

        int length = String.valueOf(value).length();
        //El año está después del actual o la longitud no es de 4 dígitos
        if (value > Calendar.getInstance().get(Calendar.YEAR)||length!=4) {
            throw new ValidYear("El año debe ser inferior al actual y debe ser de 4 dígitos");
        }
    }
}
