package com.loversQuest.gameWorldPieces;

public class Lover extends NonPlayerCharacters{
    private int numOfItemsNeeded;
    private String keyItemName;

    public Lover(String name, Location location) {
        super(name, location);
    }

    @Override
    public void setPrize(Item item) {
        super.setPrize(item);
    }

    @Override
    public Item getPrize() {
        return super.getPrize();
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
            return "OMG five WhiteClaws for me? I love you";
        }else{
            return "I'm not drinking moldy CamelBak water. Get lost POG";
        }
    }
}
