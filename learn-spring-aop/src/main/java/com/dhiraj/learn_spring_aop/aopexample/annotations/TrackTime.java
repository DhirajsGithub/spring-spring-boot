package com.dhiraj.learn_spring_aop.aopexample.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to track execution time of methods.
 * 
 * Usage: Add this annotation to any method you want to monitor for performance.
 */
@Retention(RetentionPolicy.RUNTIME) // Ensures the annotation is available at runtime.
@Target(ElementType.METHOD)          // Indicates this annotation is for methods only.
public @interface TrackTime {
}