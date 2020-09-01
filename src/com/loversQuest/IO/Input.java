package com.loversQuest.IO;

import com.loversQuest.GameWorld;
import com.loversQuest.gameWorldPieces.Player;

import java.util.Scanner;

public class Input {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    InputParser parser = new InputParser();

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
//        System.out.println("What would you like to do? [ 'go', 'look', 'interact', 'inventory', 'get item']");
        System.out.println("\nWhat would you like to do? " + ANSI_PURPLE +  "[ go, look, interact, inventory, get <item> ]" + ANSI_RESET);

        String responseInput = userInput.nextLine();

        String[] response = responseInput.trim().toLowerCase().split("\\s+");

        // put first word through parser, account for synonyms of command words.
//        String actionVerb = response[0];
        String actionVerb = parser.parseCommand(response[0]);

        // go action
        //look action
        switch (actionVerb) {
            case "go" -> {
                String direction;
                if (response.length < 2) {
                    direction = goActionPrompt();
                } else {
                    direction = response[1];
                    // player.go returns false if bad input, return statement prevents displayGoResponse() from running
                    if (!player.go(direction)) return;
                }
                System.out.println(displayGoResponse(direction));
            }
            case "look" -> System.out.println(player.look());
            case "interact" -> System.out.println(player.interact());
            case "inventory" -> System.out.println(player.displayItems());
            case "get" ->{
                String itemName;
                if(response.length < 2){
                    System.out.println("You can't get nothing");
                }else{
                    itemName = response[1];
                    if(player.pickUpItem(itemName)){
                        System.out.println("You picked up " + response[1]);
                    }else{
                        System.out.println("You can't pick that up");
                    };
                }
            }
            case "use" ->{
                String itemName;
                if(response.length < 2){
                    System.out.println("You can't use nothing");
                }else{
                    itemName = response[1];
                    if(player.getItem(itemName) != null){
                        System.out.println(player.getItem(itemName).use());
                    }else{
                        System.out.println("You can't use that.");
                    };
                }
            }
            default -> System.out.println("Unreadable input. Please try again.");
        }
    }


    //TODO: error checking on user input response
    public String goActionPrompt(){
//        System.out.println("Where would you like to go? (North, South, East, West): ");
        System.out.println("Where would you like to go? " + ANSI_PURPLE + "[ North, South, East, West ]: " + ANSI_RESET);
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
