package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Libros.Libro.Domain.Exceptions.ValueLength;
import co.javeriana.taller.Shared.Domain.IntegerValueObject;

public class LibroNumPaginas extends IntegerValueObject {

    public LibroNumPaginas(Integer value) {
        //validate(value);
        this.value = value;
    }

    /**
    private void validate(Integer value){
        valueLength(value);
    }
    **/

}
