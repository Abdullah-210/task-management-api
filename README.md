# Secure Task Management API

A secure REST API built with Spring Boot for managing tasks.

## Features:
- User registration
- User login
- JWT authentication
- BCrypt password encryption
- CRUD Operations for tasks
- MySQL database

## Installation:
1. Clone the repository 
2. Open the project in your preferred Java IDE (I used IntelliJ IDEA)
3. Create a MySQL database named: taskmanager
4. Update your MySQL credentials in application.properties
5. Run the application
6. Access the API at: http://localhost:8080

## Testing
Can be tested using Postman.
Example endpoints:
- POST http://localhost:8080/auth/register
- POST /auth/login
- GET /tasks
- POST /tasks
- PUT /tasks/{id}
- DELETE /tasks/{id}

Author:
Abdullah
