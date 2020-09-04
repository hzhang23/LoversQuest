package com.loversQuest.gameWorldPieces;

public enum CardinalDirection {
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west");

    private String directionName;
    CardinalDirection(String directionName){
        this.directionName = directionName;
    }

    public String getDirectionName() {
        return directionName;
    }
}
