package com.my_rest.ContextLayer;

import com.my_rest.model.Customer;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

//This is a resolver in many forms as we can see in the next lines of the code
@Provider // Here this is a note flagging that is a JAX-RS Resource
@Produces("application/xml")
public class ContextResolver implements javax.ws.rs.ext.ContextResolver<JAXBContext> {

    private JAXBContext context; //This is the init as we can see in the next lines of the code
    public ContextResolver() throws JAXBException{
            this.context = JAXBContext.newInstance(Customer.class);
    }

    // This is the Subroutine that inherite from the parent
    public JAXBContext getContext(Class<?> type){
        if (type.equals(Customer.class)){
            return context;
        }
        else {
            return null;
        }
    }
}
