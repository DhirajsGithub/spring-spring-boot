package com.dhiraj.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dhiraj.learn_spring_framework.game.GameRunner;
import com.dhiraj.learn_spring_framework.game.GamingConsole;
import com.dhiraj.learn_spring_framework.game.MarioGame;
import com.dhiraj.learn_spring_framework.game.PGame;

@Configuration
public class GamingConfiguration {
    // var game = new MarioGame();
    // var game = new SuperContraGame();
    @Bean
    public GamingConsole game(){
        var game = new PGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
           

}
