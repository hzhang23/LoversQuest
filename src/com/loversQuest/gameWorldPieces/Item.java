package com.loversQuest.gameWorldPieces;

import java.util.HashMap;
import java.util.Objects;

public class Item {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";

    private String name;
    private String useResponse;

    // CTOR

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Item item = (Item) o;
//        return name.equals(item.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }

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
