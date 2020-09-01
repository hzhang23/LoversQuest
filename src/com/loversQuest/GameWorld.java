package com.loversQuest;

import com.loversQuest.gameWorldPieces.*;

import java.util.Arrays;
import java.util.HashMap;

public class GameWorld {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Location nothing = new Location("NOTHING", "THIS IS NOTHING");
    public Location barracks = new Location("BARRACKS", "It smells of gym socks and peanut butter.");

    public Location gym = new Location("GYM", "You watch a soldier conduct the “BEND AND REACH” in the " +
            "squat rack while grunts and clanking of weights \n" +
            "can be heard in the far back/corner. You see your battle buddies taking an APFT (ARMY PHYSICAL FITNESS TEST) in the basketball courts. \n" +
            "A drill sergeant is staring at you with his beady eyes. ");

    public Location laundryRoom = new Location("LAUNDRYROOM",
            "Oxyclean and bleach are the scents noticed in this area. Stuffed in the corner is a copious \n" +
                    "amount of green laundry bags. You also notice “Sick Call Ranger” hiding behind the last dryer \n" +
                    "with the remnants of his last uncrustable around his mouth. ");

    public Location courtYard = new Location("COURTYARD", "A vast field littered with cigarettes butts, empty monster cans, and fellow soldiers. \n" +
            "Your unit is conducting some sort of exam. Upon closer look, there’s a COMBAT LIFE SAVER WARRIOR SKILL LEVEL 1 EXAM taking place.\n" +
            "You notice something reflecting in a pile of garbage next to the CLS instructor.");

    public Location range = new Location("RANGE", "You hear the sound of rifles going off… \n" +
            "Under the bleachers is a suspicious ammo box (WC).\n" +
            "Directly under the range tower stands a drill sergeant drinking a monster.");

    public Location portaJohn = new Location("PORTAJOHN", "You step into the portajohn and see a BLUE FALCON sleeping next to a bottomless pit of despair. \n" +
            "It smells of elephant flatulent and rotting garbage.");

    public Location chowHall = new Location("CHOWHALL", "Your stomach grumbles as you pass by the variety of fried foods in the red categorized section. \n" +
            "Your favorite CHOW HALL LADY is speaking to you in your native tongue...");

    public Location px = new Location("PX", "The company’s Executive Officer (XO) is eating a Charlie’s cheesesteak by the WEST exit of the food court. \n" +
            "There’s a lone individual first aid kit (IFAK) next to a potted plant.\n" +
            "You look far to the WEST and see a silhouette of a full-bodied individual.\n");

    public Location gazebo = new Location("GAZEBO", "At first glance, you don’t see anything through the misty night \n" +
            "but out from the shadows appears your AIT bf/gf - You’re elated. \n" +
            "He or She or they or it asks, “How many white claws did you bring me?”\n");

    public Player p1 = new Player("Bob", barracks);
    public Item rifle = new Item("M16", "You shoot your rifle in the air in celebration");
    public Item uncrustable = new Item("Uncrustable", "You look lovingly at the peanut butter and strawberry jam sandwich");
    public Item camelback = new Item("CamelBack", "You take a refreshing drink of moldy water.");
    public Item whiteClaw1 = new Item("WhiteClaw", "You take a refreshing drink of Natural Lime");
    public Item whiteClaw2 = new Item("WhiteClaw", "You take a refreshing drink of Black Cherry.");
    public Item whiteClaw3 = new Item("WhiteClaw", "You take a refreshing drink of Ruby Grapefruit");
    public Item whiteClaw4 = new Item("WhiteClaw", "You take a refreshing drink of Mango");


    public void equipPlayer() {
        p1.addItem(rifle);
        p1.addItem(uncrustable);
        p1.addItem(camelback);
    }

    //Instantiate NPCs
    public NonPlayerCharacters sickCallRanger = new NonPlayerCharacters("sick call ranger", laundryRoom);
    public NonPlayerCharacters chowHallLady = new NonPlayerCharacters("chow hall lady", chowHall);
    public NonPlayerCharacters rangeDrillSergeant = new NonPlayerCharacters("drill sergeant", range);
    public NonPlayerCharacters blueFalcon = new NonPlayerCharacters("blue falcon", portaJohn);
    public NonPlayerCharacters officer = new NonPlayerCharacters("officer", px);
    public NonPlayerCharacters gymDrill = new NonPlayerCharacters("Drill Sergeant", gym);
    public NonPlayerCharacters ghostyPlayer = new NonPlayerCharacters("ghost", px);


    // sets N, S, E, W directions of rooms in relation to one another, add characters and items
    public void createMap(){

        barracks.setEast(gym);
        barracks.setNorth(courtYard);
        barracks.setSouth(nothing);
        barracks.setWest(laundryRoom);
        barracks.addItem(whiteClaw1);

        laundryRoom.setWest(nothing);
        laundryRoom.setNorth(nothing);
        laundryRoom.setSouth(nothing);
        laundryRoom.setEast(barracks);
        laundryRoom.setOccupant(sickCallRanger);

        courtYard.setSouth(barracks);
        courtYard.setNorth(range);
        courtYard.setWest(nothing);
        courtYard.setEast(nothing);

        range.setSouth(courtYard);
        range.setNorth(nothing);
        range.setWest(nothing);
        range.setEast(nothing);
        range.setOccupant(rangeDrillSergeant);
        range.addItem(whiteClaw2);

        gym.setWest(barracks);
        gym.setNorth(portaJohn);
        gym.setSouth(chowHall);
        gym.setEast(nothing);
        gym.setOccupant(gymDrill);

        portaJohn.setSouth(gym);
        portaJohn.setWest(nothing);
        portaJohn.setNorth(nothing);
        portaJohn.setEast(nothing);
        portaJohn.setOccupant(blueFalcon);
        portaJohn.addItem(whiteClaw2);

        chowHall.setNorth(gym);
        chowHall.setEast(nothing);
        chowHall.setWest(nothing);
        chowHall.setSouth(px);
        chowHall.setOccupant(chowHallLady);
        chowHall.addItem(whiteClaw3);

        px.setNorth(chowHall);
        px.setEast(nothing);
        px.setWest(gazebo);
        px.setSouth(nothing);
        px.setOccupant(officer);

        gazebo.setEast(px);
        gazebo.setNorth(nothing);
        gazebo.setWest(nothing);
        gazebo.setSouth(nothing);

    }





}
