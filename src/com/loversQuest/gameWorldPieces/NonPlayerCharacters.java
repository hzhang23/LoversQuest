package com.loversQuest.gameWorldPieces;

import com.loversQuest.excelReader.JsonGetter;
import com.loversQuest.gameWorldPieces.models_NPC.NPC_Properties;

import java.util.Random;

public class NonPlayerCharacters {
    private String name;
    private String description;
    private NPC_Properties properties;
    private Location location;
    private Item keyItem;
    private Item prize;



    //ctor
    public NonPlayerCharacters(String name, Location location) {
        this(name, "There is no description for this person.", location);
    }

    public NonPlayerCharacters(String name, String description, Location location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public NonPlayerCharacters(String name, String description, Location location, NPC_Properties properties) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.properties = properties;
    }

    public NonPlayerCharacters(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public NonPlayerCharacters() {
    }


    //business methods
    public String interact(Player player){
        String[] returnWords = {JsonGetter.kanyeQuotes(),JsonGetter.taylorQuotes(),JsonGetter.getCatFact()};
        Random rand = new Random();
        int i = rand.nextInt(returnWords.length);
        return returnWords[i];
    }

    //getter&setter

    public NPC_Properties getProperties() {
        return properties;
    }

    public void setProperties(NPC_Properties properties) {
        this.properties = properties;
    }

    public String getName (){
        return name;
    }
//    public String getColorName() {
//        return BLUE + name + ANSI_RESET;
//    }

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

    public Item getKeyItem(){
        return this.keyItem;
    }

    public String getLocation() {
        return location.getName();
    }

    public Location getLocationClass(){return location;}

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPrize(Item item){
        this.prize = item;
    }

    public Item getPrize() {
        return prize;
    }

}
