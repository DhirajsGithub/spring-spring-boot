package com.dhiraj.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Marks the class as a Spring bean, meaning Spring will manage its lifecycle 
// and make it available for dependency injection wherever needed
@Component

// @Primary indicates that if multiple beans of the same type exist, 
// this one should be given preference when injecting that type. 
// In this case, if there are multiple implementations of the GamingConsole interface,
// Spring will choose Packman by default when injecting a GamingConsole bean.
@Primary
public class Packman implements GamingConsole {

    // Defining methods that Spring can manage as part of the Packman bean. 
    // These methods will perform actions that can be invoked when required.

    @Override
    public void up() {
        System.out.println("up");
    }

    @Override
    public void down() {
        System.out.println("down");
    }

    @Override
    public void left() {
        System.out.println("left");
    }

    @Override
    public void right() {
        System.out.println("right");
    }
}
