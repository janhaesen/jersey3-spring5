package org.example.jersey.configuration.jersey;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.example.jersey.configuration.spring.SpringAnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        // Define the package which contains the service classes.
        packages("org.example.jersey.controller");

        property(ServerProperties.TRACING, "ALL");
        property("contextConfig", new AnnotationConfigApplicationContext(SpringAnnotationConfig.class));
    }

}
