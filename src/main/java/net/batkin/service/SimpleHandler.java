package net.batkin.service;

import net.batkin.NotAnswerableException;
import net.batkin.QuestionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleHandler implements QuestionHandler {

    private class QuestionAndAnswer {
        private String question;
        private String answer;

        public QuestionAndAnswer(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    private List<QuestionAndAnswer> qas = new ArrayList<QuestionAndAnswer>();

    public void addQA(String q, String a) {
        qas.add(new QuestionAndAnswer(q, a));
    }

    @Override
    public String answerQuestion(String text) throws NotAnswerableException {
        for (QuestionAndAnswer qa : qas) {
            Pattern p = Pattern.compile(qa.question);
            Matcher m = p.matcher(text);
            if (m.matches()) {
                return qa.answer;
            }
        }
        throw new NotAnswerableException();
    }
}
