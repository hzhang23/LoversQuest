package com.loversQuest;


import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Input {

    Scanner userInput = new Scanner(System.in);

    public void userActionPrompt() {

        System.out.println("What would you like to do? [ 'go', 'look' ]");

        String responseInput = userInput.nextLine();

        String response = responseInput.toLowerCase();

        if (response.equals("go")) {
            System.out.println("im tired and want to see the sun");
        } else if (response.equals("look")) {
            System.out.println("do something with LOOK");
        }
    }

}
