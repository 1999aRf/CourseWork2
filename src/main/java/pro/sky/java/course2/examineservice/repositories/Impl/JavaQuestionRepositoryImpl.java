package pro.sky.java.course2.examineservice.repositories.Impl;

import pro.sky.java.course2.examineservice.Question.Question;
import pro.sky.java.course2.examineservice.repositories.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class JavaQuestionRepositoryImpl implements QuestionRepository {
    private List<Question> javaQuestions;

    public JavaQuestionRepositoryImpl() {
        this.javaQuestions = new ArrayList<>();
    }

    @Override
    public void add(Question question) {
        javaQuestions.add(question);
    }

    @Override
    public void remove(Question question) {
        javaQuestions.remove(question);
    }

    @Override
    public List<Question> getAll() {
        return new ArrayList<>(javaQuestions);
    }
}
