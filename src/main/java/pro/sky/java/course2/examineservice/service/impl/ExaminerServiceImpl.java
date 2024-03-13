package pro.sky.java.course2.examineservice.service.impl;


import pro.sky.java.course2.examineservice.Question.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.java.course2.examineservice.service.ExaminerService;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random = new Random();
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не хватает вопросов");
        }
        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size() < amount) {
            uniqueQuestions.add(questionService.getRandomQuestion());
        }
        return new ArrayList<>(uniqueQuestions);
    }
}
