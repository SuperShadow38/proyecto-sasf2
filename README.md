# API consumption with Spring Boot, Spring Security and JWT

## Description

This project is a sample application that consumes an API implemented with Spring Boot, Spring Security and JWT (JSON Web Tokens).
## Tecnologies

- Java
- Spring Boot
- Spring Security
- JSON Web Tokens (JWT)
- HTTP Client (example, RestTemplate or WebClient)
- Swagger (Springfox) for API documentation

## Installation and configuration

1. Clone this repository on your local machine.
   ```git clone "url_repository"```
3. Create a PostgreSQL database with the name `database_name`.
4. Configure the database connection settings in the `application.properties` file:
   ```spring.datasource.url=jdbc:postgresql://localhost:5432/database_name```
   ```spring.datasource.username=your_username```
   ```spring.datasource.password=your_password```
5. Import the project into your development IDE (e.g. IntelliJ, Eclipse) as a Maven type project.

6. Configure the dependencies and project properties in the `pom.xml` file.

7. Configure the security and JWT options in the `application.properties` or `application.yml` file as appropriate.

8. Run the application from your IDE or by using the `mvn spring-boot:run` command in the terminal.

## Use

1. Open a web browser and enter the URL of the application (e.g. http://localhost:8080 or your preference server) to access the example web interface.

2. The web interface will allow you to log in with a registered user and obtain a valid JWT token.

3. Once authenticated, you will be able to access the different protected endpoints and get the API information.

4. If you want to consume the API from a client application or HTTP client, make sure to include the JWT token in the requests to the protected endpoints.

