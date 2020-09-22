package com.loversQuest.gameWorldPieces;

/**
 * location is some thing that has name , description, container and an Item List & NPC
 */

import com.loversQuest.fileHandler.ExcelManager;
import com.loversQuest.gameWorldPieces.models_NPC.NPC_Properties;

import java.util.*;

public class Location {

    private String name;
    private String description;
    private Container container;
    private ArrayList<NonPlayerCharacters> occupants = new ArrayList<>();
    private HashMap<CardinalDirection,String> directionMap = new HashMap<>();
    public static Map<String, Location> locationMap = ExcelManager.getLocationMap();


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
     * check if certain NPC is in this location
     */

    public boolean hasNPC_Property (NPC_Properties property) {
        for (NonPlayerCharacters npc : this.getOccupants()){
            if (npc.getProperties().equals(property)){
                return true;
            }
        }
        return false;
    }

    /**
     * description may vary depends on the occupants and containers
     * @return
     */
    public String getDescription() {
        StringBuilder result = new StringBuilder(this.description + " ");
        if(this.container != null){
            result.append("And you find the " + container.getName() + " which seems " + container.getUseResponse() + ".\n");
        }
        if(!this.getOccupants().isEmpty()){
            result.append("you also see ");
            int i = 0;
            while (i < this.getOccupants().size()){
                NonPlayerCharacters npc = this.getOccupants().get(i);
                result.append(npc.getName() + " " + npc.getDescription());
                if (i != (this.getOccupants().size()-1)){
                    result.append(" and ");}
                i++;
            }
        }
        return result.toString();
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

    public void addOccupants(NonPlayerCharacters occupant){ this.occupants.add(occupant); }
    public ArrayList<NonPlayerCharacters> getOccupants(){
        return occupants;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public NonPlayerCharacters getOccupantByName (String name){
        NonPlayerCharacters npc = null;
        for(NonPlayerCharacters occupant : this.getOccupants()){
            if (occupant.getName().toLowerCase().equals(name)){
                npc = occupant;
            }
        }
        return npc;
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

