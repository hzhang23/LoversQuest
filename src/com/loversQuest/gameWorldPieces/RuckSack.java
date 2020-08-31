package com.loversQuest.gameWorldPieces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuckSack {

    protected Map<String, Integer> items = new HashMap<>();

    // CTOR
    public RuckSack() {}

    public RuckSack(String item) {
        items.put(item, 1);
    }

    // Business Methods
    public void addItem(String item) {
        items.put(item, 1);
    }

    // display all items in ruckSack
    protected void displayRuckSackContents() {
        System.out.println("Contents of RuckSack: ");
        items.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
