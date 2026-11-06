# SMS - Sales Management System

A Spring Boot-based application scaffold for a Sales Management System (SMS). The project currently includes the base Maven/Spring Boot setup for a web application with persistence, validation, and messaging support, making it a solid foundation for building a complete sales platform.

## Overview

SMS is designed to help manage core sales operations such as:

- customer records
- product catalog and inventory
- sales orders and order tracking
- reporting and business insights
- internal workflow automation

The repository is currently in its early stage and provides the Java/Spring Boot foundation needed to expand into a full-featured sales application.

## Tech Stack

- Java 24
- Spring Boot 3.5.3
- Maven
- Spring Web
- Spring Data JPA
- Thymeleaf
- Validation API
- RabbitMQ / AMQP support
- H2 in-memory database
- Lombok

## Project Structure

```text
SMS/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── .mvn/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Prerequisites

Before running the project, make sure you have the following installed:

- JDK 24 or newer
- Maven (or use the included Maven wrapper)
- Git

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/Milki7/SMS.git
cd SMS
```

2. Build the project:

```bash
./mvnw clean install
```

3. Run the application:

```bash
./mvnw spring-boot:run
```

4. Open the application in your browser:

```text
http://localhost:8080
```

## Configuration

The application configuration is stored in:

```text
src/main/resources/application.properties
```

This file is the default place to configure:

- server port
- database settings
- JPA configuration
- Spring Boot application properties

## Current Status

This repository is a starter project for a sales management system. It includes the core Spring Boot scaffolding and dependencies, but additional domain logic, controllers, services, and UI layers are expected to be added as the system grows.

## Roadmap

Planned areas for future development may include:

- customer management module
- inventory and stock control
- order processing and invoice generation
- sales analytics dashboards
- authentication and authorization
- REST API endpoints for frontend integration
- deployment configuration for production

## Contributing

Contributions are welcome. If you want to improve the project:

1. create a feature branch
2. make your changes
3. open a pull request with a clear summary

## License

No explicit license file is currently included in the repository, so license terms should be confirmed before production use or redistribution.
