package com.loversQuest.gameWorldPieces;

import java.util.List;

public class Player {

    private String name;
    private Location currentLocation;
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
                if(this.isHasCertainItem("Soldier of Month Certificate"))
                {
                    this.ruckSack.addItem(currentLocation.getContainer().getItem("diamond ring"));
                    return "you finally get that diamond ring! check it out and go find your Darling!";
                } else {
                    return "the diamond ring is like twice as much as your pay check. However, if you could show me your soldier of the month certificate, you can get 99% discount";
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
            if(conList.size() >0 ) {
                response.append(conName);
                response.append(" , and found ");
                response.append(conList.toString());
                result = response.toString();
            } else {
                result = "there is nothing inside " + this.currentLocation.getContainer().getName();
            }
        }
        return result;
    }

    /**
     * check if player have an item by name
     * @param itemName
     * @return
     */

    public boolean isHasCertainItem(String itemName) {
        List<Item> allItems = this.getAllItems();
        for (Item item : allItems) {
            if (item.getName().toLowerCase().equals(itemName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * return a string to show what to do here
     */

    public String helpGuide(){
        String npcNames = null;
        for (int i= 0; i < this.getCurrentLocation().getOccupants().size(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(this.getCurrentLocation().getOccupants().get(i).getName());
            if (i != this.getCurrentLocation().getOccupants().size()-1 ){
                sb.append(" or ");
            }
            npcNames = sb.toString();
        }
        return "try to inspect " + this.getCurrentLocation().getContainer().getName() + " or talk to " + npcNames;
    }

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
    public void addItem(Item item) { ruckSack.addItem(item); }
    public Item getItem(String itemName) {
        return this.ruckSack.getItem(itemName.toLowerCase());
    }

}

