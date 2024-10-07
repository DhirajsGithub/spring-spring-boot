package com.dhiraj.learn_spring_framework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

// @Component
@Named
class BusinessService{
    private DataService dataService;

    // @Autowired
    @Inject
    public void setDataService(DataService dataService){
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }

    public DataService getDataService(){
        return dataService;
    }


}

// @Component
@Named
class DataService{

}


@Configuration
@ComponentScan    
public class CdiContextLauncherApplication {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
        System.out.println(context.getBean(BusinessService.class));
       }
    }

}

/*

add 
<dependency>
    <groupId>jakarta.inject</groupId>
    <artifactId>jakarta.inject-api</artifactId>
    <version>2.0.1</version>
</dependency>
in pom.xml

Jakarta Context and dependency injection
CDI specification --> JAVA EE 6
Now called jakarta contect and dependency injection (CDI)
CDI is a specification (interface)
    spring framework implements CDI

imp injection API annotations :
(Inject) (~Autwired in spring)
(Named) (~Component in spring)
Qualifier
Scope
Singleton

 */