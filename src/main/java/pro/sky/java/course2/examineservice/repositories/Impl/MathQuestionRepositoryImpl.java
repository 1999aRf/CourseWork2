//package pro.sky.java.course2.examineservice.repositories.Impl;
//
//import pro.sky.java.course2.examineservice.Question.Question;
//import pro.sky.java.course2.examineservice.repositories.QuestionRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MathQuestionRepositoryImpl implements QuestionRepository {
//    private List<Question> mathQuestions;
//
//    public MathQuestionRepositoryImpl() {
//        this.mathQuestions = new ArrayList<>();
//    }
//
//    @Override
//    public void add(Question question) {
//        mathQuestions.add(question);
//    }
//
//    @Override
//    public void remove(Question question) {
//        mathQuestions.remove(question);
//    }
//
//    @Override
//    public List<Question> getAll() {
//        return new ArrayList<>(mathQuestions);
//    }
//}
