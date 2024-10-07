package com.dhiraj.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dhiraj.learn_spring_framework.game.GameRunner;
import com.dhiraj.learn_spring_framework.game.GamingConsole;
import com.dhiraj.learn_spring_framework.game.MarioGame;
import com.dhiraj.learn_spring_framework.game.PGame;
import com.dhiraj.learn_spring_framework.game.SuperContraGame;

/**
 * 
 */
public class App03GamingSpringBeans {
    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
        context.getBean(GamingConsole.class).up();;
        context.getBean(GameRunner.class).run();
       }
    }

}
