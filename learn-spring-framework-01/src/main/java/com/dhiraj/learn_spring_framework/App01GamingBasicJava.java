package com.dhiraj.learn_spring_framework;

import com.dhiraj.learn_spring_framework.game.GameRunner;
import com.dhiraj.learn_spring_framework.game.MarioGame;
import com.dhiraj.learn_spring_framework.game.PGame;
import com.dhiraj.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {
    public static void main(String[] args) {
        // var game = new MarioGame();
        // var game = new SuperContraGame();
        var game = new PGame();     // 1. object creation
        var gameRunner = new GameRunner(game);
        // 2. object creatio + wiring of dependencies 
        // game is a dependency of game runner
        gameRunner.run();
    }

}
