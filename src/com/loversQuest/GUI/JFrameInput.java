package com.loversQuest.GUI;

import com.loversQuest.GameWorld;
import com.loversQuest.IO.InputParser;
import com.loversQuest.gameWorldPieces.Item;
import com.loversQuest.gameWorldPieces.Officer;
import com.loversQuest.gameWorldPieces.Player;


import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

import java.util.Scanner;


public class JFrameInput {

    InputParser parser = new InputParser();

    /**
     * when player enter a valid change direction command, return a msg that direction has been changed and he is inside a new location
     * @param direction
     * @param player
     * @return
     */
    public String displayGoResponse(String direction, Player player) {

        String status = "You head to the " +direction+ " and find yourself in the " + player.getCurrentLocation().getName();
        return status;
    }

    /**
     * take player action and return response to show player
     * all the cases should call methods in player class
     * @param player
     * @param command
     * @return
     */
    public String getUserAction(Player player, String command) {
        //TODO: Parser should able to filter through the command and find the item: white claw?? which flavor?
        String finalResponse = null;
        String[] response = command.trim().toLowerCase().split("\\s+");

        // parses user response further, into second array
        String objResponse = String.join(" ", Arrays.copyOfRange(response, 1, response.length));
        System.out.println("objResponse is" + objResponse);

        System.out.println("Command is " + command);
        ArrayList responseList = new ArrayList(Arrays.asList(response));
        System.out.println("Response is " + responseList);
        String actionVerb = parser.parseCommand2(response[0]);


//        parser.findSynonyms(response[0]);


        // handles first word of response

        // this should all go in separate controller class
        switch (actionVerb) {
            case "go" -> {
                String direction = null;
                if (response.length < 2) {
                    return "Cannot go nowhere";
                } else {
                    direction = response[1];
                    Boolean isGo = player.go(direction);
                }
                finalResponse = (displayGoResponse(direction, player));
            }
            case "look" -> finalResponse = (player.look());
            case "interact" -> finalResponse = (player.interact(objResponse));
            case "inventory" -> finalResponse = (player.displayItems());
            case "get" ->finalResponse = player.pickUpItem(objResponse);
            case "use" ->finalResponse = player.useItem(objResponse);
            case "inspect" -> finalResponse= player.inspect();
            default -> finalResponse = ("Unreadable input. Please try again.");
        }

        return finalResponse;
    }

    //TODO: error checking on user input response

    public String goActionPrompt(Player player, String direction) {
        System.out.println("Where would you like to go? [ North, South, East, West ]");
        String response = direction;
        player.go(response);
        return response;
    }
}
