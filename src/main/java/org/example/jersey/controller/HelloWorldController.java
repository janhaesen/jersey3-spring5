package org.example.jersey.controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.jersey.entity.TestEntity;
import org.springframework.stereotype.Component;

@Component
@Path("hello")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldController {

    @GET
    public Response hello() {
        return Response.ok(new TestEntity("Hello", "World")).build();
    }

}
