package com.dhiraj.learn_spring_framework.agame;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Marks this class as a Spring bean, allowing Spring to manage it and inject it where needed
@Component
//the way you tell spring to create instant of a specific class is by using @Component annotation


// The @Qualifier annotation is used to explicitly differentiate this bean from others of the same type.
// In this case, this bean is associated with the name "SuperContraGameQualifier", 
// which can be used during dependency injection to specify that this particular bean should be injected.
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("up");
    }

    @Override
    public void down() {
        System.out.println("Sit down");
    }

    @Override
    public void left() {
        System.out.println("Go back");
    }

    @Override
    public void right() {
        System.out.println("Shoot a bullet");
    }
}
