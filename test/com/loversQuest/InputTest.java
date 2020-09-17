package com.loversQuest;

import com.loversQuest.GUI.MapFactory;
import com.loversQuest.IO.InputParser;
import com.loversQuest.gameWorldPieces.Item;
import com.loversQuest.gameWorldPieces.Player;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class InputTest {

    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    // private?
    InputParser parser = new InputParser();
    MapFactory generateMap = new MapFactory();

    InputStream inputStream = GameInterfaceTest.class.getResourceAsStream("inputTest.txt");
    Scanner testScanner = new Scanner(inputStream);

    Scanner userInput = testScanner;



    public String displayGoResponse(String direction, Player player) throws IOException{

        String status = "You head to the " +direction+ " and find yourself in the " + player.getCurrentLocation().getName();

          return status;
//                  + graphicImage.printLocation("home.txt");
    }

    //TODO: better error / input checking on responseInput and all methods that use util.Scanner




    public String getUserAction(Player player) throws IOException{

        String finalResponse = null;

        //prompt user for action
        ///move to output class
        // System.out.println("What would you like to do? [ 'go', 'look', 'interact', 'inventory', 'get item']");
        //System.out.println("\nWhat would you like to do? " + ANSI_PURPLE +  "[ go, look, interact, inventory, get <item> ]" + ANSI_RESET);

        String responseInput = userInput.nextLine();


        String[] response = responseInput.trim().toLowerCase().split("\\s+");

        // parses user response further, into second array
        String stringifiedResponse = String.join(" ", Arrays.copyOfRange(response, 1, response.length));

        String actionVerb = parser.parseCommand(response[0]);

        // handles first word of response

        // this should all go in separate controller class
        switch (actionVerb) {
            case "go" -> {
                String direction;
                if (response.length < 2) {
                    direction = goActionPrompt(player);
                } else {
                    direction = response[1];
                    // player.go returns false if bad input, return statement prevents displayGoResponse() from running
                    if (!player.go(direction)) return "You can't go that way.";
                }
                finalResponse = (displayGoResponse(direction, player));
            }
            case "look" -> finalResponse = (player.look());
            case "interact" -> finalResponse = (player.interact(response[1]));
            case "inventory" -> finalResponse = (player.displayItems());
            case "get" ->{ finalResponse = player.pickUpItem(responseInput);
//                Item chosenItem = null;
//
//                // check if item is in location
//                for (Item item: player.getCurrentLocation().getItemsList()) {
//                    if (stringifiedResponse.equals(item.getName().toLowerCase())){
//                        chosenItem = item;
//                        break;
//                    }
//                }
//                // if item is in location pick up item
//                if (chosenItem != null) {
//                    player.pickUpItem(stringifiedResponse);
//                    finalResponse = ("You picked up " + stringifiedResponse);
//                } else {
//                    finalResponse = ("You can't pick that up");
//                }

            }
            case "use" ->{
//              if the item is in current inventory
                for (Item item: player.getAllItems()) {
                    if (stringifiedResponse.equals(item.getName().toLowerCase())){
                        finalResponse = (player.getItem(item.getName().toLowerCase()).use());
                        break;
                    }
                }
                if(finalResponse == null){
                    finalResponse = ("You can't use nothing");
                }

            }
            case "inspect" ->{
                player.inspect();
                // not currently used because locations have only one container
//                String containerName;
//                if(response.length < 2){
//                    finalResponse = ("You can't inspect nothing");
//                }else{
//                    containerName = response[1];
//                    if(player.inspect() != null){
//                        finalResponse = (player.inspect()).toString();
//                        for(Item item: player.inspect()){
//                            player.getCurrentLocation().addItem(item);
//                        }
//                    }else{
//                        finalResponse = ("You can't look there.");
//                    };
//                }
            }
            // results in jframe window with map jpeg popping up
            case "map" ->{
                generateMap.showMapFrame();
                finalResponse = "Here's the map.";
            }

            // input action verb does not match
            default -> finalResponse = ("Unreadable input. Please try again.");
        }
        return finalResponse;
    }

    //TODO: error checking on user input response

    public String goActionPrompt(Player player) throws IOException{
        System.out.println("Where would you like to go? " + ANSI_PURPLE + "[ North, South, East, West ]: " + ANSI_RESET);
        String response = userInput.nextLine().toLowerCase();
        player.go(response);
        return response;
    }
}
