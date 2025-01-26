# Quiz Application

This is a quiz application project built using Java Spring Boot and microservice architecture. The application is designed to handle multiple services such as API Gateway, Question Service, Quiz Service, and Service Registry.

## Table of Contents

- [Introduction](#introduction)
- [Architecture](#architecture)
- [Services](#services)
  - [API Gateway](#api-gateway)
  - [Question Service](#question-service)
  - [Quiz Service](#quiz-service)
  - [Service Registry](#service-registry)
- [Getting Started](#getting-started)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Quiz Application is designed to create, manage, and take quizzes. The application leverages a microservice architecture to ensure scalability and maintainability.

## Architecture

The application is structured into the following microservices:
- **API Gateway**: Acts as an entry point for all client requests.
- **Question Service**: Manages quiz questions.
- **Quiz Service**: Manages quiz creation and participation.
- **Service Registry**: Facilitates service discovery.

## Services

### API Gateway
The API Gateway acts as the single entry point for all client requests. It routes the requests to the appropriate microservices.

### Question Service
The Question Service is responsible for managing quiz questions. It handles CRUD operations for quiz questions.

### Quiz Service
The Quiz Service manages the creation and participation of quizzes. It handles the logic for creating quizzes, retrieving quiz details, and submitting quiz answers.

### Service Registry
The Service Registry is used for service discovery. It allows microservices to find and communicate with each other.

## Getting Started

To get started with the Quiz Application, follow these steps:

1. Clone the repository:
    ```bash
    git clone https://github.com/abhishekshivgan/quiz-app-microservice.git
    ```

2. Navigate to the project directory:
    ```bash
    cd quiz-application
    ```

3. Build and run the services:
    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

## Technologies Used

- Java Spring Boot
- Microservice Architecture
- Eureka (for Service Registry)
- Zuul (for API Gateway)
- Maven

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

