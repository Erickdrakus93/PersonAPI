package com.my_rest.model;
// Here we can set a Respose layer
public class Response {
    private boolean status;
    private String message;

    // Getter and Setter Subroutines
    // Here we can construct all the main form as we can see in

    public boolean getstatus(){
        return status;
    }
    public void setStatus(boolean status){
        this.status = status;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
