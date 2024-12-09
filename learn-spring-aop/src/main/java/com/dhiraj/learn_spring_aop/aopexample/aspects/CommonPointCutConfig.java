package com.dhiraj.learn_spring_aop.aopexample.aspects;

import org.aspectj.lang.annotation.Pointcut;

/**
 * CommonPointCutConfig: Defines reusable pointcuts to avoid duplicating package names
 * in multiple aspect classes (e.g., LoggingAspect, PerformanceTrackingAspect).
 * 
 * Benefit:
 * - If the package name changes, you only need to update it here, simplifying maintenance.
 */
public class CommonPointCutConfig {

    /**
     * Pointcut to match all methods in all packages under "aopexample".
     * Example:
     * - Matches methods in both "business" and "data" packages.
     */
    @Pointcut("execution(* com.dhiraj.learn_spring_aop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    /**
     * Pointcut to match all methods in the "business" package under "aopexample".
     */
    @Pointcut("execution(* com.dhiraj.learn_spring_aop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    /**
     * Pointcut to match all methods in the "data" package under "aopexample".
     */
    @Pointcut("execution(* com.dhiraj.learn_spring_aop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    /**
     * Pointcut to match any bean whose name contains "Service".
     * Example:
     * - Matches bean names like "businessService1", "dataService", etc.
     */
    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}
    
    // pointcut to match @TrackTime annotation for particular methods only
    @Pointcut("@annotation(com.dhiraj.learn_spring_aop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
