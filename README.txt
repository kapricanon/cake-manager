Cake Manager
============

This application demonstrates a Cake Manager service which allow users to view list of cakes,
add new cakes, update cakes & delete cakes.

This is a demo application using Spring Boot for exposing the REST APIs and React to build
the UI which consumes the backend APIs to perform CRUD operation.

This project can further be enhanced to containerised using Docker.

This project can also be enhanced further by integrating it with OAuth2 for security by using
Keycloak or other oAuth providers or even integrated with 3rd Party like GitHub or Google, etc.


Running The Project
===================

This is a maven based application. Both Spring Boot and React resources are packed into one
runnable jar using maven plugins.

In order to run the project simply execute: 'mvn spring-boot:run' in the root of the project using
command line and then open 'http://localhost:8080' on a browser.

