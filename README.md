
<p align="center">
    <img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" align="center" width="30%">
</p>
<p align="center"><h1 align="center">MICROSERVICE-EXAMPLE</h1></p>
<p align="center">
	<em><code>❯ REPLACE-ME</code></em>
</p>
<p align="center">
	<img src="https://img.shields.io/github/license/nriteshranjan/Microservice-Example?style=default&logo=opensourceinitiative&logoColor=white&color=0080ff" alt="license">
	<img src="https://img.shields.io/github/last-commit/nriteshranjan/Microservice-Example?style=default&logo=git&logoColor=white&color=0080ff" alt="last-commit">
	<img src="https://img.shields.io/github/languages/top/nriteshranjan/Microservice-Example?style=default&color=0080ff" alt="repo-top-language">
	<img src="https://img.shields.io/github/languages/count/nriteshranjan/Microservice-Example?style=default&color=0080ff" alt="repo-language-count">
</p>
<p align="center"><!-- default option, no dependency badges. -->
</p>
<p align="center">
	<!-- default option, no dependency badges. -->
</p>
<br>

# Project Overview

This project is built using Spring Boot and microservices architecture, utilizing various tools and technologies to ensure efficient account management, service discovery, and test automation. Below is an overview of the key components, tools, and technologies used in this project.

## Components

### **Accounts Service**
Manages account details and provides a standardized interface for interacting with the database.

- **Repository**: Defines the data access layer for account management and simplifies CRUD operations.
  - **Tool**: [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-configuration)
  
- **Model**: Provides a data model for accounts, including attributes like account number, customer ID, and account type.
  - **Tool**: [Java Persistence API (JPA)](https://docs.oracle.com/javaee/7/api/javax/persistence/JPA.html)
  
- **Service**: Centralized interface for managing accounts and integrating with the repository.
  - **Tool**: [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-data-jpa)

### **Gateway Service**
Acts as the entry point for service discovery and routing in a microservices-based system.

- **Application**: Bootstraps the Spring Boot application, enabling discovery client functionality.
  - **Tool**: [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-service-registration)
  
- **Service Registry**: Central registry for service discovery using Eureka server.
  - **Tool**: [Eureka Server](https://github.com/Netflix/eureka/wiki/Eureka-Server-Documentation)

### **Eureka Server**
A core component enabling service discovery for the microservices ecosystem.

- **Application**: Launches the Eureka server to enable service registration and discovery.
  - **Tool**: [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-service-registration)
  
- **Service Registry**: Central registry for service discovery using Eureka.
  - **Tool**: [Eureka Server](https://github.com/Netflix/eureka/wiki/Eureka-Server-Documentation)

## Tests

### **Gateway Service Application Tests**
Ensures the core functionality of the gateway service is properly initialized and loaded.

- **Test Suite**: Foundation for testing the Gateway Service application.
  - **Tool**: [JUnit](https://junit.org/junit5/docs/current/user-guide/)

### **Eureka Server Application Tests**
Foundation for testing the Eureka server application.

- **Test Suite**: Ensures proper initialization and functionality of the Eureka server.
  - **Tool**: [JUnit](https://junit.org/junit5/docs/current/user-guide/)

## Technologies Used

- **Spring Boot**: A framework for building production-ready applications.
- **Spring Data JPA**: Simplifies database interactions through the repository pattern.
- **Java Persistence API (JPA)**: Manages relational data in Java applications.
- **Eureka Server**: Provides service registration and discovery.
- **JUnit**: A framework for writing and running tests in Java.

## Getting Started

### Prerequisites

- Java 11 or later
- Maven or Gradle
- Docker (for Eureka Server)

### Running the Application

1. Clone the repository.
2. Build the application using Maven or Gradle.
3. Run the Eureka server.
4. Run the Gateway service and Accounts service.
5. Access the application via the configured endpoints.

For detailed setup instructions, refer to the respective service documentation.

## License

This project is licensed under the MIT License.
