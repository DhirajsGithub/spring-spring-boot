package com.dhiraj.learn_spring_framework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
class NormalClass{

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass{

}

@Configuration
@ComponentScan    
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)){
    	   System.out.println(context.getBean(NormalClass.class));  // NormalClass@759d26fb
    	   System.out.println(context.getBean(NormalClass.class));  // NormalClass@759d26fb
    	   System.out.println(context.getBean(NormalClass.class));  // NormalClass@759d26fb
    	   System.out.println(context.getBean(NormalClass.class));  // NormalClass@759d26fb
    	   System.out.println(context.getBean(NormalClass.class));  // NormalClass@759d26fb
    	   System.out.println(context.getBean(NormalClass.class));  // NormalClass@759d26fb

           System.out.println(context.getBean(PrototypeClass.class)); // PrototypeClass@3c73951
           System.out.println(context.getBean(PrototypeClass.class)); // PrototypeClass@3d5c822d
           System.out.println(context.getBean(PrototypeClass.class)); // PrototypeClass@6f46426d
           System.out.println(context.getBean(PrototypeClass.class)); // PrototypeClass@73700b80
       }
    }

}


/*

Prototype vs Singleton Bean Scope

Singleton
- One per spring IOC container
- Same bean instance reused
- Default
- Very frequently used
- use for stateless bean

Prototype 
- Possibly many per spring IOC container
- New Bean instance created every time the bean is referred to 
- Not default
- @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
- Rarely used
- use for stateful beans

 
- Scopes applicable only for web-aware spring application context
    - Request : one object instance per single HTTP request
    - Session : one object instance per user HTTP session
    - Application : one object instance per web application runtime
    - Websocket : one object instance per websocket instance

Java singletone vs spring singleton
- spring singleton : one object instance per IOC container
- Java singletone : one object instance per JVM

 */