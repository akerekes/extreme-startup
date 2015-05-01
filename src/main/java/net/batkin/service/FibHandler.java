package net.batkin.service;

import net.batkin.NotAnswerableException;
import net.batkin.QuestionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FibHandler implements QuestionHandler {

    private static final Logger logger = LoggerFactory.getLogger(FibHandler.class);

    @Override
    public String answerQuestion(String question) throws NotAnswerableException {
        Pattern pattern = Pattern.compile("what is the (\\d+)\\w+ number in the Fibonacci sequence");
        Matcher largest = pattern.matcher(question);
        if (largest.matches()) {
            String g = largest.group(1);
            int i = Integer.parseInt(g);
            return "" + (fib(i));
        }
        throw new NotAnswerableException();
    }

    public int fib(int x) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < x; i++) {
            a = a + b;
            b = a - b;
        }
        return b;
    }


}
