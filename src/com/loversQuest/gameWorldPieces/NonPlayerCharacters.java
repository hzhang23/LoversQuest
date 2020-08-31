package com.loversQuest.gameWorldPieces;

public class NonPlayerCharacters {
    private String name;
    private Location location;

    public NonPlayerCharacters(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location.getName();
    }

    public void setLocation(Location location) {
        this.location = location;
    }



}
