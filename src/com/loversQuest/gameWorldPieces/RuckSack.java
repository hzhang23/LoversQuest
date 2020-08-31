package com.loversQuest.gameWorldPieces;

import java.util.HashMap;
import java.util.Map;

public class RuckSack {

    protected Map<String, Integer> items = new HashMap<>();

    // CTOR
    protected RuckSack(String item, int quantity) {
        this.items = items;
    }

    // Business Methods
    protected void addItem(String item, int quantity) {
        this.items.put(item, quantity);
    }

    protected void displayItems() {
        // display all contents of ruckSack
        items.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
