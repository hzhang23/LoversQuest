package com.loversQuest;

import com.loversQuest.IO.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import java.io.*;
import java.util.Scanner;



public class GameInterfaceTest {
    GameWorld g1;
    InputTest input;
    Output output;
    GraphicClass asciiPrinter;

    @Before
    public void setup(){
        g1 = new GameWorld();
        input = new InputTest();
        output = new Output();
        asciiPrinter = new GraphicClass();
        g1.createMap();
        g1.equipPlayer();


    }

    // is it okay to have mutliple assert methods?
    // how do i go about implementing automated tests for a whole text file
    @Test
    public void moveFromBarracksToGym() throws IOException {
        input.getUserAction(g1.p1);
        String actual = g1.p1.getCurrentLocation().getName();
        String expected = "GYM";
        assertEquals(actual, expected);

        //this fails
        input.getUserAction(g1.p1);
        actual = g1.p1.getCurrentLocation().getName();
        expected = "BARR";
        assertEquals(actual, expected);



    }



//    public static void main(String[] args) throws IOException {
//
//        GameWorld g1 = new GameWorld();
//        Input input = new Input();
//        Output output = new Output();
//        GraphicClass asciiPrinter = new GraphicClass();
//        //GameFrame gameFrame = new GameFrame(input, output);
//        g1.createMap();
//        g1.equipPlayer();
//
//
//        //testing setup
//        g1.p1.setCurrentLocation(g1.px);
//        g1.p1.addItem(g1.whiteClaw1);
//        g1.p1.addItem(g1.whiteClaw2);
//        g1.p1.addItem(g1.whiteClaw3);
//        g1.p1.addItem(g1.whiteClaw4);
//        g1.p1.addItem(g1.whiteClaw5);
//        g1.p1.addItem(g1.challengeCoin);
//        g1.p1.addItem(g1.ptBadge);
//        g1.p1.addItem(g1.medicalBadge);
//        g1.p1.addItem(g1.expertBadge);
//        //end test setup
//
//
//        try{
//
////            File inputTest = new File("C:\\Users\\jai51\\Documents\\TLG\\PracticalApplications\\LoversQuest\\LoversQuest\\test\\inputTest.txt");
//            InputStream inputStream = GameInterfaceTest.class.getResourceAsStream("com/loversQuest/inputTest.txt");
//            Scanner testScanner = new Scanner(inputStream);
//
//
//            while (testScanner.hasNextLine()) {
//                String line = testScanner.nextLine();
//                System.out.println(line);
//            }
//        } catch(Exception e){
//            e.printStackTrace();
//        }
//
//
//        String gameResponse = null;
//        while (g1.p1.getItem(g1.kiss.getName()) == null) {
//
//
//
//            gameResponse = (input.getUserAction(g1.p1));
//            System.out.println(output.promptForAction());
//            for (int i = 0; i < 35; i++) {
//                System.out.println();
//            }
//
//            System.out.println("Current Location: " + g1.p1.getCurrentLocation().getName());
//            asciiPrinter.printCurrentAscii(g1.p1);
//            System.out.println();
//            System.out.println(gameResponse);
//            System.out.println();
//            System.out.println("Rucksack Contents:");
//            System.out.println(g1.p1.getAllItems());
//            System.out.println(output.promptForAction());
//
//        }
//        for (int i = 0; i < 30; i++) {
//            System.out.println();
//        }
//        System.out.println(gameResponse);
//        System.out.println("Congrats soldier you've just graduated. Now go buy a Camaro.");
//
//    }
}
