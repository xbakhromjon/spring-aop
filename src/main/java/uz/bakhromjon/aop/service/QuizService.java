package uz.bakhromjon.aop.service;

import org.springframework.stereotype.Component;
import uz.bakhromjon.aop.aop.AfterLog;

@Component
public class QuizService {
    @AfterLog
    public void quiz() {
        System.out.println("Quiz");
    }
}
