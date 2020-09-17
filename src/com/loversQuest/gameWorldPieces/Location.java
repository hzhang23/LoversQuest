package com.loversQuest.gameWorldPieces;

/**
 * location is some thing that has name , description, container and an Item List & NPC
 */

import com.loversQuest.excelReader.ReadExcel;
import java.util.*;

public class Location {

    private String name;
    private String description;
    private Container container;
    private ArrayList<Item> itemsList = new ArrayList<>();
    private NonPlayerCharacters occupant;
    private HashMap<CardinalDirection,String> directionMap = new HashMap<>();

    //TODO: See if below variable could be refactor to a consolidate place
    public static String filePath = "resources/gameBook.xlsx";
    public static Map<String, Location> locationMap = ReadExcel.getLocationMap(filePath);

    // CTOR
    public Location(){
        this.directionMap.put(CardinalDirection.NORTH, null);
        this.directionMap.put(CardinalDirection.SOUTH, null);
        this.directionMap.put(CardinalDirection.EAST, null);
        this.directionMap.put(CardinalDirection.WEST, null);
    }

    public Location(String name, String description) {
        this.name = name;
        this.description = description;

        this.directionMap.put(CardinalDirection.NORTH, null);
        this.directionMap.put(CardinalDirection.SOUTH, null);
        this.directionMap.put(CardinalDirection.EAST, null);
        this.directionMap.put(CardinalDirection.WEST, null);
    }

    /**
     * get next direction if a String of direction is provided
     * @param stringDirection
     * @return Location
     */

    public Location getDirectionFromString(String stringDirection){
        Location result = null;
        for(CardinalDirection direction : directionMap.keySet()){
            if(direction.toString().equalsIgnoreCase(stringDirection)){
                String locationName = directionMap.get(direction);
                result = locationMap.get(locationName);
            }
        }
        return result;
    }

    /**
     * getter/setter for the direction Hashmap
     */

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

    /**
     * getter/setter for the class
     * @return
     */

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        StringBuilder result = new StringBuilder(this.description + " ");
        if(this.container != null){
            result.append("And you also see the " + container.getName() + " which seems " + container.getUseResponse() + ".\n");
        }
        if(this.getOccupant() != null){
            result.append("You see " +
                    this.getOccupant().getName() +
                    ". " + this.getOccupant().getDescription());
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

    /**
     * override toString method so it shows location by name description and map location
     * @return
     */

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", East=" + getEast() +
                ", North=" + getNorth() +
                ", South=" + getSouth() +
                ", West=" + getWest() +
                '}';
    }
}

