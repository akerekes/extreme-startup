package net.batkin.service;

import net.batkin.NotAnswerableException;
import net.batkin.QuestionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LargestHandler implements QuestionHandler {

    @Override
    public String answerQuestion(String question) throws NotAnswerableException {
        Pattern largestPattern = Pattern.compile("which of the following numbers is the largest: (.*)");
        Matcher largestMatcher = largestPattern.matcher(question);
        if (largestMatcher.matches()) {
            String g = largestMatcher.group(1);
            String[] is = g.split(", ");
            int max = Integer.MIN_VALUE;
            for (String s : is) {
                s = s.trim();
                int val = Integer.parseInt(s);
                if (val > max) {
                    max = val;
                }
            }
            return "" + max;
        }
        throw new NotAnswerableException();
    }
}
