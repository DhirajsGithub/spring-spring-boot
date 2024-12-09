package com.dhiraj.learn_spring_framework.examples.f1;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;



@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency; 
        System.out.println("All dependencies are ready !!!");
    }

    // as soon as the bean/ dependency is ready or wired up
    // get some data from DB and initialze myself
    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }

    // befor application is terminated, or bean is removed from your context
    // close your active connections or things like that
    @PreDestroy
    public void cleanUp(){
        System.out.println("Cleanup");
    }

}

@Component
class SomeDependency{
    public void getReady(){
        System.out.println("Some logic using SomeDependency at initialization");
    }
}


@Configuration
@ComponentScan    
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)){
    	   Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
       }
    }

}

/*
Evolution of Jakarta EE vs J2EE vs Java EE
Enterprise capabilities were initially built into JDK
With time, they were separated out:
J2EE - Java 2 Platform Enterprise Edition
Java EE - Java Platform Enterprise Edition (Rebranding)
Jakarta EE (Oracle gave Java EE rights to the Eclipse Foundation)
    Important Specifications: Jakarta Server Pages (JSP)
        Jakarta Standard Tag Library (JSTL) 
        Jakarta Enterprise Beans (EJB) 
        Jakarta RESTful Web Services (JAX-RS) 
        Jakarta Bean Validation
        Jakarta Contexts and Dependency Injection (CDI) 
        Jakarta Persistence (JPA)
    Supported by Spring 6 and Spring Boot 3
    That's why we use jakarta. packages (instead of javax.)

 */







