package pro.sky.java.course2.examineservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examineservice.Question.Question;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/math-questions")
public class MathQuestionController {
    private final QuestionService mathQuestionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }
    @GetMapping(value = "/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam Question question, @RequestParam String answer) {
        return mathQuestionService.remove(question);
    }

    @GetMapping
    public List<Question> getAll() {
        return mathQuestionService.getAll();
    }
}
