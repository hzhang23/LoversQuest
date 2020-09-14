package com.loversQuest.gameWorldPieces;

public class Lover_Old extends NonPlayerCharacters{
    private int numOfItemsNeeded;
    private String keyItemName;

    public Lover_Old(String name, Location location) {
        super(name, location);
    }
    public Lover_Old(String name, String description, Location location) {
        super(name, description, location);
    }


    public void setKeyItemName (String keyItemName){
        this.keyItemName = keyItemName;
    }
    public void setNumOfItemsNeeded(int numOfItemsNeeded){
        this.numOfItemsNeeded = numOfItemsNeeded;
    }

    @Override
    public String interact(Player player) {
        int keyItemCount = 0;
        for(Item item: player.ruckSack.getAllItems()){
            if(item.getName().toLowerCase().contains(this.keyItemName)){
                keyItemCount ++;
            }
        }
        if(keyItemCount >= this.numOfItemsNeeded){
            player.addItem(this.getPrize());
            player.setHasKiss(true);
            return "OMG five WhiteClaws for me? I love you";
        }else{
            return "I'm not drinking moldy CamelBak water. Get lost POG";
        }
    }
}
