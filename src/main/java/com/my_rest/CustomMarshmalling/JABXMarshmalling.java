package com.my_rest.CustomMarshmalling;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @Author Erick Hernandez
 * This is manner of Custom the Marshalling as the extends the next manner
 */

@Provider
@Produces("application/xml")
public class JABXMarshmalling implements MessageBodyWriter {

    public boolean isWriteable(Class<?> type,
                               Type genericType,
                               Annotation[] annotations,
                               MediaType mediaType) {
        return type.isAnnotationPresent(XmlRootElement.class);
    }

    public long getSize(Object obj,
                 Class<?> type,
                 Type genericType,
                 Annotation[] annotations,
                 MediaType mediaType) {
        return -1;
    }
    @Context
    protected Providers providers; // This is the access in the next lines of the code as we can see in
    public void writeTo(Object target,
                        Class<?> type,
                        Type genericType,
                        Annotation[] annotations,
                        MediaType mediaType,
                        MultivaluedMap<String,Object> httpheaders,
                        OutputStream outputStream) {
        try{
            JAXBContext context = null;
            ContextResolver<JAXBContext> resolver =
                    providers.getContextResolver(JAXBContext.class, mediaType);
            if (resolver != null){
                context = resolver.getContext(type);
            }
            if (context == null){
                context = JAXBContext.newInstance(type);
            }
            context.createMarshaller().marshal(target,outputStream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
