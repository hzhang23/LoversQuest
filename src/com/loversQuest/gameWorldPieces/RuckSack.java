package com.loversQuest.gameWorldPieces;

import java.util.*;

public class RuckSack {

    protected Map<Item, Integer> items = new HashMap<>();

    // CTOR
    public RuckSack() {}

    public RuckSack(Item item) {
        items.put(item, 1);
    }

    // Business Methods
    public void addItem(Item item) {
        items.put(item, 1);
    }

    public Item getItem(String itemName){
        List<Item> itemsList = new ArrayList<>(items.keySet());
        for (Item item : itemsList) {
            if (item.getName().toLowerCase().equals(itemName.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    // display all items in ruckSack
    protected String displayRuckSackContents() {
        return items.toString();
    }


}
