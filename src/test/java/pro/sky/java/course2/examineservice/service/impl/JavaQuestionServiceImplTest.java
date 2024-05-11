package pro.sky.java.course2.examineservice.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.Question.Question;
import pro.sky.java.course2.examineservice.repositories.QuestionRepository;
import pro.sky.java.course2.examineservice.service.impl.JavaQuestionServiceImpl;

import java.util.*;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private Random random;

    @InjectMocks
    private JavaQuestionServiceImpl questionService;
    private Question question1;
    private Question question2;

    @BeforeEach
    void setUp() {
        question1 = new Question("What is Java?", "Java is a programming language.");
        question2 = new Question("What is Mockito?", "Mockito is a mocking framework for unit tests in Java.");
    }

    @Test
    void add_ShouldCallRepositoryToAddQuestion() {
        questionService.add(question1);
        verify(questionRepository).add(question1);
    }

    @Test
    void remove_ShouldCallRepositoryToRemoveQuestion() {
        questionService.remove(question1);
        verify(questionRepository).remove(question1);
    }

    @Test
    void getAll_ShouldCallRepositoryToGetAllQuestions() {
        when(questionRepository.getAll()).thenReturn(Arrays.asList(question1, question2));
        List<Question> questions = questionService.getAll();
        verify(questionRepository).getAll();
        assertTrue(questions.contains(question1));
        assertTrue(questions.contains(question2));
    }

    @Test
    void getRandomQuestion_ShouldReturnRandomQuestion() {
        when(questionRepository.getAll()).thenReturn(Arrays.asList(question1, question2));
        when(random.nextInt(anyInt())).thenReturn(0); // Предполагаем, что random всегда возвращает первый индекс
        Question randomQuestion = questionService.getRandomQuestion();
        verify(questionRepository).getAll();
        assertSame(question1, randomQuestion);
    }

    @Test
    void getRandomQuestion_ShouldThrowExceptionWhenNoQuestionsAvailable() {
        when(questionRepository.getAll()).thenReturn(Collections.emptyList());
        assertThrows(IllegalStateException.class, () -> questionService.getRandomQuestion());
    }
}