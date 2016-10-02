package com.ip1x.jump.h2.mentorship.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingDAOAspect {

    static final Logger logger = Logger.getLogger(LoggingDAOAspect.class);

    @Pointcut("within(com.ip1x.jump.h2.mentorship.dao..*)")
    public void inDAO() {}

    @Pointcut("execution(* save(..))")
    public void saving(){}

    @Before("inDAO()")
    public void beforeAllMethods(JoinPoint joinPoint) {
        System.out.println("before method without parameters: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "inDAO()", throwing = "ex")
    public void writeErrors(Exception ex){
        logger.error(ex.getMessage() + " | " + ex.getCause());
    }

    @AfterReturning(
            pointcut = "saving() && inDAO()",
            returning= "result")
    public void afterReturningSavingAndEditingResults(JoinPoint joinPoint, Object result) {
        System.out.println("after returning user editing result : " + joinPoint.getSignature().getName());
        if(result!=null) {
            System.out.println("Method returned value is : " + result.toString());
        }
    }
}