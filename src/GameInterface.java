import com.loversQuest.*;
import com.loversQuest.GUI.GameFrame;
import com.loversQuest.GUI.JFrameInput;
import com.loversQuest.IO.*;

import java.io.IOException;


public class GameInterface {

    //testing//
    // have text file as argument and pass it in

    public static void main(String[] args) {

        //GameWorld g1 = new GameWorld();
        GameInit g1 = new GameInit();

        Output output = new Output();
        //GraphicClass asciiPrinter = new GraphicClass();

        JFrameInput jFrameInput = new JFrameInput();
        GameFrame gameFrame = new GameFrame(output.displayIntroDialog(), jFrameInput, g1.p1);
        gameFrame.changeTopRightText("This is your rucksack.\nIn it you will find all the items you are currently carrying and can use.\n" +
                "Below is the command window. Enter any of the commands listed. You may also maneuver using the arrow keys.");
    }
}