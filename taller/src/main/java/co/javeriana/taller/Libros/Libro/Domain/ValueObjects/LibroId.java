package co.javeriana.taller.Libros.Libro.Domain.ValueObjects;

import co.javeriana.taller.Shared.Domain.CustomUUID;

public class LibroId extends CustomUUID {
    private LibroId(){}

    public LibroId(String value){super(value);}
}
