package com.my_rest.Service;

import com.my_rest.Service.Service_Abstract;
import com.my_rest.model.Person;
import com.my_rest.model.Response;
import sun.print.PeekGraphics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Service_implementation implements Service_Abstract {

    private static Map<Integer,Person> persons = new HashMap<>(); // This is the explicit terms
    @Override
    public Response addPerson(Person p) {
        Response response = new Response();
        if(persons.get(p.getId()) != null) {
            response.setStatus(false);
            response.setMessage("Person exist already");
            return response;
        }
        persons.put(p.getId(),p);
        response.setStatus(true);
        response.setMessage("Person Created Sucefully");
        return response;
    }

    @Override
    public Response deletePerson(int id) {
        Response response = new Response();
        if(persons.get(id) == null){
            response.setStatus(false);
            response.setMessage("Persons already exist");
            return response;
        }
        persons.remove(id);
        response.setStatus(true);
        response.setMessage("Persons deleted Sucefully");
        return response;
    }

    @Override
    public Person getPerson(int id) {
        return persons.get(id);
    }

    @Override
    public Person[] getAllPerson() {
        Set<Integer> ids = persons.keySet();
        Person[] p = new Person[ids.size()];
        int i=0;
        for(Integer id:ids){
            p[i] = persons.get(id);
            i++;
        }
        return p;
    }

    @Override
    public Person getDummyPerson(int id) {
        Person p = new Person();
        // setter and methods actions
        p.setName("Erick");
        p.setId(888);
        p.setLast_name("Dumitz");
        return p;
    }
}
