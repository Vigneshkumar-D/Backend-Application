
# Spring Boot Application with User Authentication and Authorization
Spring Boot Application with User Authentication and Authorization
This is a sample Spring Boot application that demonstrates user creation, authentication, and authorization using JSON Web Tokens (JWT).

## Features
* User Creation: Users can create an account by providing their email and password. The password is securely hashed and stored in the database.
* User Authentication: Users can authenticate by providing their email and password. Upon successful authentication, a JWT token is generated and returned.
* Authorization with JWT: Protected routes can be accessed by providing the JWT token in the request headers. The token is verified to ensure the user has the necessary permissions.

## Prerequisites
Before running the application, ensure the following prerequisites are met:
* JDK 8 or higher
* Maven
* H2Database

## Getting Started
### Clone the repository:
bash
Copy code
git clone https://github.com/Vigneshkumar-D/Backend-Application.git

### Build the Application:
bash
- Copy code
- cd your-repo
- mvn clean install

### Run the Application:
arduino
- Copy code
- mvn spring-boot:run
### Access the Application:
Open your browser and visit http://localhost:8080.

## API Endpoints
### The following API endpoints are available:

* POST /api/users/signup: Create a new user account by providing the email and password.
* POST /api/users/login: Authenticate and receive a JWT token by providing the email and password.
* GET /api/users/: Navigate to home page (protected route).
Please refer to the application code and documentation for more details on the API endpoints, request/response structures, and authentication/authorization mechanisms.

## Technologies Used
* Spring Boot
* Spring Security
* JSON Web Tokens (JWT)
* H2Database

## Resources
* Spring Boot Documentation (https://spring.io/projects/spring-boot/)
* Spring Security Documentation (https://spring.io/projects/spring-security)
* JSON Web Tokens (JWT) Introduction (https://jwt.io/introduction)
