package com.loversQuest.gameWorldPieces;

/**
 * a Container is an item that is able to store other items in a list.
 */

import java.util.ArrayList;
import java.util.List;

public class Container extends Item {


    private ArrayList<Item> contents = new ArrayList<>();

    public Container(){};
    public Container(String name, String use) {
        super(name, use);
    }

    public void addItem(Item item){
        contents.add(item);
   }
    public void removeItem(Item item){
        contents.remove(item);
   }
    public void emptyContainer(){
        this.contents = new ArrayList<>();
    }

    public ArrayList<Item> displayContents(){
        return contents;
   }

    public Item getItem(String name){
        Item result = null;
        // go through contents of container. set result as first item whose name matches parameter string.
        for(Item item: this.contents){
            if(item.getName().toLowerCase().equals(name.toLowerCase())){
                result = item;
                break;
            }
        }
        return result;
   }

}
