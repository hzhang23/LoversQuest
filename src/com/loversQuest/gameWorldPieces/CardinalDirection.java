package com.loversQuest.gameWorldPieces;

public enum CardinalDirection {
    NORTH("north"),
    SOUTH("south"),
    EAST("north"),
    WEST("west");
    private String direction;

    private CardinalDirection(String direction){
        this.direction = direction;
    };

    public String getDirection(){
        return direction;
    }
}
