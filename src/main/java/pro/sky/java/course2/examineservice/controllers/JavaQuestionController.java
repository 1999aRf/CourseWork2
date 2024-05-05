package pro.sky.java.course2.examineservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import pro.sky.java.course2.examineservice.Question.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examineservice.service.QuestionService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam Question question, @RequestParam String answer) {
        return questionService.remove(question);
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

}
