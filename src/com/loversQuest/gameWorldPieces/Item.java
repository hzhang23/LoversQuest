package com.loversQuest.gameWorldPieces;

import java.util.HashMap;

public class Item {

    private String name;
    private int quantity = 1;
    private String useResponse;

    // CTOR
    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

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

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.getName().toLowerCase();
    }
}
