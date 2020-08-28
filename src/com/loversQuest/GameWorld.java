package com.loversQuest;

import com.loversQuest.IO.Input;
import com.loversQuest.IO.Output;
import com.loversQuest.gameWorld.Location;
import com.loversQuest.gameWorld.Player;

public class GameWorld {
    public Location nothing = new Location("NOTHING", "THIS IS NOTHING");
    public Location barracks = new Location("BARRACKS", "It smells of gym socks and peanut butter.");

    public Location gym = new Location("GYM", "You watch a soldier conduct the “BEND AND REACH” in the squat rack while grunts and clanking of weights can be heard in the far back/corner.\n" +
            "\n" +
            "You see your battle buddies taking an APFT (ARMY PHYSICAL FITNESS TEST) in the basketball courts. A drill sergeant is staring at you with his beady eyes. ");

    public Location laundryRoom = new Location("LAUNDRYROOM",
            "Oxyclean and bleach are the scents noticed in this area. Stuffed in the corner is a copious " +
                    "amount of green laundry bags. You also notice “Sick Call Ranger” hiding behind the last dryer " +
                    "with the remnants of his last uncrustable around his mouth. \n");

    public Location courtYard = new Location("COURTYARD", "A vast field littered with cigarettes butts, empty monster cans, and fellow soldiers. Your unit is conducting some sort of exam. Upon closer look, there’s a COMBAT LIFE SAVER WARRIOR SKILL LEVEL 1 EXAM taking place.\n" +
            "\n" +
            "You notice something reflecting in a pile of garbage next to the CLS instructor.");

    public Location range = new Location("RANGE", "You hear the sound of rifles going off… \n" +
            "Under the bleachers is a suspicious ammo box (WC).\n" +
            "Directly under the range tower stands a drill sergeant drinking a monster, ");

    public Location portaJohn = new Location("PORTAJOHN", "You step into the portajohn and see a BLUE FALCON sleeping next to a bottomless pit of despair. It smells of elephant flatulent and rotting garbage. \n");

    public Location chowHall = new Location("CHOWHALL", "Your stomach grumbles as you pass by the variety of fried foods in the red categorized section. Your favorite CHOW HALL LADY is speaking to you in your native tongue...\n");

    public Location px = new Location("PX", "The company’s Executive Officer (XO) is eating a Charlie’s cheesesteak by the WEST exit of the food court. There’s a lone individual first aid kit (IFAK) next to a potted plant. You look far to the WEST and see a silhouette of a full-bodied individual.\n");

    public Location gazebo = new Location("GAZEBO", "At first glance, you don’t see anything through the misty night but out from the shadows appears your AIT bf/gf - You’re elated. \n" +
            "\n" +
            "He or She or they or it asks, “How many white claws did you bring me?”\n");

    public Player p1 = new Player("Bob", barracks);

    public void createMap(){

        barracks.setEast(gym);
        barracks.setNorth(courtYard);
        barracks.setSouth(nothing);
        barracks.setWest(laundryRoom);

        laundryRoom.setWest(nothing);
        laundryRoom.setNorth(nothing);
        laundryRoom.setSouth(nothing);
        laundryRoom.setEast(barracks);

        courtYard.setSouth(barracks);
        courtYard.setNorth(range);
        courtYard.setWest(nothing);
        courtYard.setEast(nothing);

        range.setSouth(courtYard);
        range.setNorth(nothing);
        range.setWest(nothing);
        range.setEast(nothing);

        gym.setWest(barracks);
        gym.setNorth(portaJohn);
        gym.setSouth(chowHall);
        gym.setEast(nothing);

        portaJohn.setSouth(gym);
        portaJohn.setWest(nothing);
        portaJohn.setNorth(nothing);
        portaJohn.setEast(nothing);

        chowHall.setNorth(gym);
        chowHall.setEast(nothing);
        chowHall.setWest(nothing);
        chowHall.setSouth(px);

        px.setNorth(chowHall);
        px.setEast(nothing);
        px.setWest(gazebo);
        px.setSouth(nothing);

        gazebo.setEast(px);
        gazebo.setNorth(nothing);
        gazebo.setWest(nothing);
        gazebo.setSouth(nothing);

    }

    public static void main(String[] args) {

//        Location nothing = new Location("NOTHING", "THIS IS NOTHING");
//        Location barracks = new Location("BARRACKS", "smells like pooooooOoooh");
//        Location gym = new Location("GYM", "smells like socks");
//        Location laundryRoom = new Location("LAUNDRYROOM", "smells like that purp stuff FABULOSO");
//        Location courtYard = new Location("COURTYARD", "smells like ciggies");
//        Location range = new Location("RANGE", "smells like more ciggies and ARTICLE15s");
//        Location portaJohn = new Location("PORTAJOHN", "smells like SHIT");
//        Location chowHall = new Location("CHOWHALL", "smells like kimchi");
//        Location px = new Location("PX", "smells like manchu wok");
//        Location gazebo = new Location("GAZEBO", "smells like head and shoulders");
//
//        barracks.setEast(gym);
//        barracks.setNorth(courtYard);
//        barracks.setSouth(nothing);
//        barracks.setWest(laundryRoom);
//
//        laundryRoom.setWest(nothing);
//        laundryRoom.setNorth(nothing);
//        laundryRoom.setSouth(nothing);
//        laundryRoom.setEast(barracks);
//
//        courtYard.setSouth(barracks);
//        courtYard.setNorth(range);
//        courtYard.setWest(nothing);
//        courtYard.setEast(nothing);
//
//        range.setSouth(courtYard);
//        range.setNorth(nothing);
//        range.setWest(nothing);
//        range.setEast(nothing);
//
//        gym.setWest(barracks);
//        gym.setNorth(portaJohn);
//        gym.setSouth(chowHall);
//        gym.setEast(nothing);
//
//        portaJohn.setSouth(gym);
//        portaJohn.setWest(nothing);
//        portaJohn.setNorth(nothing);
//        portaJohn.setEast(nothing);
//
//        chowHall.setNorth(gym);
//        chowHall.setEast(nothing);
//        chowHall.setWest(nothing);
//        chowHall.setSouth(px);
//
//        px.setNorth(chowHall);
//        px.setEast(nothing);
//        px.setWest(gazebo);
//        px.setEast(nothing);
//
//        gazebo.setEast(px);
//        gazebo.setNorth(nothing);
//        gazebo.setWest(nothing);
//        gazebo.setSouth(nothing);

////        System.out.println(barracks);
////        System.out.println(gym);
////        System.out.println(gazebo);
//
//        createmap();
//        Player ipMan = new Player("Joe", barracks);
//        ipMan.go("EAST");
////        System.out.println(ipMan.getCurrentLocation());
//        ipMan.go("south");
////        System.out.println(ipMan.getCurrentLocation());
//
//        Output.displayIntroDialog();
//
//        Input yeahYeahYeah = new Input();
//        yeahYeahYeah.userActionPrompt();

    }
}
