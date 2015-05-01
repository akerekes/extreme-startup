package net.batkin.service;

import net.batkin.NotAnswerableException;
import net.batkin.QuestionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SquareCubeHandler implements QuestionHandler {

    @Override
    public String answerQuestion(String question) throws NotAnswerableException {
        Pattern pattern = Pattern.compile("which of the following numbers is both a square and a cube: (.*)");
        Matcher largest = pattern.matcher(question);
        if (largest.matches()) {
            String g = largest.group(1);
            String[] is = g.split(", ");
            StringBuilder builder = new StringBuilder();
            for (String s : is) {
                s = s.trim();
                int val = Integer.parseInt(s);
                if (isSquare(val) && isCube(val)) {
                    builder.append(val).append(", ");
                }
            }
            if (builder.length() > 0) {
                return builder.substring(0, builder.length()-2);
            } else {
                return "";
            }

        }
        throw new NotAnswerableException();
    }

    private boolean isCube(int val) {
        int cbrt = (int)Math.cbrt(val);
        return (Math.pow(cbrt, 3) == val);
    }

    private boolean isSquare(int val) {
        int sqrt = (int)Math.sqrt(val);
        return sqrt * sqrt == val;
    }
}
