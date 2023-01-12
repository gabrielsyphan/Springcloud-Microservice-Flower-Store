# Springcloud Microservices - Flower Store
This is a Flower store created in a microservice architecture using Springboot, Eureka, Ribbon, OpenFeign, Config Service and so on.

## Configuration
You should have Docker compose, Maven and JDK 17 installed on your machine.

* On root folder, run `docker-compose up -d` to start the database.
* On each microservice folder, run `mvn clean install` to build the microservice.
* On each microservice folder, run `mvn spring-boot:run` to start the microservice.

## Microservices
* [Eureka](http://localhost:8761)
* [Config Service](http://localhost:8888)
* [API Gateway](http://localhost:8880)
* [Flower Store](http://localhost:8080)
* [Flower Provider](http://localhost:8081)

## API
* [Flower Store](http://localhost:8080/swagger-ui.html)
* [Flower Provider](http://localhost:8081/swagger-ui.html)

## Contributors
* [Gabriel Syphan](https://github.com/gabrielsyphan)
