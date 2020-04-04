package com.my_rest.client;

import com.my_rest.model.Customer;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import javax.net.ssl.SSLContext;
import javax.ws.rs.RedirectionException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ClientInstance {
    /***
     *This is an example of instance and init the Client API
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SSLContext sslcontext = SSLContext.getDefault();
        Client client = ClientBuilder.newBuilder().property("Connection Success", 100).sslContext(sslcontext)
                .register(JacksonJsonProvider.class).build(); // This is the client Instances as we can set in the next lines of the code
        WebTarget target = client.target("https://Knotify.io");
        Customer customer = target.request().accept("application/json").get(Customer.class);
        List<Customer> customers = target.request().accept("application/json").get(new GenericType<List<Customer>>() {
        });
        // Here we can call the Output lines of the code as we can set in the next lines of the code
        System.out.println(Arrays.toString(customers.toArray()));
        System.out.print(customer.toString());
        //So here we can construct the response as we can see in the next lines
        //The next lines is to construct the lines of the next code as we can set
        try (Response response = target.request().accept("application/json")
                .get()) {
            if (response.getStatus() == 200) {
                response.bufferEntity();
                Customer customer1 = response.readEntity(Customer.class); // This is for read instance //
                Map raw_json = response.readEntity(Map.class);
                System.out.println(customer1.toString());
                System.out.println(raw_json);
            }


        }// here response.close() is implicit
        Customer customer2 = new Customer();
        Response response = target.request().post(Entity.xml(customer2));
        response.close();//call close for Security reasons //

        // Here we can call the put method as we can see in the next lines of the code
        Response response1 = target.request().put(Entity.xml(customer));
        response1.close(); //Always call the close for the Source Reasons;
        // Here we can define the invocations as we can see in the next lines of the code

        Invocation customer_get = target.request().accept("Application/xml").buildGet();
        //while invocation

        while (true){
            Response res = customer_get.invoke();
            try {
                Customer customer_do = res.readEntity(Customer.class);
                Thread.sleep(555);
            }catch (Exception e){
                System.out.println("Dont use the infinite loop");
            }
        }
        // Here we can inherite the main example as we can see in the do-while example as we can see
        Customer new_customer= null;
        boolean redirected = false;
        do{
            try {
                new_customer= target.request().accept("application/json").get(Customer.class);
            }catch (RedirectionException redirect){
                if(redirected) throw redirect;{
                    redirected = true;
                    target = client.target(redirect.getLocation());
                }
            }
        } while (new_customer == null);
    }
}
