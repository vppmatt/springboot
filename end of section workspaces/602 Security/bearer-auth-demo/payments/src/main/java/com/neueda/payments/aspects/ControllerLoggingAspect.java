package com.neueda.payments.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerLoggingAspect {

    Logger logger = LoggerFactory.getLogger(ControllerLoggingAspect.class);

    @Pointcut("execution(* com.neueda.payments.control.*.* (..))")
    public void logControllerMethods() {}

    @Around("logControllerMethods()")
    public Object aroundLogControllerMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Entering controller method {}", proceedingJoinPoint.getSignature().getName());
        Object returnValue = proceedingJoinPoint.proceed();
        logger.info("Exiting controller method {}", proceedingJoinPoint.getSignature().getName());
        return returnValue;
    }

}
