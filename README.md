# *SOFTWARE DE GESTION DE PROYECTOS*
**Realizado con java y el framework de spring boot versiones:**
- Java version "17.0.6" 2023-01-17 LTS
- id 'org.springframework.boot' version '3.2.3'

**dependencias utilizadas son:**
1. Spring Web: Soporte para el desarrollo de aplicaciones y páginas webs basadas en Java
2. JPA: API de persistencia desarrollada para la plataforma Java EE. Maneja datos relacionales en aplicaciones usando la Plataforma Java.
3. MySQL driver: Permite comunicarnos con el motor de base de datos,
4. Lombok: librería para Java que proporciona anotaciones y funciones para reducir la cantidad de código (ejemplo getters and setters)


## Esquema de base de datos 

![image](https://github.com/andressandoval08/gestion_proyectos/assets/124326168/c013f358-5c7c-4c88-a072-98577aa52f92)


## Conexion a BD y ejecucion del proyecto
Mediante la siguiente ruta (**src\main\resources\application.properties**) se debe configurar unicamente el username y contraseña de acuerdo a su MySQL ya que si las credenciales no son las correctas se generara un error de conexion con la base de datos.
Despues de realizar esto, para la ejecucion se debe estar parado en la clase (**src\main\java\asandovalarq\gestorproyectos\GestorproyectosApplication.java**) donde esta realizara la creacion de la base de datos con sus respectivas tablas. 


## Estructura 
Se crearon 5 paquetes:
1. Modelo: En el cual se crearon las tablas con las respectivas relaciones vistas en el esquema (Usuario, Proyecto, AsignacionProyectoUsuario, HistoriaUsuario y Tarea) para la base de datos. No se agrega Id, ya que se utilizo una anotacion de Springboot para que se realice de manera incremental **@GeneratedValue(strategy = GenerationType.IDENTITY)**.

2. Repositorio: En esta Interfaz de repositorios proporcionamos los metodos CRUD a travez de "JpaRepository" lo cual añade un metodos de consulta personalizados, implementados automaticamente por Spring Data JPA en tiempo de ejecucion.

3. Servicio: Encapsular la logica relacionada a cada modelo, proporcionando los metodos para interactuar con la base de datos.

4. Controlador: Manejar las solicitudes relacionadas a los modelos interactuando con su respectivo servicio.

5. Excepciones: Mostrar un mensaje por si hay algun error con el proyecto  
 
Asi mismo la ruta Test: src\test\java\asandovalarq\gestorproyectos\controladorTest\ControladorTest.java

## DOCUMENTACION POSTMAN
Subidas en avata.










