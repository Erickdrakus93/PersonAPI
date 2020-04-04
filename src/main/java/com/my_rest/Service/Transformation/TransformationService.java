package com.my_rest.Service.Transformation;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;

/*
*This is an implementation of transform the source
* With the Transformer the Source as we can set in the next lines of the code
 */
@Path("/transform")
public class TransformationService {

    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public String post(Source source) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource("foo.xsl"));
        StringWriter writer = new StringWriter();
        transformer.transform(source, new StreamResult(writer));
        return writer.toString(); // This is the conversion manner as we can see in the next lines of the code
    }
}
