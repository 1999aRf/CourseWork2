package pro.sky.java.course2.examineservice.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.Question.Question;
import pro.sky.java.course2.examineservice.repositories.QuestionRepository;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.*;

@Service
public class MathQuestionServiceImpl implements QuestionService {
    private final Random random = new Random();


    @Override
    public Question add(String question, String answer) {
        throw new UnsupportedOperationException("Add operation is not supported");
    }

    @Override
    public Question add(Question question) {
        throw new UnsupportedOperationException("Add operation is not supported");
    }

    @Override
    public Question remove(Question question) {
        throw new UnsupportedOperationException("Remove operation is not supported");
    }

    @Override
    public List<Question> getAll() {
        throw new UnsupportedOperationException("Get all operation is not supported");
    }

    @Override
    public Question getRandomQuestion() {
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        String questionText = "What is " + a + " + " + b + "?";
        String answer = Integer.toString(a + b);
        return new Question(questionText, answer);
    }
}
