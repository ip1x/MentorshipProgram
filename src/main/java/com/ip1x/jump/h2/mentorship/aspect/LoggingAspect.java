package com.ip1x.jump.h2.mentorship.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    static final Logger logger = Logger.getLogger(LoggingAspect.class);

    @Pointcut("within(com.ip1x.jump.h2.mentorship.controller.*)")
    public void inController() {}

    @Before("inController()")
    public void beforeControllerMethods(JoinPoint joinPoint){
        System.out.println("before : " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "inController()", throwing = "ex")
    public void writeErrors(Exception ex){
        logger.error(ex.getMessage() + " | " + ex.getCause());
    }

    @AfterReturning(
            pointcut = "inController()",
            returning= "result")
    public void afterReturningSavingAndEditingResults(JoinPoint joinPoint, Object result) {
        System.out.println("after returning : " + joinPoint.getSignature().getName());
        if(result!=null) {
            System.out.println("Method returned value is : " + result.toString());
        }
    }
}