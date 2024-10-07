package com.dhiraj.learn_spring_framework.HelloWorld;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// for App01GamingBasis --> managed by JVM only, all the classes and interfaces evertyhing is managed by JVM
// here spring will manage all classes and interface and dependecies and etc and spring itself will be manage by JVM
public class App02HellowWolrdSpring {
    public static void main(String[] args) {
        try (// 1. Launch a spring context
        var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            // 3. Retrieving Beans managed by spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("myAddress"));
            

            // we can also retrieve the bean by specifyin class type 
            // System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person4Parameters"));
            // When multiple Beans (Multiple matching candidates) of the same type are present, and you try to retrieve a Bean by type, Spring throws an exception due to ambiguity.
            // since we have address and address2 of type Address in HellowWorldConfiguratio this will throw an error
            // by using primary annotation we can specify which bean is most important, that bean will be taken then

            System.out.println(context.getBean("person5Parameters"));
        } catch (BeansException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 2. Configure the things that we want spring to manage
        // HellowWorldConfigutaion  - @Configuration
        // name  - @Bean


        // List all beans managed by spring framework
        // context.getBeanDefinitionCount();
        // context.getBeanDefinition(bean name);
        // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);


    }
}

/*
JVM will be initialize
inside this we will make a spring context 
in spring context everything will be happen
steps : 
1. Launch a spring context
2. Configure the things that we want spring to manage -- @Configuration class
what is bean ? 
 It signifies any class that you wish to render accessible and reusable within your application. 
 In essence, beans function as foundational components that Spring framework manages,
thereby enhancing the organization, reusability, and maintainability of your code. 


 */