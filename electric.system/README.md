# Electric System RESTful API

## Introduction

This project is a RESTful API for managing user information in an electric system. It provides endpoints to retrieve, create, update, and delete user records. The API is built using Spring Boot and Java.

## How to Run

### Running from Terminal

#### Windows

1. Open Command Prompt.
2. Navigate to the project directory.
3. Run the following command:

```bash
mvnw spring-boot:run
```


#### macOS and Linux

1. Open Terminal.
2. Navigate to the project directory.
3. Run the following command:

```bash
./mvnw spring-boot:run
```


### Running from Eclipse IDE

1. Open Eclipse IDE.
2. Import the project into Eclipse.
3. Right-click on the project folder in the Project Explorer.
4. Go to `Run As` > `Spring Boot App`.

## Endpoints

The API provides the following endpoints:

- `GET /api/users`: Retrieve all users.
- `GET /api/users/{id}`: Retrieve a user by ID.
- `POST /api/users`: Create a new user.
- `PUT /api/users/{id}`: Update an existing user.
- `DELETE /api/users/{id}`: Delete a user by ID.

## Testing

The project includes unit tests for the controller layer using Mockito and Spring MockMvc. To run the tests, navigate to the `src/test/java` directory and run the test classes.

## Dependencies

The project uses the following dependencies:
- Spring Boot
- Spring Data JPA
- MySQL Database (Create Mode, Can be set to update mode to permanently store data)
- Mockito
- Jackson (for JSON serialization/deserialization)
- Maven

## Contributing

Contributions are welcome! If you have suggestions, enhancements, or bug fixes, please open an issue or create a pull request.

