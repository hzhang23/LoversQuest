package com.loversQuest.gameWorldPieces;

import java.util.*;

public class Location {

    private String name;
    private String description;
    private ArrayList<Item> itemsList = new ArrayList<>();
    private NonPlayerCharacters occupant;

    //hash map with keys = enum of cardinal directions and values = Location instances
    private HashMap<CardinalDirection, Location> direction = new HashMap<>();

    // CTOR

    public Location(String name, String description) {
        this.name = name;
        this.description = description;

        this.direction.put(CardinalDirection.NORTH, null);
        this.direction.put(CardinalDirection.SOUTH, null);
        this.direction.put(CardinalDirection.EAST, null);
        this.direction.put(CardinalDirection.WEST, null);
    }

    // SETTERS/GETTERS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        if(this.itemsList.size() > 0){
            return description + ". You see a " + this.getItemsList().toString();
        }else{
            return description;
        }

    }
    public void setDescription(String description) {
        this.description = description;
    }


    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayList<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public void addItem(Item item){
        this.itemsList.add(item);
    }

    public void removeItem(Item item){
        this.itemsList.remove(item);
    }

    public NonPlayerCharacters getOccupant(){
        return occupant;
    }

    public void setOccupant(NonPlayerCharacters occupant) {
        this.occupant = occupant;

    }

    // return value from direction hashmap corresponding to the given enum
    public Location getEast(){
        return direction.get(CardinalDirection.EAST);
    }
    public Location getWest(){
        return direction.get(CardinalDirection.WEST);
    }
    public Location getSouth(){
        return direction.get(CardinalDirection.SOUTH);
    }
    public Location getNorth(){
        return direction.get(CardinalDirection.NORTH);
    }

    // replace value in direction hashmap with new Location instance
    public void setNorth(Location area){
        direction.replace(CardinalDirection.NORTH, area);
    }
    public void setSouth(Location area){
        direction.replace(CardinalDirection.SOUTH, area);
    }
    public void setEast(Location area){
        direction.replace(CardinalDirection.EAST, area);
    }
    public void setWest(Location area){
        direction.replace(CardinalDirection.WEST, area);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", East=" + getEast().getName() +
                ", North=" + getNorth().getName() +
                ", South=" + getSouth().getName() +
                ", West=" + getWest().getName() +
                '}';
    }
}

