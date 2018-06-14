# Spring Boot Security With OAuth 2
This repository provides a working example of Spring Boot Security with OAuth2, and PostgreSQL.

## Getting Started
1. Clone repository
2. Download and install IntelliJ IDEA, and Java 8, and Docker, and Postman.
3. Open the project using IntelliJ IDEA.
4. Download the Lombok plugin for IntelliJ IDEA.
5. Restart IntelliJ IDEA.

## Start PostgreSQL using Docker
1. Using a terminal, navigate to the project directory.
2. Run `docker-compose up` to start the database.

## Start the Application
1. Run the Application.java class as a java application,
2. Alternatively, using IntelliJ IDEA, right-click on the Application.java class and select `Run 'Application'`  

## Execute API Methods via Postman
1. Import the `spring-boot-oauth.postman_collection.json` using Postman.
2. Use the `Request Token` method to retrieve an OAuth token.
3. Paste the token into the `access_token` field of the `Get User` method.
4. See the UserController.java class for other exposed API methods.

## Technologies used
* Spring Boot 2.0.2.RELEASE
* Java 8
* PostgreSQL 9.6