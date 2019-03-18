package com.home.katas.fizzbuzz.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class useCaseTimer {

    @Around("execution(* com.home.katas.fizzbuzz.useCases.*.*(..))")
    public Object timeSortAdvice(ProceedingJoinPoint proceedingJoinPoint){
        long startTime = System.nanoTime();

        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime)/1000000;

        System.out.println(String.format("finished %s of %s in %d", proceedingJoinPoint.getSignature().getName()
                , proceedingJoinPoint.getSignature().getDeclaringType().getName()
                , executionTime));

        return value;
    }
}
