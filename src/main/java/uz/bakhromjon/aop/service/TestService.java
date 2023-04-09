package uz.bakhromjon.aop.service;

import org.springframework.stereotype.Component;
import uz.bakhromjon.aop.aop.Log;

@Component
public class TestService {
    @Log
    public void test1() {
        System.out.println("Test");
    }

    public void test2(int number) {
        System.out.println("Test2");
    }
}
