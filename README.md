# Secure Task Management API

A secure REST API built with Spring Boot for task management and user authentication.

## Features

* User Registration & Login
* JWT Authentication
* BCrypt Password Encryption
* CRUD Operations for Tasks
* User-Specific Task Management
* MySQL Database
* Cloud Deployment on Render

## Technologies

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* MySQL
* JWT
* Maven

## Live Demo

https://task-management-api-u91w.onrender.com

## Running Locally

1. Clone the repository.
2. Create a MySQL database.
3. Configure your database credentials.
4. Run:

```bash
./mvnw spring-boot:run
```

## API Endpoints

### Authentication

* POST `/auth/register`
* POST `/auth/login`

### Tasks

* GET `/tasks`
* POST `/tasks`
* PUT `/tasks/{id}`
* DELETE `/tasks/{id}`

> Protected endpoints require a valid JWT token.

## Testing

The API can be tested using Postman. After logging in, copy the JWT token and use:

```txt
Auth → Bearer Token → Paste Token
```

