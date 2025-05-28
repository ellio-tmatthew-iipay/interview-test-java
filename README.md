# Interview Test Application

This is a small REST API application designed for use in a live coding interview session.

## Features

- In-memory H2 database with three tables: users, products, and product_prices
- Support for two user types: regular users and managers
- Product prices vary by country and user type (regular or manager)
- Automatic database initialization with sample data on startup

## Technical Stack

- Java 11
- Spring Boot 2.7.18
- Spring Data JPA
- H2 (in-memory database)
- JUnit 5 and Mockito for testing

## Running the Application

To run the application, use the following command:

```bash
mvn spring-boot:run
```

The application will start on port 8080.

## Sample Data

The application is initialized with the following sample data:

### Users
- Regular User (username: "regular_user", type: REGULAR)
- Manager User (username: "manager_user", type: MANAGER)

### Products
- Laptop (id: 1, name: "Laptop", description: "High-performance laptop")
- Smartphone (id: 2, name: "Smartphone", description: "Latest smartphone model")
- Tablet (id: 3, name: "Tablet", description: "Portable tablet")

### Product Prices
- Laptop prices:
  - US: $999.99 (regular), $899.99 (manager)
  - UK: $899.99 (regular), $799.99 (manager)
  - EU: $949.99 (regular), $849.99 (manager)
- Smartphone prices:
  - US: $699.99 (regular), $649.99 (manager)
  - UK: $649.99 (regular), $599.99 (manager)
  - EU: $679.99 (regular), $629.99 (manager)
- Tablet prices:
  - US: $499.99 (regular), $449.99 (manager)
  - UK: $459.99 (regular), $409.99 (manager)
  - EU: $479.99 (regular), $429.99 (manager)

## Interview Task

The candidate will be asked to implement the logic for the price endpoint, which should:
1. Filter prices by country and optionally by product
2. Return the appropriate price based on the user type (regular or manager)