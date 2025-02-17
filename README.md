# chat-app
Real-time chat application using Spring Boot and React  

# Chat App - Backend  

## Overview  
Chat App is a **scalable, real-time messaging platform** built with **Java 17** and **Spring Boot 3**. It enables secure communication through **JWT authentication** and **WebSockets**, with a structured backend architecture for **maintainability and scalability**. The API is documented using **Swagger** for easy testing and integration.  

## Technologies Used  
- **Java 17**  
- **Spring Boot 3**  
- **Spring Security** (JWT Authentication)  
- **MySQL** (Relational Database)  
- **WebSockets** (Real-time Communication)  
- **Swagger** (API Documentation)  
- **Maven** (Dependency Management)  

## Key Features  
- **JWT Authentication**: Secure authentication using JSON Web Tokens.  
- **Real-time Chat**: Implemented with **WebSockets** for instant communication.  
- **Group Chat Management**: Users can create and manage group chats.  
- **Message History**: All messages are stored in a MySQL database.  
- **Notification System**: Alerts users about new messages.  
- **Swagger API Documentation**: Interactive API documentation for testing.  

## API Documentation  
The API is documented using **Swagger**, accessible at:  
**`http://localhost:8080/swagger-ui.html`**  

## Deployment & Scalability  
- **Containerized with Docker** for easy deployment.  
- **Hosted on AWS EC2** with **RDS MySQL** for database management.  
- **Designed for Microservices Readiness**, allowing future scalability.  

## Security & Best Practices  

- **BCrypt password hashing** for secure credential storage.  
  - Although the provided code does not explicitly include password hashing, it is recommended to use **BCrypt** in other parts of the project, such as user registration and authentication, to ensure secure storage of passwords.

- **Role-Based Access Control (RBAC)** to manage user permissions.  
  - The code implements role-based access control (RBAC) by storing user permissions in the JWT. These permissions are extracted from the JWT token in the `JwtValidatorFilter` class, enabling secure management of different roles and permissions.

- **Exception Handling & Logging** for better maintainability.  
  - The code currently handles exceptions, such as when an invalid JWT token is provided, but **the logging implementation could be improved**. Instead of using `System.out.println()`, it is recommended to use a logging framework like **SLF4J** or **Logback** to log events and errors in a more structured and effective way, which improves maintainability and traceability in production environments.

- **JWT Expiry & Token Renewal** for session security.  
  - JWT tokens have an expiration time configured, which is a good security practice. However, implementing a **token renewal** (refresh token) mechanism would be a valuable improvement to keep the user's session active securely, without the need to reauthenticate.

- **Secure Storage of JWT Key**  
  - The key used to sign JWT tokens (`JWT_KEY`) is currently hardcoded in the source code. To ensure better security, this key should be stored securely, such as in **environment variables** or a **secrets management service** like **AWS Secrets Manager**, to prevent accidental exposure of the key in public repositories or insecure environments.

## System Architecture  
This project follows a **Layered Architecture (MVC - Model-View-Controller pattern)** to separate concerns and improve scalability.  

### **Architecture Layers**  
1. **Controller (Presentation Layer)**  
   - Handles HTTP requests and interacts with the service layer.  
   - Implements **RESTful API endpoints** using **Spring MVC**.  
   - Example: `AuthController.java`, `ChatController.java`.  

2. **Service (Business Logic Layer)**  
   - Contains the business logic of the application.  
   - Implements **transaction management** and **data processing**.  
   - Example: `ChatServiceImplementation.java`, `UserServiceImplementation.java`.  

3. **Repository (Data Access Layer - DAO)**  
   - Handles database operations with **Spring Data JPA**.  
   - Example: `ChatRepository.java`, `UserRepository.java`.  

4. **Model (Domain Entities)**  
   - Defines data structures and database mappings using **JPA/Hibernate**.  
   - Example: `User.java`, `Chat.java`, `Message.java`.  

5. **Security (Authentication & Authorization)**  
   - Implements **JWT-based authentication** with **Spring Security**.  
   - Ensures **role-based access control (RBAC)** and secure token handling.  
   - Example: `JwtTokenProvider.java`, `JwtGeneratorFilter.java`.  

6. **WebSockets (Real-time Communication)**  
   - Implements **real-time messaging** support.  
   - Example: `WebSocketConfig.java`, `RealTimeChat.java`.  
