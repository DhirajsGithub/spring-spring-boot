package com.dhiraj.learn_spring_framework.agame;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    // tightly couple to MarioGame, if we want to introduce new game then we need to change here as well
    //private MarioGame game;

    // Injecting the GamingConsole interface (instead of a specific implementation like MarioGame) 
    // allows for loose coupling, meaning we can easily switch between different game implementations
    // without changing the code here. 
    
    GamingConsole game;

    // Primary bean will get executed 
    // public GameRunner(GamingConsole game){
    //     this.game = game;
    // }

    // Constructor-based dependency injection with @Qualifier to specify which implementation 
    // of GamingConsole should be injected. In this case, "SuperContraGameQualifier" is used to 
    // ensure the SuperContraGame bean is injected.
    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game){
        this.game = game;
    }

    // This method runs the game by calling its up, down, left, and right methods, 
    // simulating the game controls. The specific game implementation (SuperContraGame or others)
    // is injected and its methods are invoked.
    public void run(){
        System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
    }

}
