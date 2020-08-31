package com.loversQuest.IO;

import com.loversQuest.GameWorld;
import com.loversQuest.gameWorldPieces.Player;

import java.util.Scanner;

public class Input {

    GameWorld game;
    Player player;
    Scanner userInput = new Scanner(System.in);

    public Input(GameWorld game) {
        this.game = game;
        this.player = game.p1;
    }

    public String displayGoResponse(String direction){
        String status = "You head to the " +direction+ " and find yourself in the " + player.getCurrentLocation().getName();
        return status;
    }

    //TODO: better error / input checking on responseInput and all methods that use util.Scanner
    public void userActionPrompt() {

        //prompt user for action
        System.out.println("What would you like to do? [ 'go', 'look' ]");

        String responseInput = userInput.nextLine();

        String[] response = responseInput.trim().toLowerCase().split("\\s+");

        String actionVerb = response[0];

        // go action
        if (actionVerb.equals("go")) {
            String direction;
            if(response.length < 2){
                direction = goActionPrompt();
            }else{
                direction = response[1];
                // player.go returns false if bad input, return statement prevents displayGoResponse() from running
                if(!player.go(direction)) return;
            }
            System.out.println(displayGoResponse(direction));
            //look action
        } else if (actionVerb.equals("look")) {
            player.look();
        }else{
            System.out.println("Unreadable input. Please try again.");
        }
    }


    //TODO: error checking on user input response
    public String goActionPrompt(){
        System.out.println("Where would you like to go? (North, South, East, West): ");
        String response = userInput.nextLine().toLowerCase();
        player.go(response);
        return response;
    }

    public void lookActionPrompt(){
        player.look();
    }

    public void inspectActionPrompt(){
    }

}
