package com.loversQuest.IO;

import com.loversQuest.GameWorld;
import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.Player;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Output {

    GameWorld game;
    Player player;
    Scanner userInput = new Scanner(System.in);
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public Output(GameWorld game) {
        this.game = game;
        this.player = game.p1;
    }

    // make string send string to jframe, start jframe
    public StringBuilder showMap(){
        StringBuilder jframeString = new StringBuilder();
        try{
            //read in csv file
//            DataInputStream in = new DataInputStream(getClass().getResourceAsStream("inputWords.txt"));
            DataInputStream in = new DataInputStream(getClass().getResourceAsStream("Utilities/map.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            //continue to read in file while lines exist
            while ((strLine = br.readLine()) != null){
                jframeString.append(strLine).append("\n");

            }

            in.close();
        }catch (Exception e){
            System.err.println("error: " + e.getMessage());
        }
        return(jframeString);
    }


    public String displayIntroDialog() {
        System.out.println("WELCOME TO " + ANSI_RED + "LOVERSQUEST \n" + ANSI_RESET);
        System.out.println("You have almost completed AIT at Fort Sam Houston. You graduate tomorrow but you still " +
                "have tasks to finish. \nYour mission is to gather 5 white claws and complete 3 warrior tasks. " +
                "Beware of fellow students, diseases, and drill sergeants. \nTry to complete all your basic warrior skills " +
                "while acquiring as many white claws as possible before graduation.... \n");
        System.out.println("You open your eyes, and find yourself in the barracks staring up at the crooked ceiling tiles above. It’s the day before AIT graduation.\n" +
                "You must complete all the warrior tasks while collecting as many WCs as possible to meet up with your " + ANSI_RED + "AIT bf/gf" + ANSI_RESET + " for a few adult beverages\n" +
                "and " + ANSI_RED + "cuddles" + ANSI_RESET+ " before you are both sent off to your duty stations." );
        return "This is the intro dialog";
    }

//    public String initialStatus(){
//        String status = "You've"
//    }

    //TODO: is this necessary as it is currently implemented?
    public String displayGoResponse(String direction){
        String status = "You head to the " +direction+ " and find yourself in the " + BLUE + player.getCurrentLocation().getName() + ANSI_RESET;
        return status;
    }

    public String promptForAction(){
        return ("\nWhat would you like to do? " + ANSI_PURPLE +  "[ go, look, interact, inventory, get <item> ]" + ANSI_RESET);
    }

    public String locationDescription(){
        Location currentLocation = player.getCurrentLocation();

        String description = "The " + currentLocation.getName() + ": "+ currentLocation.getDescription() +
                "\nTo the North is " + currentLocation.getNorth().getName() +
                "\nTo the East is " + currentLocation.getEast().getName() +
                "\nTo the South is " + currentLocation.getSouth().getName() +
                "\nTo the West is " + currentLocation.getWest().getName();
        return description;
    }
}
