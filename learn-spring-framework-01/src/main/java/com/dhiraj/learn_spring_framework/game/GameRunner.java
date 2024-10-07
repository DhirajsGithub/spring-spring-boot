package com.dhiraj.learn_spring_framework.game;

public class GameRunner {
    // tightly couple to MarioGame, if we want to introduce new game then we need to change here as well
    //private MarioGame game;
    
    GamingConsole game;

    public GameRunner(GamingConsole game){
        this.game = game;
    }

    public void run(){
        System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
    }

}
