package com.my_rest.model;

// Here we can define the next part of the main examples as we can see

import sun.jvm.hotspot.types.CIntegerField;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String Street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Customer() {
    }

    // Here we can define the next method

    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    public String getFisrstname(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public  String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getStreet(){
        return Street;
    }
    public void setStreet(String Street){
        this.Street = Street;
    }
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getZip(){
        return zip;
    }
    public void setzip(String zip) {
        this.zip = zip;
    }
    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }
}
