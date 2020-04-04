package com.my_rest.client;

// All the imports in the next libs
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class MyClient {
    public static void main(String[] args){
        Client client = ClientBuilder.newClient(); // This is the instance and init of the client

        // Operations in the next level of the next part of the main example as we can set in the next lines of the code
        try {

            //Here we use only data of Strings
            System.out.println("*** Create a new Customer ***");

            String xml = "<customer>"
                    + "<first-name>Bill </first-name>"
                    + "<last-name>Burker</last-name>";
            // todo: Write all the atts of the xml as XML in the client
            // Here we can define the rest of the XML code


            Response response = client.target(
                    "http://localhost:8080/services/customers")
                    .request().post(Entity.xml(xml));
            if (response.getStatus() != 201){
                throw new RuntimeException("Failed to Create");
            }
            String location = response.getLocation().toString(); // Here is the tranformations
            System.out.println("Location " +  location); //Here we can set the locations in the next lines of the code
            response.close();

            System.out.println("*** GET Created Customer");
            String customer = client.target(location).request().get(String.class);
            System.out.println(customer);


            // This is the String in the next lines of the code
            String updateCustomer = "<customer>"
                    + "<first-name>Andrew</first-name>"
                    + "<last-name>Flores</last-name>"; // This is the java Object that eats the xml() Method
                    //TODO: Write all the elements of the Customer in the XML;
            response = client.target(location).request().put(Entity.xml(updateCustomer));
            if (response.getStatus() != 204){
                throw new RuntimeException("Failed to update");
            }
            response.close();
            System.out.println("*** After update");
            customer = client.target(location).request().get(String.class);
            System.out.println(customer);
        }
        finally {
            client.close(); // This is the exception in the next lines of the code

        }
    }
}
