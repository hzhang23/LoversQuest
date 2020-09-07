import com.loversQuest.*;
import com.loversQuest.GUI.GameFrame;
import com.loversQuest.IO.*;
import com.loversQuest.gameWorldPieces.*;

import java.io.IOException;


public class GameInterface {


    //testing//
    // have text file as argument and pass it in
    public static void main(String[] args) throws IOException {

        GameWorld g1 = new GameWorld();
        Input input = new Input();
        Output output = new Output();
        GraphicClass asciiPrinter = new GraphicClass();
        GameFrame gameFrame = new GameFrame(input, output);
        g1.createMap();
        g1.equipPlayer();


        //testing setup
        g1.p1.setCurrentLocation(g1.px);
        g1.p1.addItem(g1.whiteClaw1);
        g1.p1.addItem(g1.whiteClaw2);
        g1.p1.addItem(g1.whiteClaw3);
        g1.p1.addItem(g1.whiteClaw4);
        g1.p1.addItem(g1.whiteClaw5);
//        g1.p1.addItem(g1.challengeCoin);
//        g1.p1.addItem(g1.ptBadge);
        g1.p1.addItem(g1.medicalBadge);
        g1.p1.addItem(g1.expertBadge);
        //end test setup


        output.displayIntroDialog();
        System.out.println(output.promptForAction());

        String gameResponse = null;
        while (g1.p1.getItem(g1.kiss.getName()) == null) {


            gameResponse = (input.getUserAction(g1.p1));
            System.out.println(output.promptForAction());
            for (int i = 0; i < 35; i++) {
                System.out.println();
            }

            System.out.println("Current Location: " + g1.p1.getCurrentLocation().getColoredName());
            asciiPrinter.printCurrentAscii(g1.p1);

            System.out.println();
            System.out.println(gameResponse);
            System.out.println();
            System.out.println("Rucksack Contents:");
            System.out.println(g1.p1.getAllItems());
            System.out.println(output.promptForAction());
        }
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        System.out.println(gameResponse);
        System.out.println("Congrats soldier you've just graduated. Now go buy a Camaro.");

    }
}
