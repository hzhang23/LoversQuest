package com.loversQuest.gameWorldPieces;

import com.loversQuest.GUI.GameFrame;
import com.loversQuest.GUI.JFrameInput;
import com.loversQuest.gameWorldPieces.models_NPC.DrillSGT_Range;
import com.loversQuest.gameWorldPieces.models_NPC.NPC_Properties;
import com.loversQuest.shootingGame.RangeFrame;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Player {

    private String name;
    private Location currentLocation;
    private double money;
    private boolean hasChallengeCoin = false;
    private boolean hasCertainItem;
    private boolean hasKiss = false;
    public PlayerContainer ruckSack = new PlayerContainer();

    // CTOR
    public Player(String name, Location currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    // BUSINESS METHODS

    public boolean go(String directionInput) {
        String direction = directionInput.toUpperCase();
        String response = null;
        boolean result = false;
        //get indicated destination from direction string
        Location destination = this.currentLocation.getDirectionFromString(direction);
        if (destination != null && validateLocation(destination)) {
            this.setCurrentLocation(destination);
            System.out.println(destination.getName());
            result = true;
        }
        return result;
    }

    // checks if a given location is a place a player can move
    public boolean validateLocation(Location destination) {
        return !destination.getName().toUpperCase().equals("NOTHING");
    }

    public String look() {
            return ("You look around and " + this.getCurrentLocation().getDescription());
    }

    public String interact(String npcRequested) {
        if (currentLocation.getOccupants().isEmpty() || currentLocation.getOccupantByName(npcRequested) == null) {
            String returingMsg = "seems like " + npcRequested + " is not here";
            return returingMsg;
        } else {
            return currentLocation.getOccupantByName(npcRequested).interact(this);
        }
    }


    /**
     * //TODO: add a logic that will remove expendable items
     * @param itemRequested
     * @return
     */
    public String useItem(String itemRequested){
        StringBuilder returningMsg = new StringBuilder();
        Item itemToUse = this.getItem(itemRequested);
        if(itemToUse != null){
            returningMsg.append(itemToUse.getUseResponse());
        }
        else {
            returningMsg.append("you cannot use that");
        }
        return returningMsg.toString();
    }

    /**
     * method to pick up item in location.container and add to ruckSack, location.container.list remove item
     * @param itemRequested
     * @return
     */
    public String pickUpItem(String itemRequested) {
        StringBuilder returningMsg = new StringBuilder();
        Item pickedItem = null;
        if (currentLocation.getContainer() == null){
            returningMsg.append("there is nothing to pick up other than your dignity");
        } else {
            if(itemRequested.toLowerCase().equals("diamond ring")){
                if(this.isHasCertainItem("Army Marksmanship Expert Badge")
                        &&this.isHasCertainItem("Combat Life Saver Badge"))
                {
                    this.ruckSack.addItem(currentLocation.getContainer().getItem("diamond ring"));
                    return "you finally get that diamond ring! check it out and go find your Darling!";
                } else {
                    return "the diamond ring is like twice as much as your pay check. However, soldier of the month awardee will get a huge discount!";
                }
            }



            if (currentLocation.getContainer().displayContents().isEmpty()){
                returningMsg.append("Oops, there is nothing in " + currentLocation.getContainer().getName());
            } else {
                for (Item item: currentLocation.getContainer().displayContents()){
                    if (itemRequested.equals(item.getName())){
                         pickedItem= item;
                        returningMsg.append("you found a " + pickedItem.getName() + "! finders, keepers!");
                    }
                }
                if (pickedItem != null) {
                    this.currentLocation.getContainer().removeItem(pickedItem);
                    this.ruckSack.addItem(pickedItem);
                } else {
                    returningMsg.append("you cannot get a " + itemRequested);
                }
            }
        }
        return returningMsg.toString();
    }

    /**
     * check container in current location
     * @return
     */
    public String inspect() {
        String result = null;
        if(currentLocation.getContainer() != null){
            StringBuilder response = new StringBuilder("you checked out ");
            String conName = this.currentLocation.getContainer().getName();
            List<Item> conList = this.currentLocation.getContainer().displayContents();
            response.append(conName);
            response.append(" , and found ");
            response.append(conList.toString());
            result = response.toString();
        }
        return result;
    }

    public boolean isHasCertainItem(String itemName) {
        List<Item> allItems = this.getAllItems();
        for (Item item : allItems) {
            if (item.getName().toLowerCase().equals(itemName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void setHasCertainItem(boolean hasCertainItem) { this.hasCertainItem = hasCertainItem;}

    public String displayItems() {
        return ruckSack.displayRuckSackContents();
    }
    public List<Item> getAllItems() {
        return ruckSack.items;
    }

    // SETTERS/GETTERS
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Location getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(Location currentLocation) { this.currentLocation = currentLocation; }
    public boolean isHasChallengeCoin() { return hasChallengeCoin; }
    public void setHasChallengeCoin(boolean hasChallengeCoin) { this.hasChallengeCoin = hasChallengeCoin; }
    public boolean isHasKiss() { return hasKiss; }
    public void setHasKiss(boolean hasKiss) { this.hasKiss = hasKiss; }
    public void addItem(Item item) { ruckSack.addItem(item); }
    public Item getItem(String itemName) {
        return this.ruckSack.getItem(itemName.toLowerCase());
    }

}

