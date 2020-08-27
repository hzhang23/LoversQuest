package com.loversquest;

public class Location {

    private String name;
    private String description;

    private Location east;
    private Location west;
    private Location north;
    private Location south;

    // CTOR
    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // SETTERS/GETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getEast() {
        return east;
    }

    public void setEast(Location east) {
        this.east = east;
    }

    public Location getWest() {
        return west;
    }

    public void setWest(Location west) {
        this.west = west;
    }

    public Location getNorth() {
        return north;
    }

    public void setNorth(Location north) {
        this.north = north;
    }

    public Location getSouth() {
        return south;
    }

    public void setSouth(Location south) {
        this.south = south;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", east=" + east.getName() +
                ", west=" + west.getName() +
                ", north=" + north.getName() +
                ", south=" + south.getName() +
                '}';
    }
}

