package net.batkin;

import net.batkin.service.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HandlerSet {

    private List<QuestionHandler> handlers;

    public HandlerSet() {
        handlers = new ArrayList<QuestionHandler>();
        handlers.add(new PlusHandler());
        handlers.add(new LargestHandler());
        handlers.add(new SquareCubeHandler());
        handlers.add(new PrimeHandler());
        handlers.add(new FibHandler());
    }

    public String answerQuestion(String question) {
        for (QuestionHandler handler : handlers) {
            try {
                return handler.answerQuestion(question);
            } catch (NotAnswerableException e) {
                // Ignore
            }
        }
        return "";
    }

}
