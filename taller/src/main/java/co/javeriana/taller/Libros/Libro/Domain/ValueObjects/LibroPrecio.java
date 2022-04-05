package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Libros.Libro.Domain.Exceptions.NegativePrice;
import co.javeriana.taller.Libros.Libro.Domain.Exceptions.ValueLength;
import co.javeriana.taller.Shared.Domain.DoubleValueObject;

public class LibroPrecio extends DoubleValueObject {

    private LibroPrecio(){}

    public LibroPrecio(Double value) {
        validate(value);
        this.value = value;
    }

    private void validate(Double value){
        NegativePrice(value);
    }

    private void NegativePrice(Double value){
        if(value<0){
            throw new NegativePrice("\nEl Precio del Libro debe de ser Positivo");
        }
    }

}
