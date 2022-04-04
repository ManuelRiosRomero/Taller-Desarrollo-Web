package co.javeriana.taller.Libros.Libro.Domain;

import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.*;

import java.util.HashMap;

public class Libro {

    private LibroDescription descripcionLibro;
    private LibroNombreAutor nombreAutor;
    private LibroNumPaginas numPaginas;
    private LibroPrecio precio;
    private LibroPublicationDate publicationDate;
    private LibroTitulo titulo;

    public Libro(LibroDescription descripcionLibro, LibroNombreAutor nombreAutor, LibroNumPaginas numPaginas,
                 LibroPrecio precio, LibroPublicationDate publicationDate, LibroTitulo titulo) {
        this.descripcionLibro = descripcionLibro;
        this.nombreAutor = nombreAutor;
        this.numPaginas = numPaginas;
        this.precio = precio;
        this.publicationDate = publicationDate;
        this.titulo = titulo;
    }

    public static Libro create(LibroDescription descripcionLibro, LibroNombreAutor nombreAutor,
                               LibroNumPaginas numPaginas, LibroPrecio precio, LibroPublicationDate publicationDate,
                               LibroTitulo titulo) {
        Libro nuevo = new Libro(descripcionLibro, nombreAutor, numPaginas, precio, publicationDate, titulo);
        return nuevo;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("descripcionLibro", descripcionLibro.value());
            put("nombreAutor", nombreAutor.value());
            put("numPaginas", numPaginas.value());
            put("precio", precio.value());
            put("publicationDate", publicationDate.value());
            put("titulo", titulo.value());
        }};
        return data;
    }


}
