package com.my_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Here we can define here the DOJO person
// Here
/*
This is the class in the next lines of the code as we can see in the next lines
of the code as we can set in the next lines of the code as we can see i+
 */
@JsonSerialize
public class Person {
    // Here we can set in the next part of the models as we can set in the
    // The next example as we can set in the next lines of the code
    private int id;
    private String name;
    private String last_name;

    // Here we can do the setter, getter Subroutines
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String name(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

}
