

# Basic Calculator API
Overview
This project is a simple Basic Calculator implemented in Java and exposed via a REST API. It performs basic arithmetic operations like addition, subtraction, multiplication, and division.

The calculator follows a RESTful architecture, allowing easy interaction via HTTP requests. The API is built using Spring Boot, which simplifies the process of creating REST services in Java.

# Features
-Addition: Adds two numbers.
-Subtraction: Subtracts one number from another.
-Multiplication: Multiplies two numbers.
-Division: Divides one number by another (with error handling for division by zero).

# Endpoints
HTTP Method	Endpoint	Description	Parameters
GET	/api/v1/calculate/add	Adds two numbers	num1, num2
GET	/api/v1/calculate/sub	Subtracts one number from another	num1, num2
GET	/api/v1/calculate/mul	Multiplies two numbers	num1, num2
GET	/api/v1/calculate/div	Divides one number by another	num1, num2 (returns error for division by zero)

# Technologies Used
Java: Core programming language.
Spring Boot: Framework for building REST APIs.
Maven: Dependency management and build automation.
JUnit: For unit testing.

# Setup
Prerequisites
Java 17 or higher
Maven 3.x
Any IDE that supports Java (e.g., IntelliJ IDEA, Eclipse)

