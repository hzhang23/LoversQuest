package com.loversQuest.IO;


import com.loversQuest.GameWorld;
import com.loversQuest.gameWorld.Player;

import java.util.Scanner;

public class Input {

    GameWorld game;
    Player player;
    Scanner userInput = new Scanner(System.in);

    public Input(GameWorld game) {
        this.game = game;
        this.player = game.p1;
    }

    public void userActionPrompt() {

        //prompt user for action
        System.out.println("What would you like to do? [ 'go', 'look' ]");

        String responseInput = userInput.nextLine();

        String response = responseInput.toLowerCase();

        if (response.equals("go")) {
            goActionPrompt();
        } else if (response.equals("look")) {
            System.out.println("do something with LOOK");
        }
    }

    public void goActionPrompt(){
        System.out.println("Where would you like to go? (north, south, east, west): ");
        String response = userInput.nextLine().toLowerCase();
        player.go(response);

    }

    public void lookActionPrompt(){

    }

    public void inspectActionPrompt(){

    }



}
