package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.Question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public Question add(String question, String answer) {
        return add(question, answer);
    }
    @Override
    public Question add(Question question) {
        questions.add(question);
    return question;
    }
    @Override
    public Question remove(Question question) {
        questions.remove(question);
    return question;
    }
    @Override
    public List<Question> getAll() {
        return new ArrayList<>(questions);
    }
    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("No questions available");
        }
    List<Question> questionList = new ArrayList<>(questions);
        int index = random.nextInt(questionList.size());
        return questionList.get(index);
    }
}
