package com.loversQuest.gameWorldPieces;

public class NonPlayerCharacters {
    private String name;
    private String description;
    private Location location;
    private Item keyItem;
    private Item prize;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";

    public NonPlayerCharacters(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public NonPlayerCharacters(String name, String description, Location location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public NonPlayerCharacters() {
    }

    public String getName() {
        return BLUE + name + ANSI_RESET;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeyItem(Item keyItem){
        this.keyItem = keyItem;
    }

    public String getLocation() {
        return location.getName();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPrize(Item item){
        this.prize = item;
    }

    public String interact(Player player){
        if (this.keyItem == null){
            return "I got nothing for you loser";
        }
        if(player.getItem(keyItem.getName()) != null){
            player.addItem(prize);
            return "Ah, I see you have " + keyItem + ", good work soldier!";
        }else{
            return "You don't have " + keyItem + ", kick rocks nerd!";
        }
    }



}
