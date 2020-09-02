package com.loversQuest.gameWorldPieces;

import java.util.*;

public class RuckSack {

//    protected Map<Item, Integer> items = new HashMap<>();
    protected List<Item> items = new ArrayList<>();

    // CTOR
    public RuckSack() {}

    public RuckSack(Item item) {
        items.add(item);
    }

    // Business Methods
    public void addItem(Item item) {
//         if item already exists in the ruckSack(HashMap) increment the value(int quantity) by 1.
//         else if item doesn't exist in ruckSack(HashMap), create that item with name as key and quantity 1.

//        if (items.contains(item)) {
//            items.put(item, 1);
//        } else {
//            items.putIfAbsent(item, 1);
//        }
        items.add(item);
        // original code below:
//        items.put(item, 1);
    }

    public Item getItem(String itemName){
        for (Item item: items) {
            if (item.getName().trim().toLowerCase().equals(itemName.trim().toLowerCase())) {
                return item;
            }
        }
        return null;
    }

//    public Item getItem(String itemName){
//        List<Item> itemsList = new ArrayList<>(items.keySet());
//        for (Item item : itemsList) {
//            if (item.getName().toLowerCase().equals(itemName.toLowerCase())) {
//                return item;
//            }
//        }
//        return null;
//    }

    // display all items in ruckSack
    protected String displayRuckSackContents() {
        return items.toString();
    }
}
