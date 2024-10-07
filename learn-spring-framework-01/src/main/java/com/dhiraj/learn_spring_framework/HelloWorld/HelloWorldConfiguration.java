package com.dhiraj.learn_spring_framework.HelloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Record class for Person (immutable data structure with two fields: name and age)
record Person(String name, int age, Address address) {}

// Record class for Address (immutable data structure with two fields: firstLine and city)
record Address(String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    // Defining a simple String bean named "name", which will return a static name
    public String name(){
        return "Dhiraj";
    }

    @Bean
    public int age(){
        return 23;
    }

    @Bean
    // Defining a bean of type Person, managed by Spring. This returns a Person object with name "Dhiraj" and age 23
    public Person person(){
        var person = new Person("Harshal", 20, new Address("Main street", "Utrecht")   );
        return person; // Spring will manage this Person instance as a bean
    }

    @Primary
    @Bean(name="myAddress") // Renaming the bean from the default method name ("address") to "myAddress"
    // This bean defines an Address object with "Baker street" as the first line and "Tokyo" as the city
    public Address address(){
        return  new Address("Baker street", "Tokyo");
    }

    @Bean(name="myAddress2")
    @Qualifier("address2QualifierBean")
    public Address address2(){
        return  new Address("ABC", "San Diego");
    }

    // more complex beans that use other beans, e.g., creating a Person from name and Address beans
    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address myAddress2){
        return new Person(name, age, myAddress2);
    }

    @Bean
    // it non of the Address where primary it would have thrown error as :
    // No qualifying bean of type Address found
    // available : expected singble matching bean but found myAddress2, address
    // will use primary bean name myAddress
    public Person person4Parameters(String name, int age, Address anyName){
        return new Person(name, age, anyName);
    }
    // OR  with qualifier
    // don't use default address but the qualifier one 
    // this will use the address2Qualifier bean
    @Bean
    public Person person5Parameters(String name, int age, @Qualifier("address2QualifierBean") Address anyName){
        return new Person(name, age, anyName);
    }

}
