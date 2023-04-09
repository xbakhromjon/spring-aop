package uz.bakhromjon.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.bakhromjon.aop.service.QuizService;
import uz.bakhromjon.aop.service.TestService;

@SpringBootTest
class ApplicationTest {
    @Autowired
    TestService testService;
    @Autowired
    QuizService quizService;

    @Test
    void testBeforeLog() {
        testService.test2(1);
    }
}
