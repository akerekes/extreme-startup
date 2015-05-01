package net.batkin;

import net.batkin.service.*;
import org.springframework.stereotype.Component;

import javax.xml.ws.WebServiceException;

@Component
public class HandlerSet {

    private QuestionHandler[] handlers;

    public HandlerSet() {
        handlers = new QuestionHandler[] {new PlusHandler(), new LargestHandler(), new SquareCubeHandler(), new PrimeHandler(), new FibHandler()};
    }

    public String answerQuestion(String question) {
        for (QuestionHandler handler : handlers) {
            try {
                return handler.answerQuestion(question);
            } catch (NotAnswerableException e) {
                // Ignore
            }
        }
        throw new WebServiceException("I don't know how to answer");
    }

}
