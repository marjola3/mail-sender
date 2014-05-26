package com.mp.email.aspect;

import com.mp.email.log.AutowiredLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;

/**
 * Author: Mariola
 */
@Aspect
public class LoggingAspect {

    @AutowiredLogger
    private Logger logger;

    @Before("beforeAnyMethod()")
    public void logMethodCall(JoinPoint joinPoint) {
        logger.info("Wywołanie metody: " + joinPoint.getSignature().getName());
    }

    @Pointcut("execution(* com.mp.email..findAll*(..))")
    public void beforeAnyMethod(){}

}
