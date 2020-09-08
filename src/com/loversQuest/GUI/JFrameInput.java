package com.loversQuest.GUI;

import com.loversQuest.GameWorld;
import com.loversQuest.IO.InputParser;
import com.loversQuest.gameWorldPieces.Item;
import com.loversQuest.gameWorldPieces.Officer;
import com.loversQuest.gameWorldPieces.Player;


import java.awt.*;
import java.util.Arrays;
import java.io.IOException;

import java.util.Scanner;


public class JFrameInput {

    // private?
    InputParser parser = new InputParser();
    MapFactory generateMap = new MapFactory();

    Scanner userInput = new Scanner(System.in);



    public String displayGoResponse(String direction, Player player) throws IOException{

        String status = "You head to the " +direction+ " and find yourself in the " + player.getCurrentLocation().getName();

        return status;
//                  + graphicImage.printLocation("home.txt");
    }

    //TODO: better error / input checking on responseInput and all methods that use util.Scanner

    //takes a command to be taken in by jframe input text section
    public String getUserAction(Player player, String command) throws IOException{

        String finalResponse = null;


        String[] response = command.trim().toLowerCase().split("\\s+");

        // parses user response further, into second array
        String stringifiedResponse = String.join(" ", Arrays.copyOfRange(response, 1, response.length));

        String actionVerb = parser.parseCommand(response[0]);

        // handles first word of response

        // this should all go in separate controller class
        switch (actionVerb) {
            case "go" -> {
                String direction = null;
                if (response.length < 2) {
                    return "Cannot go nowhere";
                } else {
                    direction = response[1];
                    // player.go returns false if bad input, return statement prevents displayGoResponse() from running
                    if (!player.go(direction)) return "You can't go that way.";
                }
                finalResponse = (displayGoResponse(direction, player));
            }
            case "look" -> finalResponse = (player.look());
            case "interact" -> finalResponse = (player.interact());
            case "inventory" -> finalResponse = (player.displayItems());
            case "get" ->{
                Item chosenItem = null;

                // check if item is in location
                for (Item item: player.getCurrentLocation().getItemsList()) {
                    //originally: stringifiedResponse.equals(item.getName().toLowerCase())
                    if (item.getName().toLowerCase().contains(stringifiedResponse) && stringifiedResponse.length() > 2){
                        chosenItem = item;
                        break;
                    }
                }
                // if item is in location pick up item
                if (chosenItem != null) {
                    player.pickUpItem(stringifiedResponse);
                    finalResponse = ("You picked up " + stringifiedResponse);
                } else {
                    finalResponse = ("You can't pick that up");
                }

            }
            case "use" ->{
//              if the item is in current inventory
                for (Item item: player.getAllItems()) {
                    if (item.getName().toLowerCase().contains(stringifiedResponse) && stringifiedResponse.length() > 2){
                        finalResponse = (player.getItem(item.getName().toLowerCase()).use());
                        break;
                    }
                }
                if(finalResponse == null){
                    finalResponse = ("You can't use that");
                }

            }
            case "inspect" ->{
                // not currently used because locations have only one container
                String containerName;
                if(response.length < 2){
                    finalResponse = ("You can't inspect that");
                }else{
                    containerName = response[1];
                    if(player.inspect() != null){
                        finalResponse = "You find a " + (player.inspect()).toString();
                        for(Item item: player.inspect()){
                            player.getCurrentLocation().addItem(item);
                        }
                    }else{
                        finalResponse = ("You can't look there.");
                    };
                }
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

    public String goActionPrompt(Player player, String direction) throws IOException{
        System.out.println("Where would you like to go? [ North, South, East, West ]");
        String response = direction;
        player.go(response);
        return response;
    }
}
