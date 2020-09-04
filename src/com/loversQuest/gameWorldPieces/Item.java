package com.loversQuest.gameWorldPieces;

import java.util.HashMap;

public class Item {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";

    private String name;
    private String useResponse;

    // CTOR

    public Item(String name, String use){
        this.name = name;
        this.useResponse = use;
    }

    //business method
    public String use(){
        return this.useResponse;
    }

    // ACCESSOR METHODS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getColorName(){
        return BLUE + this.name + ANSI_RESET;
    }


    @Override
    public String toString() {
        return this.getName().toLowerCase();
    }
}
