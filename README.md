# RESTful service using Spring MVC and Spring Boot with JPA

## Overview 

The application here presented is a simple RESTFul service that performs CRUD operations on top of a relational memory database.
The relational database represent three entities, City, State and Country where Country has one to many relationships with State and State one to many relationships with City.
For this I built a Maven project using Spring Boot framework configured with Spring MVC. The application is deployed in an embedded Tomcat and access a HSQLDB in memory database through Hibernate.

## Data and Entities

There is a file to populate the database once the application starts (data.sql).

Entities were created using JPA/Hibernate annotation and are under package **com.world.entities** .

Under **com.world.repository** you can find interfaces that make the CRUD possible using Spring. I have added one more method to the CityRepository for integration tests purposes.
 
## Tests

As Spring Boot helps a lot with the CRUD operations a natural path is perform Integration Tests instead Unit Tests since mocking would take a large part on it.
I created a class called ApplicationTests.java where all the Integration tests are maintained.
They test all operations from all CRUD (Country, State and City).
To run automated tests, go to the project root folder and execute the following command on your terminal:

> mvn test

## Running the application

Make sure you do not have any server running on port 8080, that is where Tomcat will make available our application. To run, go to project root folder and type on your terminal:

> mvn spring-boot:run

## Executing REST API commands

You can use applications like **curl** to perform the following calls on your terminal.

### City CRUD:

> **CREATE:** curl -i -X POST -H "Content-Type:application/json" -d '{"name": "São Carlos","state": "SP"}' localhost:8080/cities

> **READ:** curl localhost:8080/cities/1

> **UPDATE:** curl -i -X PUT -H "Content-Type:application/json" -d '{ "name" : "Carlos São", "state": "SP" }' localhost:8080/cities/4

> **DELETE:** curl -i -X DELETE -H "Content-Type:application/json" -d '{}' localhost:8080/cities/4

### State CRUD:

> **CREATE:** curl -i -X POST -H "Content-Type:application/json" -d '{"initials": "MG", "name": "Minas Gerais","country": "BR"}' localhost:8080/states

> **READ:** curl localhost:8080/states/MG

> **UPDATE:** curl -i -X PUT -H "Content-Type:application/json" -d '{ "initials" : "MG", "name": "Climbing State", "country": "BR"}' localhost:8080/states/MG

> **DELETE:** curl -i -X DELETE -H "Content-Type:application/json" -d '{}' localhost:8080/states/MG

### Country CRUD:

> **CREATE:** curl -i -X POST -H "Content-Type:application/json" -d '{"initials": "AR", "name": "Argentina"}' localhost:8080/countries

> **READ:** curl localhost:8080/countries/AR

> **UPDATE:** curl -i -X PUT -H "Content-Type:application/json" -d '{ "initials" : "AR", "name": "Maradona country"}' localhost:8080/countries/AR

> **DELETE:** curl -i -X DELETE -H "Content-Type:application/json" -d '{}' localhost:8080/countries/AR