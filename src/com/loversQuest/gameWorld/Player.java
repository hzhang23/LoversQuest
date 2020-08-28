package com.loversQuest.gameWorld;

import com.loversQuest.gameWorld.Location;

public class Player {

    private String name;
    private Location currentLocation;

    // CTOR
    public Player(String name, Location currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    // BUSINESS METHODS

    //go function can result in navigating to "NOTHING" area. need to error check if
    // indicated direction is not a room and prevent movement.
    public void go(String directionInput) {

        String direction = directionInput.toLowerCase();

        if (direction.equals("east")) {
            if(validateLocation(this.currentLocation.getEast())){
                this.setCurrentLocation(this.currentLocation.getEast());
            } else{
                System.out.println("You can't go that way");
            }
        } else if (direction.equals("west")) {
            if(validateLocation(this.currentLocation.getWest())){
                this.setCurrentLocation(this.currentLocation.getWest());
            } else{
                System.out.println("You can't go that way");
            }
        } else if (direction.equals("south")) {
            if(validateLocation(this.currentLocation.getSouth())){
                this.setCurrentLocation(this.currentLocation.getSouth());
            } else{
                System.out.println("You can't go that way");
            }
        } else if (direction.equals("north")){
            if(validateLocation(this.currentLocation.getNorth())){
                this.setCurrentLocation(this.currentLocation.getNorth());
            } else{
                System.out.println("You can't go that way");
            }
        } else {
            System.out.println("bad input, try again");
        }
    }

    public boolean validateLocation(Location destination){
        return !destination.getName().equals("NOTHING");
    }

    public void look(){
        System.out.println(this.getCurrentLocation().getDescription());

    }

    // SETTERS/GETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
