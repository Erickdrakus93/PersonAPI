package com.my_rest.model;


import javax.xml.bind.annotation.*;

@XmlRootElement(name="Customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerXML {
    @XmlAttribute
    protected int id; //This is the id solutions
    @XmlElement
    protected String fullname;

    // Setter and Getter methods
    public int getid(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }
}
