package com.dhiraj.learn_spring_framework.examples.c1;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */

@Configuration
@ComponentScan    // same as ("com.dhiraj.learn_spring_framework.examples.c1")
public class RealWorldSpringContextLauncherApplication {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class)){
    	   Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    	   
           System.out.println(context.getBean(BusinessCalculationService.class).findMax());
       }
    }

}
/*
Spring stereotype Annotations - @Component & more...
- @Component - Generic annotations available for any class
    - base for all spring stereotype annotations
    - specializations of @Component
        - @Service - indicates that an annoted class has a business logic
        - @Controller - indicates that an annoted class is a "Controller" (e.g. web controller)
            - used to define controller in you web application and REST API
        - @Repository - Indicates that an annotated class is used to retrieve and/or manipulate data in DB

- Use the most specific annotation possible
- by using most specific annotation we are giving more information to the framework about your intentions
- we can use AOP at a later point to add additional behaviour
- e.g. For @Repository, Spring automatically wires in JDBC Exception translation features

 */
