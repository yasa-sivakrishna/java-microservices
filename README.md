

# Java Microservices Project

This project demonstrates a microservices architecture using Spring Boot and Spring Cloud components. It includes a Config Server, Eureka Server, and API Gateway to facilitate service registration, configuration management, and routing.

## Project Structure

The repository comprises the following modules:

* **configserver**: Centralized configuration server using Spring Cloud Config.
* **eurekaserver**: Service registry for discovering microservices using Netflix Eureka.
* **gatewayserver**: API Gateway for routing requests to appropriate microservices using Spring Cloud Gateway.

## Prerequisites

* Java 11 or higher
* Maven 3.6.0 or higher

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/yasa-sivakrishna/java-microservices.git
cd java-microservices
```



### Build the Projects

```bash
mvn clean install
```



### Run the Services

Open separate terminal windows for each service and execute the following commands:

**Config Server**

```bash
cd configserver
mvn spring-boot:run
```



**Eureka Server**

```bash
cd eurekaserver
mvn spring-boot:run
```



**Gateway Server**

```bash
cd gatewayserver
mvn spring-boot:run
```



## Configuration

Ensure that each service has the appropriate `application.properties` or `application.yml` files configured. The Config Server should point to a Git repository or local directory containing configuration files for other services.

## Service URLs

* **Config Server**: `http://localhost:8888`
* **Eureka Server**: `http://localhost:8761`
* **Gateway Server**: `http://localhost:8080`

These are the default ports; ensure they are not occupied by other applications.

