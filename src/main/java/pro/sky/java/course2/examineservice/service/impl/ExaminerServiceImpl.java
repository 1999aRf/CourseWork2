package pro.sky.java.course2.examineservice.service.impl;


import pro.sky.java.course2.examineservice.Question.Question;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.service.ExaminerService;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Set<QuestionService> questionServices;
    private final Random random = new Random();

    public ExaminerServiceImpl(Collection<QuestionService> questionServices) {
        this.questionServices = new HashSet<>(questionServices);
    }
    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionServices.size()) {
            throw new IllegalArgumentException("Invalid amount of questions requested.");
        }

        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            for (QuestionService service : questionServices) {
                if (questions.size() >= amount) {
                    break;
                }
                questions.add(service.getRandomQuestion());
            }
        }
        return questions;
    }
}
