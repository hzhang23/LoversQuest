package com.loversQuest.gameWorldPieces;


import java.util.*;

public class Location {

    private String name;
    private String description;
    private Container container;
    private ArrayList<Item> itemsList = new ArrayList<>();

    private NonPlayerCharacters occupant;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";

    //hash map with keys = enum of cardinal directions and values = Location instances
    private HashMap<CardinalDirection, Location> directionMap = new HashMap<>();

    // CTOR
    public Location(String name, String description) {
        this.name = name;
        this.description = description;

        this.directionMap.put(CardinalDirection.NORTH, null);
        this.directionMap.put(CardinalDirection.SOUTH, null);
        this.directionMap.put(CardinalDirection.EAST, null);
        this.directionMap.put(CardinalDirection.WEST, null);
    }

    // SETTERS/GETTERS
    public String getColoredName() {
        return BLUE + name + ANSI_RESET;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        if(this.itemsList.size() > 0){
            return description + "You find " + this.getItemsList().toString() + " in the room.";
        }else{
            return description;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
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

    //returns the location that is in the direction given via string
    public Location getDirectionFromString(String stringDirection){
        Location result = null;
        //loop through key set of direction map
        for(CardinalDirection direction : directionMap.keySet()){
            // if the cardinal direction string matches the input string
            if(direction.getDirectionName().equals(stringDirection)){
                //return the location in that direction
                result = directionMap.get(direction);
            }
        }
        return result;
    }

    // return value from direction hashmap corresponding to the given enum
    public Location getEast(){
        return directionMap.get(CardinalDirection.EAST);
    }
    public Location getWest(){
        return directionMap.get(CardinalDirection.WEST);
    }
    public Location getSouth(){
        return directionMap.get(CardinalDirection.SOUTH);
    }
    public Location getNorth(){
        return directionMap.get(CardinalDirection.NORTH);
    }

    // replace value in direction hashmap with new Location instance
    public void setNorth(Location area){
        directionMap.replace(CardinalDirection.NORTH, area);
    }
    public void setSouth(Location area){
        directionMap.replace(CardinalDirection.SOUTH, area);
    }
    public void setEast(Location area){
        directionMap.replace(CardinalDirection.EAST, area);
    }
    public void setWest(Location area){
        directionMap.replace(CardinalDirection.WEST, area);
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

