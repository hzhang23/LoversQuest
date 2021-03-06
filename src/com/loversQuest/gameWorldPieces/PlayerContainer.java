package com.loversQuest.gameWorldPieces;

import java.util.*;

public class PlayerContainer {

    protected ArrayList<Item> items = new ArrayList<>();

    // CTOR
    public PlayerContainer() {}
    public PlayerContainer(Item item) {
        items.add(item);
    }

    // Business Methods
    public void addItem(Item item) {
        items.add(item);
    }
    public Item getItem(String itemName){
        for (Item item: items) {
            if (item.getName().toLowerCase().equals(itemName.trim().toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getAllItems(){
        return this.items;
    }

    protected String displayRuckSackContents() {
        return items.toString();
    }

}
