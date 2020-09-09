import com.loversQuest.*;
import com.loversQuest.GUI.GameFrame;
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

    public static boolean isGameOver(GameWorld game){
        boolean gameOver = false;
        if(game.getP1().getItem(game.kiss.getName()) != null){
            gameOver = true;
        }
        return gameOver;
    }
    public static void main(String[] args) throws IOException {

        GameWorld g1 = new GameWorld();
        Input input = new Input();
        Output output = new Output();
        GraphicClass asciiPrinter = new GraphicClass();

        // testing
//        Game game = new Game();

        g1.createMap();
        g1.equipPlayer();

        //testing setup
        g1.p1.setCurrentLocation(g1.px);
        g1.p1.addItem(g1.whiteClaw1);
        g1.p1.addItem(g1.whiteClaw2);
        g1.p1.addItem(g1.whiteClaw3);
        g1.p1.addItem(g1.whiteClaw4);
        g1.p1.addItem(g1.whiteClaw5);
        g1.p1.addItem(g1.challengeCoin);
        g1.p1.addItem(g1.ptBadge);
        g1.p1.addItem(g1.medicalBadge);
        g1.p1.addItem(g1.expertBadge);
        //end test setup


        String gameResponse = null;

        JFrameInput jFrameInput = new JFrameInput();

        GameFrame gameFrame = new GameFrame(output.displayIntroDialog(), jFrameInput, g1.p1, asciiPrinter);

        gameFrame.changeTopRightText(g1.p1.getAllItems().toString());


        System.out.println("Game over");

        gameFrame.changeTopLeftText(gameResponse + "\n" +
        "Congrats soldier you've just graduated. Now go buy a Camaro.");

    }
}
