# Layered Architecture Version – To-Do CRUD

This branch contains a simple To-Do CRUD application implemented using a layered architecture approach with Spring Boot.

## Description

The application is structured into distinct layers, each with a specific responsibility:

- **Controller** → Handles HTTP requests and responses
- **Service** → Contains business logic and validation
- **Repository** → Manages data access (in-memory)
- **Model** → Defines the data structure

## Characteristics

- Clear separation of concerns
- Low coupling between components
- Improved readability and organization
- Easier to maintain and extend
- Better testability

## Purpose

This version demonstrates how the same functionality can be implemented using a clean and maintainable structure.

It is intended to be compared with the spaghetti version to highlight the benefits of layered architecture in terms of scalability, readability, and code quality.
