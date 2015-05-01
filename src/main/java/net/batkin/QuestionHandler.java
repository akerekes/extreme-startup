package net.batkin;

public interface QuestionHandler {
    String answerQuestion(String question) throws NotAnswerableException;
}
