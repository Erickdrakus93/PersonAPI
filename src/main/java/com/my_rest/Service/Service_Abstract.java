package com.my_rest.Service;

import com.my_rest.model.Person;
import com.my_rest.model.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
/*
This is an extensible class in the Abstract mannner
 */

@Path("Persons")
//All of this is a resource as we can see in the next line of the code
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface Service_Abstract {

    @POST
    @Path("/add")
    Response addPerson(Person p);
    @GET
    @Path("/{id}/delete")
    Response deletePerson(@PathParam("id") int id);
    @GET
    @Path("{id}/get")
    Person getPerson(@PathParam("id") int id);
    @GET
    @Path("/getall")
    Person[] getAllPerson();
    @GET
    @Path("{id}/getDummy")
    Person getDummyPerson(@PathParam("id") int id);
}
