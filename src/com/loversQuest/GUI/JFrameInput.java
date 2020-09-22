package com.loversQuest.GUI;

import com.loversQuest.gameWorldPieces.Item;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JFrameInput {

    InputParser parser = new InputParser();

    /**
     * when player enter a valid change direction command, return a msg that direction has been changed and he is inside a new location
     * @param direction
     * @param player
     * @return
     */
    public String displayGoResponse(String direction, Player player) {

        String status = "You head to the " + direction + " and find yourself in the " + player.getCurrentLocation().getName();
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

        String finalResponse = null;
        String[] response = command.trim().toLowerCase().split("\\s+");
        response = parser.userCommandScreening(response);

        // parses user response further, into second array
        String objResponse = String.join(" ", Arrays.copyOfRange(response, 1, response.length));
        ArrayList responseList = new ArrayList(Arrays.asList(response));

        String actionVerb = parser.parseCommand(response[0]);
        String[] matchObj = parser.findMatchObj(objResponse, actionVerb);

        switch (actionVerb) {
            case "go" -> {
                if (response.length < 2) {
                    return "cannot go nowhere";
                } else if (matchObj.length == 1) {
                    String direction = matchObj[0];
                    boolean isGo = player.go(direction);
                    if(isGo) {
                        finalResponse = (displayGoResponse(direction, player));
                    } else {
                        finalResponse = "cannot go this way, yo";
                    }
                } else {
                    finalResponse = ("what is direction of " + objResponse + "? how come you can be as lost as a LT?");
                }
            }
            case "look" -> finalResponse = (player.look());
            case "interact" -> {
                if (matchObj.length == 1) {
                    finalResponse = (player.interact(matchObj[0]));
                } else if (matchObj.length > 1) {
                    if (player.getCurrentLocation().getOccupants().size() == 1) {
                        NonPlayerCharacters npc = player.getCurrentLocation().getOccupants().get(0);
                        finalResponse = (player.interact(npc.getName().toLowerCase()));
                    } else {
                        List<NonPlayerCharacters> npcList = player.getCurrentLocation().getOccupants();
                        StringBuilder sb = new StringBuilder();
                        ArrayList<String> npcNames = new ArrayList<>();
                        for (int j = 0; j < npcList.size(); j++) {
                            String npcName = npcList.get(j).getName().toLowerCase();
                            for (int i = 0; i < matchObj.length; i++) {
                                if (matchObj[i].equals(npcName)) {
                                    npcNames.add(npcName);
                                }
                            }
                            if (npcNames.size() == 1) {
                                finalResponse = player.interact(npcNames.get(0).toLowerCase());
                            } else {
                                for (int i = 0; i < npcNames.size(); i++) {
                                    if (j == npcList.size() - 1) {
                                        sb.append(" or ");
                                    }
                                    sb.append(npcList.get(j).getName());
                                }
                                finalResponse = "who do you like to talk to, " + sb.toString() + "?";
                            }
                        }
                    }
                    }else{
                    if (response.length <2 ) {
                        return "you cannot talk to nobody";
                    }
                    finalResponse = "you look around " + player.getCurrentLocation().getName() + ", and cannot find " + objResponse;
                }
                }
            case "inventory" -> finalResponse = (player.displayItems());

            case "get" -> {
                if (matchObj.length == 0) {
                    finalResponse = player.pickUpItem(objResponse);
                } else if (matchObj.length == 1) {
                    finalResponse = player.pickUpItem(matchObj[0]);
                } else {
                    List<Item> itemList = player.getCurrentLocation().getContainer().displayContents();
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < itemList.size(); j++) {
                        String itemName = itemList.get(j).getName().toLowerCase();
                        for (int i = 0; i < matchObj.length; i++) {
                            if (matchObj[i].equals(itemName)) {
                                if (j != itemList.size() - 1) {
                                    sb.append(" , ");
                                } else {
                                    sb.append(" or ");
                                    //sb.append(itemList.get(j).getName());
                                }
                                sb.append(itemList.get(j).getName());
                            }
                        }
                    }
                    finalResponse = "which one of these" + sb.toString() + " would you like?";
                }
            }
            case "use" -> {
                if (matchObj.length == 0) {
                    finalResponse = player.useItem(objResponse);
                } else if (matchObj.length == 1) {
                    finalResponse = player.useItem(matchObj[0]);
                } else {
                    finalResponse = "Don't be so greedy! try to " + response[0] + " one " + objResponse + " at a time!";
                }
            }
            case "inspect" -> finalResponse = player.inspect();
            case "help" -> finalResponse = player.helpGuide();
            default -> finalResponse = ("why do you mumbling like " + command + "? try again with plain English please.");
        }

        return finalResponse;
    }
}


