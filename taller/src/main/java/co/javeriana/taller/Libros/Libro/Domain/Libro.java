package co.javeriana.taller.Libros.Libro.Domain;

import co.javeriana.taller.Libros.Libro.Domain.ValueObjects.*;

import java.util.HashMap;

public class Libro {

    private LibroId libroId; //String customUUID
    private LibroDescription libroDescripcion; //String
    private LibroNombreAutor libroNombreAutor;// String 2 palabras
    //private LibroNumPaginas libroNumPaginas; // Integer
    private LibroPrecio libroPrecio; //Double
    private LibroPublicationDate libroPublicationDate; //Integer sólo el año
    private LibroTitulo libroTitulo; //String


    public Libro(LibroId libroId, LibroDescription libroDescripcion, LibroNombreAutor libroNombreAutor,
                 LibroPrecio precio, LibroPublicationDate publicationDate,
                 LibroTitulo titulo) {
        this.libroId = libroId;
        this.libroDescripcion = libroDescripcion;
        this.libroNombreAutor = libroNombreAutor;
        this.libroPrecio = precio;
        this.libroPublicationDate = publicationDate;
        this.libroTitulo = titulo;
    }

    public static Libro create(LibroId libroId, LibroDescription descripcionLibro, LibroNombreAutor nombreAutor,
                               LibroPrecio precio, LibroPublicationDate publicationDate,
                               LibroTitulo titulo) {
        Libro nuevo = new Libro(libroId,descripcionLibro, nombreAutor, precio, publicationDate, titulo);
        return nuevo;
    }

    public HashMap<String, Object> data() {
        HashMap<String, Object> data = new HashMap<>() {{
            put("libroId", libroId.value());
            put("libroDescripcion", libroDescripcion.value());
            put("libroNombreAutor", libroNombreAutor.value());
            put("libroPrecio", libroPrecio.value());
            put("libroPublicationDate", libroPublicationDate.value());
            put("libroTitulo", libroTitulo.value());
        }};
        return data;
    }

    private Libro(){}


}
