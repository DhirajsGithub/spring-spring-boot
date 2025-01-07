package com.dhiraj.learn_spring_framework.examples.d1;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
class ClassA{
	
}

@Component
@Lazy
class ClassB{
	private ClassA classA;

    public ClassB(ClassA classA){
        super();
        System.out.println("Some initialization logic - class B constructor");
        this.classA = classA;
    }

    public void doSomething(){
        System.out.println("Do something");
    }
}

@Configuration
@ComponentScan    // same as ("com.dhiraj.learn_spring_framework.examples.a1")
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)){
    	   System.out.println("Initialization of context is completed");
           context.getBean(ClassB.class).doSomething();
       }
    }

}

/*
befor @Lazy
Some initialization logic - class B constructor
Initialization of context is completed
Do something

after @Lazy
Initialization of context is completed
Some initialization logic - class B constructor
Do something

Exploring lazy initializing of spring beans
- deafult initialization for spring beans : Eager
- Eager initialization is recommended 
- Bean initialized at the startup of the application
- @Lazy(value = false) or absence of @Lazy
- Error will preven application from starting up 
- All beans are initialized at the startup
- Errors can be detected immediately at the start of application
- Use for most of your beans

- Lazy annotation
- Bean initialized when it is first made use of in the application 
- @Lazy(value = true) or @Lazy
- Errors will result in runtime exception
- Less memory consumption (until bean is initialized)
- Use when beans beans very rarely used in your app

 */






