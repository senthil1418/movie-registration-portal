# Movie Registration Portal

This is a Spring Boot project for a Movie Registration Portal. It allows users to add new movies and retrieve movies by ID.

## Project Structure

The project follows the following structure:

```
movie-registration-portal
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── abc
│   │   │           └── movie
│   │   │               ├── MovieRegistrationPortalApplication.java
│   │   │               ├── controller
│   │   │               │   └── MovieController.java
│   │   │               ├── service
│   │   │               │   └── MovieService.java
│   │   │               ├── repository
│   │   │               │   └── MovieRepository.java
│   │   │               └── model
│   │   │                   └── Movie.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── schema.sql
│   ├── test
│       ├── java
│       │   └── com
│       │       └── abc
│       │           └── movie
│       │               ├── controller
│       │               │   └── MovieControllerTest.java
│       │               └── service
│       │                   └── MovieServiceTest.java
│       └── resources
├── pom.xml
└── README.md
```

## Getting Started

To run the project, follow these steps:

1. Clone the repository.
2. Set up a MySQL database and update the `application.properties` file with the database connection details.
3. Run the `schema.sql` file to create the necessary table in the database.
4. Build the project using Maven: `mvn clean install`.
5. Run the Spring Boot application: `mvn spring-boot:run`.

## Usage

Once the application is running, you can use the following endpoints to interact with the Movie Registration Portal:

- `POST /movies`: Add a new movie to the database.
- `GET /movies/{id}`: Retrieve a movie by its ID.

## Testing

The project includes test cases for the controller and service classes. To run the tests, use the following command:

```bash
mvn test
```

## Dependencies

The project uses the following dependencies:

- Spring Boot 3.2.9
- Spring Data JPA
- MySQL Connector
- JUnit 5

For more details, please refer to the `pom.xml` file.

```

This is the contents of the README.md file for the Movie Registration Portal project.