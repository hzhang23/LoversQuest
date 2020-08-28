package com.loversQuest.IO;

import com.loversQuest.GameWorld;
import com.loversQuest.gameWorld.Location;
import com.loversQuest.gameWorld.Player;

import java.util.Scanner;

public class Output {
    GameWorld game;
    Player player;
    Scanner userInput = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";


    public Output(GameWorld game) {
        this.game = game;
        this.player = game.p1;
    }


    public static void displayIntroDialog() {
        System.out.println("WELCOME TO " + ANSI_RED + "LOVERSQUEST \n" + ANSI_RESET);
        System.out.println("You have almost completed AIT at Fort Sam Houston. You graduate tomorrow but you still " +
                "have tasks to finish. \nYour mission is to gather 5 white claws and complete 3/4 warrior tasks." +
                "Beware of zombies, diseases, and drill sergeants. \nTry to complete all your basic warrior skills " +
                "while acquiring as many white claws as possible before graduation.... \n");
        System.out.println("You open your eyes, and find yourself in the barracks staring up at the crooked ceiling tiles above. It’s the day before AIT graduation.\n" +
                "You must complete all the warrior tasks while collecting as many WCs as possible to meet up with your AIT bf/gf for a few adult beverages\n" +
                "AND cuddles before you are both sent off to your duty stations.\n");
    }

    public String displayPlayerStatus(){
        String status = "You are currently in the " + player.getCurrentLocation().getName();
        return status;
    }
    public String locationDescription(){
        Location currentLocation = player.getCurrentLocation();

        String description = "The " + currentLocation.getName() + " "+ currentLocation.getDescription() +
                "\nTo the North is " + currentLocation.getNorth().getName() +
                "\nTo the East is " + currentLocation.getEast().getName() +
                "\nTo the South is " + currentLocation.getSouth().getName() +
                "\nTo the West is " + currentLocation.getWest().getName();
        return description;
    }


}
