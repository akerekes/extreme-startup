package net.batkin.service;

import net.batkin.NotAnswerableException;
import net.batkin.QuestionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrimeHandler implements QuestionHandler {

    private static final Logger logger = LoggerFactory.getLogger(PrimeHandler.class);

    @Override
    public String answerQuestion(String question) throws NotAnswerableException {
        Pattern pattern = Pattern.compile("which of the following numbers are primes: (.*)");
        Matcher largest = pattern.matcher(question);
        if (largest.matches()) {
            String g = largest.group(1);
            String[] is = g.split(", ");
            StringBuilder builder = new StringBuilder();
            for (String s : is) {
                s = s.trim();
                int val = Integer.parseInt(s);
                if (isPrime(val)) {
                    builder.append(val).append(", ");
                }
            }
            if (builder.length() > 0) {
                return builder.substring(0, builder.length() - 2);
            } else {
                return "";
            }
        }
        throw new NotAnswerableException();
    }

    private boolean isPrime(int val) {
        logger.info("isPrime(" + val + ")");
        if (val <= 2) {
            return true;
        }
        int sqrt = (int) Math.sqrt(val);
        logger.info("sqrt=" + sqrt);
        for (int i = 2; i < sqrt; i++) {
            logger.info(val + " % " + i + " = " + (val % i));
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }

}
