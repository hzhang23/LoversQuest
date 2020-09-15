package com.loversQuest.gameWorldPieces;

/**
 * location is some thing that has name , description, container and an Item List & NPC
 */


import java.util.*;

public class Location {

    private String name;
    private String description;
    private Container container;
    private ArrayList<Item> itemsList = new ArrayList<>();
    private NonPlayerCharacters occupant;

    //hash map with keys = enum of cardinal directions and values = Location instances
    private HashMap<CardinalDirection, Location> directionMap = new HashMap<>();

    // CTOR
    public Location(){

    }

    public Location(String name, String description) {
        this.name = name;
        this.description = description;

        this.directionMap.put(CardinalDirection.NORTH, null);
        this.directionMap.put(CardinalDirection.SOUTH, null);
        this.directionMap.put(CardinalDirection.EAST, null);
        this.directionMap.put(CardinalDirection.WEST, null);
    }

    // SETTERS/GETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        StringBuilder result = new StringBuilder(this.description + " ");
        if(this.container != null){
            result.append("You see a suspicious looking " + container.getName()+ ".\n");
        }

        if(this.itemsList.size() > 0){
             result.append("You find " +
                    this.getItemsList().toString() + " in the room.\n");
        }
        if(this.getOccupant() != null){
            result.append("You see " +
                    this.getOccupant().getName() +
                    ". They " + this.getOccupant().getDescription());
        }
        return result.toString();


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
            //if direction enum to string is same as input string direction
            if(direction.toString().equalsIgnoreCase(stringDirection)){
                //return the location in that direction
                result = directionMap.get(direction);
            }
        }
        return result;
    }

    // return value from direction hashmap corresponding to the given enum
    public String getEast(){
        return directionMap.get(CardinalDirection.EAST);
    }
    public String getWest(){
        return directionMap.get(CardinalDirection.WEST);
    }
    public String getSouth(){
        return directionMap.get(CardinalDirection.SOUTH);
    }
    public String getNorth(){
        return directionMap.get(CardinalDirection.NORTH);
    }

    // replace value in direction hashmap with new Location instance
    public void setNorth(String area){
        directionMap.replace(CardinalDirection.NORTH, area);
    }
    public void setSouth(String area){
        directionMap.replace(CardinalDirection.SOUTH, area);
    }
    public void setEast(String area){
        directionMap.replace(CardinalDirection.EAST, area);
    }
    public void setWest(String area){
        directionMap.replace(CardinalDirection.WEST, area);
    }

//    @Override
//    public String toString() {
//        return "Location{" +
//                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", East=" + getEast().getName() +
//                ", North=" + getNorth().getName() +
//                ", South=" + getSouth().getName() +
//                ", West=" + getWest().getName() +
//                '}';
//    }
}

