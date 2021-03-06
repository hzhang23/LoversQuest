package com.loversQuest.gameWorldPieces;

import java.util.HashMap;
import java.util.Objects;

/**
 * an Item is something that has a name and give useResponse if use()
 */


public class Item {


    private String name;
    private String useResponse;

    public Item(){}

    public Item(String name, String use){
        this.name = name;
        this.useResponse = use;
    }

    // ACCESSOR METHODS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String use() { return useResponse; }

    public void setUseResponse(String useResponse) { this.useResponse = useResponse;}
    public String getUseResponse() { return useResponse; }
    //    public String getColorName(){
//        return BLUE + this.name + ANSI_RESET;
//    }


    @Override
    public String toString() {
        return this.getName().toLowerCase();
    }
}
