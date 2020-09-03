package com.loversQuest.IO;

import com.loversQuest.GUI.MapFactory;
import com.loversQuest.GUI.MapFrame;
import com.loversQuest.GameWorld;
import com.loversQuest.gameWorldPieces.Item;
import com.loversQuest.gameWorldPieces.Player;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Input {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    // private?
    InputParser parser = new InputParser();
    MapFactory generateMap = new MapFactory();

    Scanner userInput = new Scanner(System.in);


    public String displayGoResponse(String direction, Player player){
        String status = "You head to the " +direction+ " and find yourself in the " + player.getCurrentLocation().getName();
        return status;
    }

    //TODO: better error / input checking on responseInput and all methods that use util.Scanner

    public void userActionPrompt(Player player) {

        //prompt user for action
//        System.out.println("What would you like to do? [ 'go', 'look', 'interact', 'inventory', 'get item']");
        System.out.println("\nWhat would you like to do? " + ANSI_PURPLE +  "[ go, look, interact, inventory, get <item> ]" + ANSI_RESET);

        String responseInput = userInput.nextLine();


        String[] response = responseInput.trim().toLowerCase().split("\\s+");

        // parses user response further, into second array
        String stringifiedResponse = String.join(" ", Arrays.copyOfRange(response, 1, response.length));

        String actionVerb = parser.parseCommand(response[0]);

        // handles first word of response
        switch (actionVerb) {
            case "go" -> {
                String direction;
                if (response.length < 2) {
                    direction = goActionPrompt(player);
                } else {
                    direction = response[1];
                    // player.go returns false if bad input, return statement prevents displayGoResponse() from running
                    if (!player.go(direction)) return;
                }
                System.out.println(displayGoResponse(direction, player));
            }
            case "look" -> System.out.println(player.look());
            case "interact" -> System.out.println(player.interact());
            case "inventory" -> System.out.println(player.displayItems());
            case "get" ->{
                Item chosenItem = null;

                // check if item is in location
                for (Item item: player.getCurrentLocation().getItemsList()) {
                    if (stringifiedResponse.equals(item.getName().toLowerCase())){
                        chosenItem = item;
                        break;
                    }
                }
                // if item is in location pick up item
                if (chosenItem != null) {
                    player.pickUpItem(stringifiedResponse);
                    System.out.println("You picked up " + stringifiedResponse);
                } else {
                    System.out.println("You can't pick that up");
                }

            }
            case "use" ->{
//              if the item is in current inventory
                for (Item item: player.getAllItems()) {
                    if (stringifiedResponse.equals(item.getName().toLowerCase())){
                        System.out.println(player.getItem(item.getName().toLowerCase()).use());
                        return;
                    }
                }
                System.out.println("You can't use nothing");

            }
            case "inspect" ->{
                // not currently used because locations have only one container
                String containerName;
                if(response.length < 2){
                    System.out.println("You can't inspect nothing");
                }else{
                    containerName = response[1];
                    if(player.inspect() != null){
                        System.out.println(player.inspect());
                        for(Item item: player.inspect()){
                            player.getCurrentLocation().addItem(item);
                        }
                    }else{
                        System.out.println("You can't look there.");
                    };
                }
            }
            // results in jframe window with map jpeg popping up
            case "map" ->{
                generateMap.showMapFrame();
            }

            // input action verb does not match
            default -> System.out.println("Unreadable input. Please try again.");
        }
    }

    //TODO: error checking on user input response
    public String goActionPrompt(Player player){
        System.out.println("Where would you like to go? " + ANSI_PURPLE + "[ North, South, East, West ]: " + ANSI_RESET);
        String response = userInput.nextLine().toLowerCase();
        player.go(response);
        return response;
    }
}
