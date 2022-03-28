package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Libros.Libro.Domain.Exceptions.ValueLength;
import co.javeriana.taller.Shared.Domain.StringValueObject;

public class LibroTitulo  extends StringValueObject {

    public LibroTitulo(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value){
        valueLength(value);
    }

    private void valueLength(String value){
        if(value.length() < 5 || value.length() > 500){
            throw new ValueLength("\nLongitud invalidad");
        }
    }
}
