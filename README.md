# Backend Developer Challenge

This project is a service developed using Java Spring Boot and documented in Swagger. It is deployed on AWS and the code was uploaded on Github.

## Endpoints

### POST /creacliente
- Nombre / Name
- Apellido / Surname
- Edad / Age
- Date of birth / Fecha de Nacimiento

#### URL
- Local: http://localhost:8080/creacliente
- AWS: http://54.94.163.115:8080/creacliente

### GET /kpideclientes
- Average age among all clients / Edad promedio de los clientes
- Standard deviation of ages among all clients / Desviacion Estandar de las edades de todos los clientes

#### URL
- Local: http://localhost:8080/kpideclientes
- AWS: http://54.94.163.115:8080/kpideclientes

### GET /listclientes
- List of people with all the details including the probable date of death of each one. / Listado de personas incluyendo su fecha probable de muerte

#### URL
- Local: http://localhost:8080/listclientes
- AWS: http://54.94.163.115:8080/listclientes

### POST /auth/signup
- Create a user in order to be able to access the applications endpoints.

#### URL
- Local: http://localhost:8080/signup
- AWS: http://54.94.163.115:8080/auth/signup

### POST /auth/signin
- Access with your user in order to obtain the bearer token.

#### URL
- Local: http://localhost:8080/signin
- AWS: http://54.94.163.115:8080/auth/signin

## Considerations
Please take into account that the project uses Spring security so in order to access the endpoints, you should have a bearer token.

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
- Local: http://localhost:8080/swagger-ui/index.html
- AWS: http://54.94.163.115:8080/swagger-ui/index.html
```

## Deployment
This application is deployed on AWS. The code is available on Github.

## Contributors
- Alfredo Ezequiel Giussani.