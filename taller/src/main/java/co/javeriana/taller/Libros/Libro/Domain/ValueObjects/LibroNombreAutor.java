package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Libros.Libro.Domain.Exceptions.FullName;
import co.javeriana.taller.Shared.Domain.StringValueObject;

public class LibroNombreAutor extends StringValueObject {

    public LibroNombreAutor(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value){
        fullName(value);
    }

    private void fullName(String value){
        /**
         * if(value){
         *             throw new FullName("\nLongitud invalidad");
         *         }
         */

    }
}
