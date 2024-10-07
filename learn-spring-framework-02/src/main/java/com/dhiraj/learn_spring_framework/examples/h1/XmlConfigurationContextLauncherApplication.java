package com.dhiraj.learn_spring_framework.examples.h1;
import java.util.Arrays;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dhiraj.learn_spring_framework.game.GameRunner;

/**
 changes in src/main/resources
 created contextConfiguration.xml file

 */

public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] args) {
       try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
    	   Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
           System.out.println(context.getBean("name"));
           context.getBean(GameRunner.class).run();
       }
    }

}

/*
Annotations vs XML configuration
Annotations:
- easy to use
- short and concise
- POJOs are not clean, polluted with spring annotations
- easy to maintain
- use in almost all projects
- debugging is hard

XML configuration
- cumbersome
- Not short ans concise
- POJOs are clean
- Not easy to maintain
- Rarely used
- debugging is medium

Recommendataion : either of them is fine BUT be consistent

 */
