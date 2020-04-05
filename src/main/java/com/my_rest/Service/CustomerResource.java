package com.my_rest.Service;

import com.my_rest.model.Customer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// Here we dont use inner methods in the next lines of the code as we can see in the next lines
// Here we can define the next part of the example as we can see in the next lines of the code
@Path("/customers") //Here we can use for JAX-RS
public class CustomerResource {
    /*
    * This is the constructor manner in a usual way
    * @DefaultConstructor
    */

    public CustomerResource() {

    }

    /*
    Here we can set the Utility functions to invoke in the next
    @Annotation manner in the next lines of the code
     */
    protected void outputCustomer(OutputStream os, Customer cust) {
        PrintStream writer = new PrintStream(os);
        writer.println("<customer id=\"" + cust.getid() + "\">");
        writer.println("  <first-name>" + cust.getFisrstname()
                + "</first-name>");
        // Here we can set the next lines of the code as we can see in the next lines of the code as we can see in the next
        writer.println("<last-name> " + cust.getLastName()
                + "</last-name>");
        writer.println("   <street>" + cust.getStreet()
                + "</street>");
        writer.println("  <city> " + cust.getCity()
                + "</city>");
        writer.println("   <zip> " + cust.getZip()
                + "</zip>");
        writer.println("   <country> " + cust.getCountry()
                + "</country>");
        writer.println("</customer>");
    }

    private Map<Integer, Customer> customerDB; // new ConcurrentHashMap<>(); this is like the DB simulates
    //of the main example as we can set in the next lines of the code
    private AtomicInteger idCounter = new AtomicInteger(); // Here is main form of the main example as we can see in
    //Todo:Define the Constructor for a Distributed Data Base
    // Utility functions as we can see in the next lines of the code
    // This constructor does that is not necessary the concurrentHashMap<>

    // Here we have the constructor that we dont't use in the next lines of the code
    /*
    * Another Constructor with the assignations
     */
    public CustomerResource(Map<Integer,Customer> customerDB){
        this.customerDB = customerDB;
    }

    protected Customer readCustomer(InputStream is) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);
            Element root = doc.getDocumentElement();
            Customer cust = new Customer(); //this is the init of the main form as we can see in the next lines of the code
            // Here we can set a logic in the next sense
            if (root.getAttribute("id") != null &&
                    !root.getAttribute("id").trim().equals("")) {
                cust.setid(Integer.parseInt(root.getAttribute("id")));
            }
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                switch (element.getTagName()) {
                    case "First Name":
                        cust.setFirstName(element.getTextContent());
                        break;
                    case "Street":
                        cust.setStreet(element.getTextContent());
                        break;
                    case "City":
                        cust.setCity(element.getTextContent());
                        break; // this is the break statment
                    case "state":
                        cust.setState(element.getTextContent());
                        break;
                    case "zip":
                        cust.setzip(element.getTextContent());
                        break;
                    case "country":
                        cust.setCountry(element.getTextContent());
                        break;
                }
            }
            return cust;
        }
        catch (Exception e){
            throw new WebApplicationException(e,
                    Response.Status.BAD_REQUEST);
        }
    }

    // So in the next manner in the CRUM operations

    @POST
    @Consumes("applications/xml")
    public Response createCustomer(InputStream is){
        Customer customer = readCustomer(is);
        customer.setid(idCounter.incrementAndGet());
        customerDB.put(customer.getid(), customer);
        System.out.println("Created Customer" +  customer.getid());
        return Response.created(URI.create("/customer"
        + customer.getid())).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public StreamingOutput getCustomer(@PathParam("id") int id){
        final Customer customer = customerDB.get(id);
        if(customer == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws WebApplicationException {
                outputCustomer(output,customer);
                }
        };
    }
    // Here we can define the next part of the example
    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    public void updateCustomer(@PathParam("id") int id, InputStream is){
        Customer customer = readCustomer(is); // Here is the instance that it will works as we can see in the next lines of the code
        Customer current = customerDB.get(id);
        if(customer == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        // Update the data inside
        current.setFirstName(customer.getFisrstname());
        current.setLastName(customer.getLastName());
        current.setCountry(customer.getCountry());
        current.setCity(customer.getCity());
        current.setStreet(customer.getStreet());
        current.setzip(customer.getZip());
    }

    // Here we can define the instance of uriinfo
    @GET
    @Produces("application/xml")
    public String getCustomers(@Context UriInfo info){
        String start = info.getQueryParameters().getFirst("Start");
        String size = info.getQueryParameters().getFirst("Size");
        return start + size;
    }

    //TODO:Here we can define more injection forms:
    //todo:to do the rest of the code with more annotations

    @GET
    @Produces("text/html")
    public String get(@Context HttpHeaders headers){
        Map<String,Cookie> res = headers.getCookies(); // This is the call of the map
        String refer = headers.getRequestHeader("Refer").get(0);
        // Here we can define the for recursive method
        for (String header: headers.getRequestHeaders().keySet()){
            System.out.println("This header was set :" +  header);
        }
        return refer + res.toString(); //This is the manner to return the manner.
    }

    //This is an access in the next @Context
    /*
    * Here we can define the the injection of Annotation @with
    * And we can inject instances of higher classes.
     */

    @GET
    @Produces("text/html")
    public String getCookies(@Context HttpHeaders headers){
        for(String name : headers.getCookies().keySet()){
            Cookie cookie = headers.getCookies().get(name);
            System.out.println("Cookie" +
                    name + "=" + cookie.getValue());
        }
        return headers.getCookies().toString(); //This is the classic manner as we can see in the next
    }

    @POST
    public void createCustomer(@BeanParam Customer newCustomer){
        // Here we can set the elements of the Customer
        // Here we can define the Subroutines as we can set
        //This is the injection in the next lines of the code as we can note
    }

    //Here we can set the conversion manner as we can see with the URL
    @GET
    @Produces("text/html")
    public String get_header(@HeaderParam("Refer") URL refer){ //This is the representation of the data as String and
        // JAX-RS converts in Java Data Types in the next lines of the code
        return refer.toString();
    }
    // All the injections params are represented as Strings as we can se
    @GET
    @Produces("text/plain")
    public StreamingOutput get_out(){
        return new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                output.write("Hello World".getBytes());
            }
        };
    }
    @PUT
    @Path("/MoreStuff")
    public void PutMore(Reader reader) throws IOException {
        LineNumberReader lineReader = new LineNumberReader(reader);
        String line;
        do {
            line = lineReader.readLine();
            System.out.println(line);
        } while(line != null);
    }

    String base_path = "..."; //Here we can define the next methods as we can see in the next lines of the code
    @GET
    @Path("{filepath}:.*")
    @Produces("text/plain")
    public InputStream getFile(@PathParam("filepath") String path) throws FileNotFoundException {
        return new FileInputStream(base_path + path);
    }
    @GET
    @Path("{filepath}: .*")
    @Produces("text/plain")
    public File GetFile(@PathParam("filepath") String path){
        return new File(base_path + path); // Here we can define the next terms of the same object
    }
    /*
    * Here is the post manner in the @POST
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public String post(Source source) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource("foo.xsl"));
        StringWriter writer = new StringWriter();
        transformer.transform(source,new StreamResult(writer));
        return writer.toString(); // This is the mapper as we can set in the String.
    }
    // Another Form as we can see that eat the next part of the main example

    @POST
    @Produces("application/xml")
    @Consumes("applications/xml")
    public MultivaluedMap<String,String> post_new(MultivaluedMap<String,String> map){
        return map; // Here we have the return manner in the next context
    }

    /*
    *todo: Here we can define the next Schema in the next sense:
    * Define the maps in the next sense
     */

}