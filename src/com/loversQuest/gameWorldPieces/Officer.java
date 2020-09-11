package com.loversQuest.gameWorldPieces;

public class Officer extends NonPlayerCharacters{
    private int numOfItemsNeeded;
    private String keyItemName;
    private Location sendPlayerDestination;

    //ctor
    public Officer(String name, Location location) {
        super(name, location);
    }
    public Officer(String name, String description, Location location) {
        super(name, description, location);
    }

    //getter & setter
    public void setSendPlayerDestination(Location location){
        this.sendPlayerDestination = location;
    }
    public void setKeyItemName (String keyItemName){
        this.keyItemName = keyItemName;
    }
    public void setNumOfItemsNeeded(int numOfItemsNeeded){
        this.numOfItemsNeeded = numOfItemsNeeded;
    }

    //overlaps with interact override below
    public String reRoute(Player player){
        player.setCurrentLocation(sendPlayerDestination);
        return "It would behoove you.... \n(He sends you back to complete all your warrior tasks)";
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
            player.setHasChallengeCoin(true);
            player.addItem(this.getPrize());
            return "You have made all the boxes green. Good job, carry on.";

        }else if(player.ruckSack.getItem(this.getPrize().getName()) == null)
            player.setCurrentLocation(sendPlayerDestination);
            return "It would behoove you.... \n(He sends you back to complete all your warrior tasks)";
        }


    }
