package com.exercise.demo.aspect;


import com.exercise.demo.app.service.Food;
import com.exercise.demo.app.service.FoodImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audiences {

    private static Logger logger = LoggerFactory.getLogger(Audiences.class);

    @Pointcut("execution(* com.exercise.demo.aspect.Performance.perform(..))")
    public void performance() {
        logger.debug("定义总切点");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) throws Throwable {

        logger.debug("Silencing cell phones");
        System.out.println("Taking seats");
        jp.proceed();
        logger.debug("CLAP CLAP CLAP!!!");
    }

}