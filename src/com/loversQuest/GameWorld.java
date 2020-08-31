package com.loversQuest;

import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;

public class GameWorld {
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

    //Instantiate NPCs
    NonPlayerCharacters sickCallRanger = new NonPlayerCharacters("sick call ranger", laundryRoom);
    NonPlayerCharacters chowHallLady = new NonPlayerCharacters("chow hall lady", chowHall);
    NonPlayerCharacters drillSergeant = new NonPlayerCharacters("drill sergeant", range);
    NonPlayerCharacters blueFalcon = new NonPlayerCharacters("blue falcon", portaJohn);
    NonPlayerCharacters officer = new NonPlayerCharacters("officer", px);
    NonPlayerCharacters ghostyPlayer = new NonPlayerCharacters("ghost", px);

    // sets N, S, E, W directions of rooms in relation to one another
    public void createMap(){

        barracks.setEast(gym);
        barracks.setNorth(courtYard);
        barracks.setSouth(nothing);
        barracks.setWest(laundryRoom);
        barracks.setOccupant(ghostyPlayer);

        laundryRoom.setWest(nothing);
        laundryRoom.setNorth(nothing);
        laundryRoom.setSouth(nothing);
        laundryRoom.setEast(barracks);
        laundryRoom.setOccupant(sickCallRanger);

        courtYard.setSouth(barracks);
        courtYard.setNorth(range);
        courtYard.setWest(nothing);
        courtYard.setEast(nothing);
        courtYard.setOccupant(ghostyPlayer);

        range.setSouth(courtYard);
        range.setNorth(nothing);
        range.setWest(nothing);
        range.setEast(nothing);
        range.setOccupant(drillSergeant);

        gym.setWest(barracks);
        gym.setNorth(portaJohn);
        gym.setSouth(chowHall);
        gym.setEast(nothing);
        gym.setOccupant(ghostyPlayer);

        portaJohn.setSouth(gym);
        portaJohn.setWest(nothing);
        portaJohn.setNorth(nothing);
        portaJohn.setEast(nothing);
        portaJohn.setOccupant(blueFalcon);

        chowHall.setNorth(gym);
        chowHall.setEast(nothing);
        chowHall.setWest(nothing);
        chowHall.setSouth(px);
        chowHall.setOccupant(chowHallLady);

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
