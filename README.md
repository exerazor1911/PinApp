# Backend Developer Challenge

This project is a service developed using Java Spring Boot and documented in Swagger. It is deployed on AWS and the code was uploaded on Github.

## Endpoints

### POST /creacliente
- Nombre / Name
- Apellido / Surname
- Edad / Age
- Date of birth / Fecha de Nacimiento

### GET /kpideclientes
- Average age among all clients / Edad promedio de los clientes
- Standard deviation of ages among all clients / Desviacion Estandar de las edades de todos los clientes

### GET /listclientes
- List of people with all the details including the probable date of death of each one. / Listado de personas incluyendo su fecha probable de muerte

## Technologies Used
- Java
- Spring Boot
- Swagger
- AWS 

## Getting Started
To get started with this project, clone the repository and run the following command:

```
mvn spring-boot:run
```

## Documentation
The documentation for this API is available in Swagger. To access it, start the server and go to the following URL:

```
http://server:port/swagger-ui.html
```

## Deployment
This application is deployed on AWS. The code is available on Github.

## Contributors
- Alfredo Ezequiel Giussani.