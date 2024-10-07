package com.dhiraj.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 */

@Configuration
@ComponentScan("com.dhiraj.learn_spring_framework.game")
// both Packman and Game Runner (component) are in same package game
// spring is managing objects,  performing auto-wiring, creating objects as well
public class GamingAppLauncherApplication {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)){
        context.getBean(GamingConsole.class).up();;
        context.getBean(GameRunner.class).run();
       }
    }

}
