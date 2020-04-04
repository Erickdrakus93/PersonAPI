package com.my_rest.CustomMarshmalling;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @Author Erick Hernandez;
 * @USE MessageBodyReader to implement the next lines
 */


@Provider
@Produces("application/xml")
public class JAXBUnmarshmalling implements MessageBodyReader {

    // This is a manner to callback the unmarshalling the Object
    public boolean isReadable(Class type,
                               Type genericType,
                               Annotation[] annotations,
                               MediaType mediaType){
        return type.isAnnotationPresent(XmlRootElement.class);


    }
    public Object readFrom(Class type, Type genericType,
                           Annotation[] annotations,
                           MediaType mediaType,
                           MultivaluedMap<String,String> httpHeaders,
                           InputStream inputStream) throws WebApplicationException {
        try{
            JAXBContext context = JAXBContext.newInstance(type); //This is the instance as we can see in the next lines
            return context.createUnmarshaller().unmarshal(inputStream);
        } catch (JAXBException e) {
            throw  new RuntimeException(e);
        }
    }
}
