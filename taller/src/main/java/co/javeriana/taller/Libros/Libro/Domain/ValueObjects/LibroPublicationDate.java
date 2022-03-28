package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Libros.Libro.Domain.Exceptions.NegativePrice;
import co.javeriana.taller.Shared.Domain.DateValueObject;
import java.util.Date;

public class LibroPublicationDate extends DateValueObject {

    public LibroPublicationDate(Date value) {
        //validate(value);
        this.value = value;
    }

    private void validate(Date value){
        DateFormatter(value);
    }

    private void DateFormatter(Date value){
        /**
         * if(value){
         *             throw new DateFormatter("\nFormato de Fecha no valido");
         *         }
         */
    }
}
