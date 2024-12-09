package com.dhiraj.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * LoggingAspect: Defines various AOP advices and pointcuts for logging.
 * 
 * - Aspect: Combination of advice and pointcut.
 * - JoinPoint: A specific execution instance of an advice.
 * - Pointcut: Expression that identifies method calls to be intercepted.
 */
@Configuration
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    // --- Examples of Pointcut Definitions ---

    /**
     * Matches all method calls in the specified package:
     * execution(* PACKAGE.*.*(..))
     * 
     * Example: Methods in the "business" package.
     */
    // @Pointcut("execution(* com.dhiraj.learn_spring_aop.aopexample.business.*.*(..))")

    /**
     * Matches all methods in all packages within "aopexample":
     * execution(* com.dhiraj.learn_spring_aop.aopexample.*.*.*(..))
     */
    // @Pointcut("execution(* com.dhiraj.learn_spring_aop.aopexample.*.*.*(..))")

    /**
     * Matches methods in both "business" and "data" packages using a reusable
     * pointcut from CommonPointCutConfig:
     */
    // @Before("com.dhiraj.learn_spring_aop.aopexample.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")

    /**
     * Matches any bean whose name follows the naming convention of containing "Service"
     * (e.g., businessService1, dataService, etc.):
     */
    @Before("com.dhiraj.learn_spring_aop.aopexample.aspects.CommonPointCutConfig.allPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        // Advice logic: Perform logging, authentication, etc.

        /**
         * Example Log Outputs:
         * - Before Aspect Method is called - execution(int com.dhiraj.learn_spring_aop.aopexample.business.BusinessService1.calculateMax())
         * - Before Aspect Method is called - execution(int[] com.dhiraj.learn_spring_aop.aopexample.data.DataService1.retrieveData())
         */
        logger.info("Before Aspect - {} is called with arguments - {}", joinPoint, joinPoint.getArgs());
    }

    /**
     * Advice executed after a method is called, irrespective of success or exception.
     * Pointcut: Matches methods in both business and data packages.
     */
    @After("com.dhiraj.learn_spring_aop.aopexample.aspects.CommonPointCutConfig.businessAndDataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} is called with arguments - {}", joinPoint, joinPoint.getArgs());
    }

    /**
     * Advice executed only when a method throws an exception.
     * Pointcut: Matches all methods in the specified packages.
     * 
     * @param joinPoint   The join point representing the intercepted method.
     * @param exception   The exception thrown by the method.
     */
    @AfterThrowing(pointcut = "execution(* com.dhiraj.learn_spring_aop.aopexample.*.*.*(..))", throwing = "exception")
    public void logMethodCallAfterThrowingExecution(JoinPoint joinPoint, Exception exception) {
        logger.info("After Throwing Aspect - {} has thrown an exception - {}", joinPoint, exception);
    }

    /**
     * Advice executed after a method successfully returns a value.
     * Pointcut: Matches methods in the business package only.
     * 
     * @param joinPoint   The join point representing the intercepted method.
     * @param resultValue The value returned by the method.
     */
    @AfterReturning(
        pointcut = "com.dhiraj.learn_spring_aop.aopexample.aspects.CommonPointCutConfig.businessPackageConfig()", 
        returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("After Returning Aspect - {} has returned - {}", joinPoint, resultValue);
    }
}

/*
 * Additional Notes:
 * 
 * 1. Weaver:
 *    - The framework that implements AOP (e.g., AspectJ or Spring AOP).
 * 
 * 2. Join Point:
 *    - A point during the execution of a program where advice can be applied.
 *    - Example: Method execution.
 * 
 * 3. Pointcut:
 *    - An expression used to match join points.
 *    - Examples: "execution", "bean", "within".
 * 
 * 4. Runtime Behavior:
 *    - Advice is executed at a join point when the pointcut condition is true.
 * 
 * 5. Common Debugging Logs:
 *    - Log output contains details of the method intercepted, arguments, return values, and exceptions.
 */
