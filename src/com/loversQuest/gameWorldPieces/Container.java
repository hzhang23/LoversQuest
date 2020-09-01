package com.loversQuest.gameWorldPieces;

import java.util.ArrayList;
import java.util.List;

public class Container extends Item {

    private ArrayList<Item> contents = new ArrayList<>();


    public Container(String name, String use) {
        super(name, use);
    }

   public void addItem(Item item){
        contents.add(item);
   }
   public void removeItem(Item item){
        contents.remove(item);
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
