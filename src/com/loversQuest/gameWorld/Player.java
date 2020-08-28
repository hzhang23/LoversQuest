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
    public void go(String directionInput) {

        String direction = directionInput.toLowerCase();

        if (direction.equals("east")) {
            this.setCurrentLocation(this.currentLocation.getEast());
        } else if (direction.equals("west")) {
            this.setCurrentLocation(this.currentLocation.getWest());
        } else if (direction.equals("south")) {
            this.setCurrentLocation(this.currentLocation.getSouth());
        } else if (direction.equals("north")){
            this.setCurrentLocation(this.currentLocation.getNorth());
        } else {
            System.out.println("bad input, try again");
        }
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
