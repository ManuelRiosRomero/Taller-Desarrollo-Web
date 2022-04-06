# Taller Desarrollo Web
Realizado por:
- Manuel Rios
- Sebastián Molano
- David Palacios
- Richard Fonseca 

## Manual de uso PostMan

1) Ejecutar las peticiones:

1.1) http://localhost:8080/libro/create: crea un libro

Body:
```json
{
    "libroId": "e2b805fa-7d07-4977-8c1b-e0b2c8353bae",
    "libroDescripcion": "Tres Anillos para los Reyes Elfos bajo el cielo. Siete para los Señores Enanos en casas..",
    "libroNombreAutor": "J Tolkien",
    "libroPrecio": "80000",
    "libroPublicationDate": "1954",
    "libroTitulo": "El señor de los Anillos"
}
```

1.2) http://localhost:8080/libro/all: lista todos los libros en la BD

Body
```json
{
}
```


1.3) http://localhost:8080/libro/autor: lista todos los libros de un autor

Body
```json
{
    "libroNombreAutor":"Palacios David"
}
```

1.4) http://localhost:8080/libro/id: lista la información de un libro por su ID

Body
```json
{
    "libroId":"89be0329-704b-4a28-8372-921ff3e53650"
}
```

