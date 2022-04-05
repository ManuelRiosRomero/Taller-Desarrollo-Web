package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Libros.Libro.Domain.Exceptions.FullName;
import co.javeriana.taller.Shared.Domain.StringValueObject;

public class LibroNombreAutor extends StringValueObject {

    private LibroNombreAutor(){}
    public LibroNombreAutor(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value){
        fullName(value);
    }

    private void fullName(String value){
        String[] nombreCompleto = value.split(" ");
        if (nombreCompleto.length != 2) {
            throw new FullName("\nEste campo solo debe tener 1 nombre y 1 apellido");
        }
    }
}
