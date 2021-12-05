# Jersey 3 - Spring 5
I found it difficult to get a application up and running without Spring boot (all documentation you Google is referring to Spring Boot).

Figured I wasn't going to be the only one since the documentation is fairly criptic, so here's a running example of a Jersey 3 combined with Spring 5 application running using embedded Tomcat (without the need for Spring boot).

## FAQ
### Where can I test out the endpoints
Once you run the mainClass (Application) you'll have the application available on `localhost:8080/jersey-test/api`, there's one endpoint available here: http://localhost:8080/jersey-test/api/hello

### Application context path
The application context is set by the Application, at time of writing on line 32.

### Jersey application path
As most applications nowadays have separate front ends I've configured the API endpoints to be available in the path: `api`. This is configured in the Application as well as the `@ApplicationPath` annotation in the JerseyConfig.

### Why not use Spring Boot? It's so simple
It may seem at first, but based on professional experience I've found this not to be the case. Spring Boot is helping a lot with regards to configuration but isn't making Spring any more understandable, because most of the configuration is pretty much black magic.Next to that Spring Boot disables some quite essential configuraitons by default (think GC and access logging).

Subsequently the configurations that have to be done could better be done manually to get a better grasp of what you're application is doing. This may not be a requirement now (or ever depending on the application), but may be there when the application becomes more professional.