package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Libros.Libro.Domain.Exceptions.ValueLength;
import co.javeriana.taller.Shared.Domain.StringValueObject;

public class LibroDescription extends StringValueObject {

    private LibroDescription(){}
    public LibroDescription(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value){
        valueLength(value);
    }

    private void valueLength(String value){
        if(value.length() > 200){
            throw new ValueLength("\nMáximo 200 Caracteres Permitidos como Descripcion del Libro");
        }
    }


}
