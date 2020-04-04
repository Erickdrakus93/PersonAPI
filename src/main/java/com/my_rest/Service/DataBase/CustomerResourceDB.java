package com.my_rest.Service.DataBase;

import com.my_rest.Service.CustomerResource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


//Here we can define the rest of the resources in the next lines of the code
@Path("/customers")
public class CustomerResourceDB {
    protected CustomerResource europe = new CustomerResource();
    protected CustomerResource american = new CustomerResource();


    // Here we return anyway an Object in general;
    @Path("{database}-db")
    public Object getDatabaseObject(@PathParam("database") String db){
        if (db.equals("europe")){
            return europe;
        }
        else if("america".equals(db)){
            return american;
        }
        else return null;
    }

}
