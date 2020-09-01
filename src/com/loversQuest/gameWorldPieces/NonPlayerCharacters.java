package com.loversQuest.gameWorldPieces;

public class NonPlayerCharacters {
    private String name;
    private Location location;
    private Item keyItem;
    private Item prize;


    public NonPlayerCharacters(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String interact(Player player){
        if(player.getItem(keyItem.getName()) != null){
            player.addItem(prize);
            return "Ah, I see you have " + keyItem + ", good work soldier!";
        }else{
            return "You don't have " + keyItem + ", kick rocks nerd!";
        }
    }



}
