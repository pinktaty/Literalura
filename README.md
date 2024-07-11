# Third Oracle ONE Program's project

## Description

This project is a library management application developed in Java with the Spring Framework. 
Its purpose is to connect to the Gutendex API to fetch information about books and their authors in a JSON format. This data is processed using JsonAlias annotations, stored into a PostgreSQL database via Jakarta Persistence API (allowing and using CRUD operations through Spring Data JPA), and presented to the user through a command-line interface.

## Structure
- `./src/main/java/com/pinktaty/literalura/LiteraluraApplication.java`: Program's entry point.

### Model
- `./src/main/java/com/pinktaty/literalura/model/BookFound.java`: Record class used for parsing the response received from the API in JSON format using JsonAlias.
- `./src/main/java/com.pinktaty.literalura/model/BookRecord.java`: Record class used for representing book data received in JSON format using JsonAlias.
- `./src/main/java/com.pinktaty.literalura/model/Book.java`: JPA entity that allows mapping of books to a database table.
- `./src/main/java/com.pinktaty.literalura/model/AuthorRecord.java`: Record class used for representing author data received in JSON format using JsonAlias.
- `./src/main/java/com.pinktaty.literalura/model/Author.java`: JPA entity that allows mapping of authors to a database table.
- `./src/main/java/com.pinktaty.literalura/model/Library.java`: Spring component that encapsulates the business logic of the app.

#### Service
- `./src/main/java/com/pinktaty/literalura/service/Api.java`: Class that connects with the Gutendex API and receives its response.
- `./src/main/java/com.pinktaty.literalura/service/IConvertData.java`: Interface designed to provide a generic method for converting JSON data into Java objects.
- `./src/main/java/com.pinktaty.literalura/service/ConvertData.java`: Class that implements the IConvertData interface, providing functionality to convert JSON data into Java objects using the Jackson library.

#### Repository
- `./src/main/java/com.pinktaty.literalura/repository/BookRepository.java`: Spring Data JPA repository for managing Book entities, defining custom query methods for database interactions.
- `./src/main/java/com.pinktaty.literalura/repository/AuthorRepository.java`: Spring Data JPA repository for managing Author entities, defining custom query methods for database interactions.

### View
- `./src/main/java/com/pinktaty.literalura/view/Menu.java`: Spring component that provides the menu user interface for interacting with the library system.
- `./src/main/java/com.pinktaty.literalura/view/LibraryView.java`: Spring component that handles the presentation logic for displaying information about the books and authors.

### Controller
- `./src/main/java/com.pinktaty.literalura/controller/LibraryController.java`: Spring controller that coordinates the user interaction flow, business logic, and presentation of data for the app.

## Observations

For the correct execution of the application, make sure to create a PostgreSQL database named "library" and add the username and password for managing it to the file 
```bash
./src/main/resources/application.properties.
```

* * *

# Proyecto 03 del programa Oracle ONE

## Descripción

Este proyecto es una aplicación de gestión de bibliotecas desarrollada en Java con Spring Framework. 
Su función es conectarse a la API de Gutendex para obtener información sobre libros y autores de los mismos en formato JSON; la cual es procesada por medio de JsonAlias, guardada en una base de datos PostgreSQL por medio de Jakarta Persistence API (permitiendo y usando operaciones CRUD a través de Spring Data JPA) y presentada al usuario a través de una interfaz de línea de comandos. traducelo a ingles

## Estructura
- `./src/main/java/com/pinktaty/literalura/LiteraluraApplication.java`: Punto de entrada del programa.

### Modelo
- `./src/main/java/com/pinktaty.literalura/model/BookFound.java`: Clase de registro utilizada para extraer la respuesta recibida por la API en formato JSON usando JsonAlias.
- `./src/main/java/com.pinktaty.literalura/model/BookRecord.java`: Clase de registro utilizada para representar datos de libros recibidos en formato JSON usando JsonAlias.
- `./src/main/java/com.pinktaty.literalura/model/Book.java`: Entidad JPA que permite el mapeo de libros a una tabla de base de datos.
- `./src/main/java/com.pinktaty.literalura/model/AuthorRecord.java`: Clase de registro utilizada para representar datos de autores recibidos en formato JSON usando JsonAlias.
- `./src/main/java/com.pinktaty.literalura/model/Author.java`: Entidad JPA que permite el mapeo de autores a una tabla de base de datos.
- `./src/main/java/com.pinktaty.literalura/model/Library.java`: Conponente de Spring que encapsula la lógica de negocio de la aplicación.

#### Servicio
- `./src/main/java/com/pinktaty/literalura/service/Api.java`: Clase que se conecta con la API de Gutendex y recibe su respuesta.
- `./src/main/java/com/pinktaty/literalura/service/IConvertData.java`: Interfaz diseñada para proporcionar un método genérico para convertir datos JSON en objetos Java.
- `./src/main/java/com.pinktaty.literalura/service/ConvertData.java`: Clase que implementa la interfaz IConvertData, proporcionando funcionalidad para convertir datos JSON en objetos Java utilizando la biblioteca Jackson.

#### Repositorio
- `./src/main/java/com.pinktaty.literalura/repository/BookRepository.java`: Repositorio Spring Data JPA para gestionar entidades de libros, define métodos de consulta personalizados para interacciones con la base de datos.
- - `./src/main/java/com.pinktaty.literalura/repository/AuthorRepository.java`: Repositorio Spring Data JPA para gestionar entidades de autores, define métodos de consulta personalizados para interacciones con la base de datos.

### Vista
- `./src/main/java/com.pinktaty.literalura/view/Menu.java`: Componente Spring que proporciona la interfaz de usuario del menú para interactuar con el sistema de la biblioteca.
- `./src/main/java/com.pinktaty.literalura/view/LibraryView.java`: Componente Spring que maneja la lógica de presentación para mostrar información sobre los libros y autores.

### Controlador
- `./src/main/java/com.pinktaty.literalura/controller/LibraryController.java`: Controlador Spring que coordina el flujo de interacción del usuario, la lógica de negocio y la presentación de datos para la aplicación.

## Observaciones

Para una correcta ejecución de la aplicación asegurarse de crear una base de datos PostgreSQL llamada "library" y agregar el usario y contraseña para manejarla al archivo 
```bash
./src/main/resources/application.properties.
```
