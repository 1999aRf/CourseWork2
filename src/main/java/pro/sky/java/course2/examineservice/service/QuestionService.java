package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.Question.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    List<Question> getAll();

    Question getRandomQuestion();
}
