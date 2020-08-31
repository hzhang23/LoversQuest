package com.loversQuest.gameWorldPieces;

import java.util.HashMap;

public class Item {

    private String name;
    private int quantity;
//    private String description;

    // key = name of item, value = quantity of items (eg. whiteclaw: 3)
//    protected HashMap<String, Integer> items = new HashMap<>();

    // CTOR
    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
//        this.description = description;
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

    //    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }

    // BUSINESS METHODS
//
//    protected void displayItems() {
//        // display all contents of ruckSack
//        for (String item: items.keySet()){
//            String key = name.toString();
//            String value = items.get(name).toString();
//            System.out.println(key + " " + value);
//        }
//    }

//    // player.get(item) uses insertItem to add items to the ruckSack
//    protected void addItem (String item, Integer quantity) {
//        items.put(item, quantity);
//        System.out.println(items);
//    }

//    public HashMap removeItem() {
//    }

}
