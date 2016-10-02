package com.ip1x.jump.h2.mentorship.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.ip1x.jump.h2.mentorship.controller.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("before: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "execution(* com.ip1x.jump.h2.mentorship.controller.*.*(..))",
            returning= "result")
    public void afterReturningAddUserResult(JoinPoint joinPoint, Object result) {
        System.out.println("after returning user editing result : " + joinPoint.getSignature().getName());
        if(result!=null) {
            System.out.println("Method returned value is : " + result.toString());
        }
    }
}