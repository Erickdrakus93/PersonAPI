package com.my_rest.app;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import com.my_rest.Service.Service_implementation;


@ApplicationPath("/services")
public class App extends Application {
    // Here the singletons are mutable and updated as we can see
    private Set<Object> singletons = new HashSet<>(); // Redundant main form
    private Set<Class<?>> empty = new HashSet<>(); // Here we can set the next part of the main example as we can see
    // In the next lines of the code as we can set in the next lines of the code as we can

    /*
    Here we can write the methods that we can inheriance

    */
    // This is the constructor that adds the part of the main example as we can set in
    public App(){
        singletons.add(new Service_implementation());
    }
    @Override
    public Set<Class<?>> getClasses(){
        return empty;
    }

    @Override
    public Set<Object> getSingletons(){
        return singletons;
    }


}
