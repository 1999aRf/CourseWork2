package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.sky.java.course2.examineservice.Question.Question;
import pro.sky.java.course2.examineservice.service.impl.ExaminerServiceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExaminerServiceTest {
    private ExaminerServiceImpl examinerService;

    @Mock
    private QuestionService mockQuestionService1;
    @Mock
    private QuestionService mockQuestionService2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Collection<QuestionService> questionServices = Arrays.asList(mockQuestionService1, mockQuestionService2);
        examinerService = new ExaminerServiceImpl(questionServices);
    }

    @Test
    void getQuestions_ShouldReturnCorrectAmountOfQuestions() {
        when(mockQuestionService1.getRandomQuestion()).thenReturn(new Question("Question 1", "Answer 1"));
        when(mockQuestionService2.getRandomQuestion()).thenReturn(new Question("Question 2", "Answer 2"));

        Set<Question> questions = examinerService.getQuestions(2);

        assertNotNull(questions);
        assertEquals(2, questions.size());
    }

    @Test
    void getQuestions_ShouldThrowException_WhenRequestedAmountIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(-1));
    }

    @Test
    void getQuestions_ShouldThrowException_WhenRequestedAmountIsZero() {
        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(0));
    }

    @Test
    void getQuestions_ShouldThrowException_WhenRequestedAmountIsGreaterThanNumberOfServices() {
        assertThrows(IllegalArgumentException.class, () -> examinerService.getQuestions(3));
    }

    @Test
    void getQuestions_ShouldReturnUniqueQuestions() {
        when(mockQuestionService1.getRandomQuestion())
                .thenReturn(new Question("Question 1", "Answer 1"))
                .thenReturn(new Question("Question 1", "Answer 1"));
        when(mockQuestionService2.getRandomQuestion())
                .thenReturn(new Question("Question 2", "Answer 2"))
                .thenReturn(new Question("Question 2", "Answer 2"));

        Set<Question> questions = examinerService.getQuestions(2);

        assertNotNull(questions);
        assertEquals(2, questions.size());
    }

}