# Equipment Rental Service

This project is a Spring Boot application designed for managing an equipment rental service. It provides RESTful APIs for booking equipment, managing the equipment catalog, and handling administrative tasks.

## Project Structure

The project is organized as follows:

```
server/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── equipmentrental/
│   │   │           ├── Application.java                  # Main entry point
│   │   │           ├── config/                           # Configuration classes
│   │   │           ├── controller/                       # REST Controllers
│   │   │           ├── service/                          # Business logic
│   │   │           ├── repository/                       # Data access
│   │   │           ├── model/                            # Database entities
│   │   │           ├── dto/                              # Data Transfer Objects
│   │   │           └── exception/                        # Error handling
│   │   └── resources/                                     # Configuration files
│   └── test/                                             # Unit tests
├── Dockerfile                                            # Containerization
├── pom.xml                                               # Maven configuration
└── .gitignore                                            # Git ignore file
```

## Features

- **Booking Management**: Create, update, and manage equipment bookings.
- **Catalog Management**: View and manage the available equipment for rent.
- **Admin Operations**: Perform administrative tasks such as user management and reporting.
- **Payment Integration**: Handle payment processing for bookings.

## Getting Started

To run the application, follow these steps:

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```
   cd server
   ```

3. Build the project using Maven:
   ```
   mvn clean install
   ```

4. Run the application:
   ```
   mvn spring-boot:run
   ```

## Configuration

The application uses MongoDB for data storage. Update the `application.properties` file with your MongoDB connection details.

## Testing

Unit tests are provided for controllers, services, and repositories. To run the tests, use the following command:
```
mvn test
```

## License

This project is licensed under the MIT License. See the LICENSE file for details.