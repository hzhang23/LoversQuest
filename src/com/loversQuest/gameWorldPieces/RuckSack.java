package com.loversQuest.gameWorldPieces;

import java.util.HashMap;
import java.util.Map;

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

    // display all items in ruckSack
    protected String displayRuckSackContents() {
        return items.toString();
    }


}
