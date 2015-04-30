package net.batkin.service;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ext.Provider;

@Provider
@Component
@Path("hello")
public class HelloWorldController {

    @GET
    public String sayHello(@QueryParam("name") String name) {
        if (name == null) {
            name = "<unknown>";
        }
        return "Hello " + name;
    }
}
