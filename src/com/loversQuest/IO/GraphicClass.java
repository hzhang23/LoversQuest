package com.loversQuest.IO;

import com.loversQuest.gameWorldPieces.Player;

import java.io.*;
import java.util.Map;

import static java.util.Map.entry;

public class GraphicClass {
    public static final String BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    private Map<String, String> locationsGraphicsMap = Map.ofEntries(
            entry("laundryroom","laundryRoom.txt"),
            entry("barracks","home.txt"),
            entry("gym","gym.txt"),
            entry("courtyard", "courtYard.txt"),
            entry("range", "range.txt"),
            entry("portajohn", "portaJohn.txt"),
            entry("chowhall", "chowHall.txt"),
            entry("px", "px.txt"),
            entry("gazebo", "gazebo.txt")
    );


    //    Business Method
    public String printLocation(String filename) throws IOException {
        StringBuilder result = new StringBuilder();
        String fileLocation = "images/" + filename;
        DataInputStream in = new DataInputStream(getClass().getResourceAsStream(fileLocation));
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null) {
            //process the line
            result.append(line + "\n");
        }
        return result.toString();
    }


    public String printCurrentAscii(Player player) throws IOException {

        String location = player.getCurrentLocation().getName().toLowerCase();
        String fileName = locationsGraphicsMap.get(location);
        return this.printLocation(fileName);

//        player.getCurrentLocation().getName().toLowerCase().equals("gazebo");
//
//        switch (player.getCurrentLocation().getName().toLowerCase()) {
//            case "laundryroom" -> this.printLocation("laundryRoom.txt");
//
//            case "barracks"-> this.printLocation("home.txt");
//
//            case "gym" -> this.printLocation("gym.txt");
//            case "courtyard" -> this.printLocation("courtYard.txt");
//            case "range" -> this.printLocation("range.txt");
//            case "portajohn" -> this.printLocation("portaJohn.txt");
//            case "chowhall" -> this.printLocation("chowHall.txt");
//            case "px" -> this.printLocation("px.txt");
//            default -> this.printLocation("gazebo.txt");
//        }

    }


}




