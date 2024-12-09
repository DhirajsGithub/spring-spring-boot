package com.dhiraj.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * PerformanceTrackingAspect: Tracks the execution time of methods.
 * 
 * - Advice Type: @Around
 * - JoinPoint Type: ProceedingJoinPoint (used to execute the intercepted method).
 */
@Configuration
@Aspect
public class PerformanceTrackingAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Around advice that tracks the execution time of any method in packages
     * under "aopexample".
     * 
     * @param proceedingJoinPoint A join point that allows the execution of the
     *                            intercepted method.
     * @return The result of the intercepted method execution.
     * @throws Throwable Any exception thrown by the intercepted method.
     */
    
//    @Around("execution(* com.dhiraj.learn_spring_aop.aopexample.*.*.*(..))")
    // it will be call for all the methods of classes of aopexamples
    
    @Around("com.dhiraj.learn_spring_aop.aopexample.aspects.CommonPointCutConfig.trackTimeAnnotation()")
    // only method which has @TrackTime annotation only track those
    // it will only be call for calculateMax of BusinessService1 class 
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // Start the timer
        long startTimeMillis = System.currentTimeMillis();

        // Execute the method
        // ProceedingJoinPoint allows the method execution (unlike JoinPoint).
        Object returnValue = proceedingJoinPoint.proceed();

        // Stop the timer
        long stopTimeMillis = System.currentTimeMillis();
        long executionDuration = stopTimeMillis - startTimeMillis;

        // Log the method execution time
        logger.info("Around Aspect - Method {} executed in {} ms", proceedingJoinPoint, executionDuration);

        // Return the original method's result
        return returnValue;
    }
}
