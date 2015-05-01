package net.batkin.service;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.batkin.NotAnswerableException;
import net.batkin.QuestionHandler;

public class MultiOperatorHandler implements QuestionHandler {

    @Override
    public String answerQuestion(String question) throws NotAnswerableException {
        Pattern plusPattern = Pattern.compile("what is (.+)");
        Matcher plusMatcher = plusPattern.matcher(question);
        if (plusMatcher.matches()) {
            Scanner scanner = new Scanner(plusMatcher.group(1));
            long accu = scanner.nextLong();
            while (scanner.hasNext()) {
                String op = scanner.next("[^\\d]+");
                int arg = scanner.nextInt();
                accu = calc(accu, op, arg);
            }
            return "" + accu;
        }
        throw new NotAnswerableException();
    }

    private long calc(long i1, String op, int i2) {
        if (op.equals("plus")) {
            return (i1 + i2);
        } else if (op.equals("multiplied by")) {
            return (i1 * i2);
        } else if (op.equals("minus")) {
            return (i1 - i2);
        } else if (op.equals("to the power of")) {
            return new BigInteger(""+i1).pow(i2).longValue();
        } else {
            return 0;
        }
    }
}
