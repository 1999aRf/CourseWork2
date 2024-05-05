package pro.sky.java.course2.examineservice.repositories;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examineservice.Question.Question;

import java.util.List;

@Repository
public interface QuestionRepository {
    void add(Question question);
    void remove(Question question);
    List<Question> getAll();
}
