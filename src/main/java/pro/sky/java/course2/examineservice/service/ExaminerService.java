package pro.sky.java.course2.examineservice.service;

import pro.sky.java.course2.examineservice.Question.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ExaminerService {
   Set<Question> getQuestions(int amount);
}
