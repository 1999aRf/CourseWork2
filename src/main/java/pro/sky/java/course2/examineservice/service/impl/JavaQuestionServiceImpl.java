package pro.sky.java.course2.examineservice.service.impl;

import pro.sky.java.course2.examineservice.Question.Question;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.repositories.QuestionRepository;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final Random random;

    public JavaQuestionServiceImpl(QuestionRepository questionRepository, Random random) {
        this.questionRepository = questionRepository;
        this.random = random;
    }

    @Override
    public Question add(String question, String answer) {
        return add(question, answer);
    }
    @Override
    public Question add(Question question) {
        questionRepository.add(question);
    return question;
    }
    @Override
    public Question remove(Question question) {
        questionRepository.remove(question);
    return question;
    }
    @Override
    public List<Question> getAll() {
        return questionRepository.getAll();
    }
    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = questionRepository.getAll();
        if (questionList.isEmpty()) {
            throw new IllegalStateException("No questions available");
        }
        int index = random.nextInt(questionList.size());
        return questionList.get(index);
    }
}
