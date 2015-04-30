package net.batkin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

@Provider
@Component
@Path("hello")
public class HelloWorldController {

    public static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GET
    public String sayHello() {
        return "Adam";
    }
}
