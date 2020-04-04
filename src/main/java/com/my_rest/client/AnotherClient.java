package com.my_rest.client;

import com.my_rest.model.Customer;
import jdk.javadoc.internal.doclets.toolkit.util.ClassUseMapper;
import org.glassfish.jersey.internal.inject.Custom;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.message.internal.EntityInputStream;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.lang.annotation.Target;
import java.security.NoSuchAlgorithmException;

public class AnotherClient {
    // Here we can create a testing unity the main form as we can see in the next lines of the next code as we can see in t
    public static void main(String[] args) throws Exception{
        Client client = ClientBuilder.newClient(); // This is the easy way to pre-init the Client Class
        WebTarget target = client.target("https://Knotfy.io");
        // Here we init and instance the Response Object
        Response response = target.request().post(Entity.xml(new Customer()));
        response.close();
        Customer customer = target.queryParam("id").request().get(Customer.class);
        System.out.println(customer.toString());
        client.close(); // Close the client always for reasons as we can set in the next lines of the code

    }
}
