package com.neueda.payments.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RepoLoggingAspect {

    Logger logger = LoggerFactory.getLogger(RepoLoggingAspect.class);

    @Pointcut("execution(* com.neueda.payments.repositories.*.* (..))")
    public void logRepoMethods() {}

    @Around("logRepoMethods()")
    public Object aroundLogRepoMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Entering repository method {}", proceedingJoinPoint.getSignature().getName());
        Object returnValue = proceedingJoinPoint.proceed();
        logger.info("Exiting repository method {}", proceedingJoinPoint.getSignature().getName());
        return returnValue;
    }
}
