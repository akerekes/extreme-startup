package net.batkin.service;

import net.batkin.HandlerSet;
import net.batkin.NotAnswerableException;
import net.batkin.QuestionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@Component
@Path("hello")
public class HelloWorldController {

    public static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private HandlerSet set;

    @GET
    public String sayHello(@QueryParam("q") String q) {
        String[] parts = q.split(": ", 2);
        if (parts.length != 2) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        String question = parts[1];

        String answer = set.answerQuestion(question);
        logger.info("Question: " + question + ", Answer: " + answer);
        return answer;
    }
}
