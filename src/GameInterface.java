import com.loversQuest.*;
import com.loversQuest.GUI.GameFrame;
import com.loversQuest.GUI.InputPanel;
import com.loversQuest.GUI.JFrameInput;
import com.loversQuest.IO.*;
import com.loversQuest.gameWorldPieces.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;


public class GameInterface {

    //testing//
    // have text file as argument and pass it in

    public static void main(String[] args) throws IOException {

        //GameWorld g1 = new GameWorld();
        GameInit g1 = new GameInit();

        Output output = new Output();
        GraphicClass asciiPrinter = new GraphicClass();

        // testing
//        Game game = new Game();
        //testing setup
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
        //end test setup


        JFrameInput jFrameInput = new JFrameInput();
        GameFrame gameFrame = new GameFrame(output.displayIntroDialog(), jFrameInput, g1.p1, asciiPrinter);
        gameFrame.changeTopRightText("This is your rucksack.\nIn it you will find all the items you are currently carrying and can use.\n" +
                "Below is the command window. Enter any of the commands listed. You may also maneuver using the arrow keys.");
    }
}