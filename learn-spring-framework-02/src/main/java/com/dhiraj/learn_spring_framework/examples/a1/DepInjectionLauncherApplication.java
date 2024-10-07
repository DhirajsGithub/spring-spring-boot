package com.dhiraj.learn_spring_framework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
class YourBusinessClass{

//    // 1. FIELD injection --> No setter or constructor. dependency is injected using reflection
//    @Autowired
//    Dependency1 dependency1;
//
//    @Autowired
//    Dependency2 dependency2;
	

	Dependency1 dependency1;
	Dependency2 dependency2; 
	 
    // 2. Constructor-based : Dependencies are set by creating the bean using it's constructor, 
    // Recommandation to use Constructor base dependency injection
    // @Autowired   // @Autowired is not mandatory
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
        System.out.println("Constructor injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	// 3. Setter-based : Dependencies are set by calling setter methods on your beans
    // @Autowired
	// public void setDependency1(Dependency1 dependency1) {
    //     System.out.println("Setter Injection - setDependency1 ");
	// 	this.dependency1 = dependency1;
	// }

    // @Autowired
	// public void setDependency2(Dependency2 dependency2) {
    //     System.out.println("Setter Injection - setDependency2 ");
	// 	this.dependency2 = dependency2;
	// }
    
    
    public String toString(){
        return "Using " + dependency1 + " and "+ dependency2;
    }

}

@Component
class Dependency1{

}

@Component
class Dependency2{
    
}

@Configuration
@ComponentScan    // same as ("com.dhiraj.learn_spring_framework.examples.a1"), automatically scans current file
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
            System.out.println(context.getBean(YourBusinessClass.class));
       }
    }

}

/*
Important Terminology
@Component : An instance of class will be managed by spring framework

Dependency : GameRunner needs GaminConsole implicit

Component Scan : How does spring framework find component classes ? 
It scans packages (@ComponentScan("com.dhiraj"))

Dependency Injection : Identify beans dependencies and wire them together (provides IOS - Inversion of Control)
- spring beans : an object managed by spring framework
- IOC container : Manages the lifecycle of beans and dependencies 
    - types ApplicationContext(Complex), BeanFactory(simple features - rarely used)
- Autowiring : process of wiring in dependecies for a spring bean


@Component vs @Bean

where ?         
@Component  - can be used on any java class, very easy        
@Bean - Typically used on methods in spring configuration classes, you write all the code

Autowiring 
@Component - Yes. Fied, setter, constructor injection 
@Bean - Yea. Method calls or Method parameters

Who creates beans 
@Component - Spring Frameword
@Beans - You write bean creation code

Recommended For 
@Component - Instantiating Beans for your application
@Bean - Custome business logic, instantiating beans for 3rd-party libraries

Beans per class ? 
@Componend - one (singleton) or many (prototype)
@Bean - one or many, you can create as many as you want


 */