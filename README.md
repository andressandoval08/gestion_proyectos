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


## Conexion a BD
Mediante la siguiente ruta (src\main\resources\application.properties) se debe configurar unicamente el username y contraseña de acuerdo a su MySQL ya que si las credenciales no son las correctas se generara un error de conexion con la base de datos 

## Estructura 
Se crearon 5 paquetes:
1. Modelo: en el cual se crearon las tablas con las respectivas relaciones vistas en el esquema (Usuario, Proyecto, para la base de datos 
 










