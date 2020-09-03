import com.loversQuest.*;
import com.loversQuest.IO.*;
import com.loversQuest.gameWorldPieces.*;

import java.io.IOException;


public class GameInterface {

    public static void main(String[] args) throws IOException {

        GameWorld g1 = new GameWorld();
        Input input = new Input();
        Output output = new Output(g1);
        //GameFrame gameFrame = new GameFrame(input, output);
        g1.createMap();

        output.displayIntroDialog();
        System.out.println(output.promptForAction());

        String gameResponse = null;
        while (!g1.p1.getCurrentLocation().getName().equals("GAZEBO")) {
            //TODO: do we need this line / method?
//            System.out.println(output.displayPlayerStatus());


            gameResponse = (input.getUserAction(g1.p1));
            System.out.println(output.promptForAction());
            for (int i = 0; i < 30; i++) {
                System.out.println();
            }
            System.out.println("You find yourself in the:");
            System.out.println(g1.p1.getCurrentLocation().getName());
            System.out.println();
            System.out.println("You have the following in your rucksack:");
            System.out.println(g1.p1.getAllItems());
            System.out.println();
            System.out.println(gameResponse);
            System.out.println(output.promptForAction());

        }

    }
}
