package net.batkin.service;

import net.batkin.NotAnswerableException;
import net.batkin.QuestionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlusHandler implements QuestionHandler {

    @Override
    public String answerQuestion(String question) throws NotAnswerableException {
        Pattern plusPattern = Pattern.compile("what is (\\d+) (.+) (\\d+)");
        Matcher plusMatcher = plusPattern.matcher(question);
        if (plusMatcher.matches()) {
            String g1 = plusMatcher.group(1);
            String g2 = plusMatcher.group(3);
            int i1 = Integer.parseInt(g1);
            int i2 = Integer.parseInt(g2);

            String op = plusMatcher.group(2);
            if (op.equals("plus")) {
                return "" + (i1 + i2);
            } else if (op.equals("multiplied by")) {
                return "" + (i1 * i2);
            } else if (op.equals("minus")) {
                return "" + (i1 - i2);
            }


        }
        throw new NotAnswerableException();
    }
}
