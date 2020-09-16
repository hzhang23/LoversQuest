package com.loversQuest.IO;

import com.loversQuest.GUI.MapFactory;
import com.loversQuest.GUI.MapFrame;
import com.loversQuest.GameWorld;
import com.loversQuest.gameWorldPieces.*;
import com.loversQuest.gameWorldPieces.Container;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.io.IOException;

import java.util.Map;
import java.util.Scanner;

import static com.loversQuest.IO.Output.BLUE;


public class Input {


    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    // private?
    InputParser parser = new InputParser();
    MapFactory generateMap = new MapFactory();

    Scanner userInput = new Scanner(System.in);

    public String displayGoResponse(String direction, Player player) {

//        String status = "You head to the " + direction + " and find yourself in the " + player.getCurrentLocation().getColoredName();
//        return status;

        // loop over directions
        // if input direction doesn't equal a real direction,
        for (CardinalDirection realDirections : CardinalDirection.values()) {

            if (realDirections.toString().equalsIgnoreCase(direction)) {
                String status = "You head to the " + direction + " and find yourself in the " + player.getCurrentLocation().getName();
                return status;
            } else {
                return "Bad Directional Input Private!";
            }
        }
        // why the hell do i need this return statement if im returning in my else block?
        return "Bad Directional Input";
    }

    //TODO: better error / input checking on responseInput and all methods that use util.Scanner

    public String getUserAction(Player player) {

        String finalResponse = null;

        //prompt user for action
        ///move to output class
//        System.out.println("What would you like to do? [ 'go', 'look', 'interact', 'inventory', 'get item']");
        //System.out.println("\nWhat would you like to do? " + ANSI_PURPLE +  "[ go, look, interact, inventory, get <item> ]" + ANSI_RESET);

        String responseInput = userInput.nextLine();

        String[] response = responseInput.trim().toLowerCase().split("\\s+");

        // parses user response further, into second array
        String stringifiedResponse = String.join(" ", Arrays.copyOfRange(response, 1, response.length));

        String actionVerb = parser.parseCommand(response[0]);

        // handles first word of response

        // TODO: KEY LISTENER


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
            case "interact" -> finalResponse = (player.interact());
            case "inventory" -> finalResponse = (player.displayItems());
            case "get" -> {
                Item chosenItem = null;

                // check if item is in location
                for (Item item : player.getCurrentLocation().getItemsList()) {
                    if (stringifiedResponse.equals(item.getName().toLowerCase())) {
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
            case "use" -> {
//              if the item is in current inventory
                for (Item item : player.getAllItems()) {
                    if (stringifiedResponse.equals(item.getName().toLowerCase())) {
                        finalResponse = (player.getItem(item.getName().toLowerCase()).use());
                        break;
                    }
                }
                if (finalResponse == null) {
                    finalResponse = ("You can't use nothing");
                }

            }
            case "inspect" -> {
                // not currently used because locations have only one container
                String containerName;
                if (response.length < 2) {
                    finalResponse = ("You can't inspect nothing");
                } else {
                    containerName = response[1];
                    Container currentContainer = player.getCurrentLocation().getContainer();
                    if (player.inspect() != null &&
                            player.getCurrentLocation().getContainer().getName().contains(containerName.toLowerCase())) {
                        finalResponse = BLUE + (player.inspect()).toString() + ANSI_RESET;
                        for (Item item : player.inspect()) {
                            //add item to location
                            player.getCurrentLocation().addItem(item);
                        }
                        //remove all items from container
                        currentContainer.emptyContainer();
                        System.out.println("container emptied");
                    } else {
                        finalResponse = ("You can't look there.");
                    }
                    ;
                }
            }
            // results in jframe window with map jpeg popping up
            case "map" -> {
                generateMap.showMapFrame();
                finalResponse = "Here's the map.";
            }
            // input action verb does not match
            default -> finalResponse = ("Unreadable input. Please try again.");
        }
        return finalResponse;
    }

    //TODO: error checking on user input response

    public String goActionPrompt(Player player) {
        System.out.println("Where would you like to go? " + ANSI_PURPLE + "[ North, South, East, West ]: " + ANSI_RESET);
        String response = userInput.nextLine().toLowerCase();
        player.go(response);
        return response;
    }

    // TODO: IMPLEMENT ARROW KEY INPUT -> call appropriate go method
    // if user presses up arrow, call go north on player
    public String moveWhenKeyPressed(KeyEvent event, Player player) throws IOException {

        if (event.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up arrow was pressed ninja");
            goActionPrompt(player);
        } else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down arrow pressed");
            goActionPrompt(player);
        } else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("left   arrow   was   pressed");
            goActionPrompt(player);
        } else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println(" right arrow right arrow ");
            goActionPrompt(player);
        }
        return moveWhenKeyPressed(event, player);
    }
}