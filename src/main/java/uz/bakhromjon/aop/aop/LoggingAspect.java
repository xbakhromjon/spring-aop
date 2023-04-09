package uz.bakhromjon.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("@annotation(Log)")
    public void logPointcut() {
    }

    @Pointcut("execution(public void uz.bakhromjon.aop.service.TestService.*(..))")
    public void logPointcutFromExecution() {
    }

    @Pointcut("within(uz.bakhromjon.aop.service.TestService))")
    public void logPointcutWithin() {
    }

    @Before("logPointcutWithin()")
    public void logAllMethodCallsAdvice(JoinPoint joinPoint) {
        System.out.println("In Aspect from within a " + joinPoint.getSignature().getName());
    }


    // after
    @Pointcut("@annotation(AfterLog)")
    public void logAfterPointCut() {
    }

    @After("logAfterPointCut()")
    public void logMethodCallsAfterAdvice(JoinPoint joinPoint) {
        System.out.println("In After Aspect at " + joinPoint.getSignature().getName());
    }

    // around
    @Pointcut("within(uz.bakhromjon.aop.service.ValidationService)")
    public void validationPointcut(){}


    @Around("validationPointcut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("In Around Aspect");
        int arg = (int) joinPoint.getArgs()[0];
        if (arg < 0)
            throw new RuntimeException("Argument should not be negative");
        else
            joinPoint.proceed();
    }
}
