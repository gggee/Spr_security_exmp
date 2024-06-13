package Quiz.controller;
import Quiz.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final List<Question> questions = Arrays.asList(
            new Question("What is the capital of Kazakhstan?", "Astana"),
            new Question("When is New Year?", "31th of December")
    );

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return questions;
    }
}
