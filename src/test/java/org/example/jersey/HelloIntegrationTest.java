package org.example.jersey;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloIntegrationTest {

    private static String HELLO_URL = "http://localhost:8080/hello";

    @Test
    public void testHello() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(HELLO_URL);
        String response = webTarget.request().get(String.class);
        System.out.println(response);
        Assertions.assertEquals(response, "Hello, World!");
    }
}
