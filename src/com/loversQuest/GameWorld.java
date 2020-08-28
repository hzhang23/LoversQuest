package com.loversQuest;

import com.loversQuest.IO.Input;
import com.loversQuest.IO.Output;
import com.loversQuest.gameWorld.Location;
import com.loversQuest.gameWorld.Player;

public class GameWorld {
    public Location nothing = new Location("NOTHING", "THIS IS NOTHING");
    public Location barracks = new Location("BARRACKS", "smells like pooooooOoooh");
    public Location gym = new Location("GYM", "smells like socks");
    public Location laundryRoom = new Location("LAUNDRYROOM", "smells like that purp stuff FABULOSO");
    public Location courtYard = new Location("COURTYARD", "smells like ciggies");
    public Location range = new Location("RANGE", "smells like more ciggies and ARTICLE15s");
    public Location portaJohn = new Location("PORTAJOHN", "smells like SHIT");
    public Location chowHall = new Location("CHOWHALL", "smells like kimchi");
    public Location px = new Location("PX", "smells like manchu wok");
    public Location gazebo = new Location("GAZEBO", "smells like head and shoulders");

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
