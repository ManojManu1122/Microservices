Microservices Project
Overview
This project is a conversion of a previously monolithic quiz application into a microservices-based architecture. It includes the following components:

Quiz Service: Manages quiz-related operations.
Question Service: Handles questions associated with quizzes.
Service Registry: Eureka Server for service registration and discovery.
API Gateway: Routes requests to appropriate microservices and handles service discovery.
The project is an evolution of the earlier quiz application built using Spring Boot. Special thanks to Navin Reddy, whose guidance has been instrumental throughout this process.

Features
Service Registration and Discovery: Utilizes Eureka Server for managing microservice registration and discovery.
API Gateway: Centralizes access to microservices and manages routing and load balancing.
Microservices Architecture: Separates functionality into different services for better modularity and scalability.
Technologies Used
Spring Boot: Framework for building microservices.
Spring Cloud: Tools for managing microservices architecture, including Eureka for service discovery and Spring Cloud Gateway.
Eureka: Service registry for microservice discovery.
Spring Cloud Gateway: API Gateway for routing requests.
Java: Programming language used for development.
Maven: Build tool for managing dependencies and building the project.
Components
Quiz Service
Description: Manages quiz-related data and operations.
Port: 8082
Endpoints:
POST /quiz/create: Creates a quiz with question IDs based on category, number of questions, and title.
GET /quiz/get/{id}: Fetches questions by quiz ID.
POST /submit/{id}: Submits responses for the quiz.
Question Service
Description: Handles questions for quizzes.
Port: 8081
Endpoints:
GET /question/allQuestions: Retrieves all questions.
GET /question/category/{category}: Retrieves questions by category.
POST /question/add: Adds a new question.
DELETE /question/delete/{question id}: Deletes a specific question.
GET /question/generate: Generates question IDs for a quiz.
POST /question/getQuestions: Retrieves questions based on IDs for a quiz.
POST /question/getScore: Calculates the score based on responses.
Service Registry (Eureka Server)
Description: Manages service registration and discovery.
Port: 8761
URL: http://localhost:8761
API Gateway
Description: Routes requests to the appropriate microservices.
Port: 8765
URL: http://localhost:8765
