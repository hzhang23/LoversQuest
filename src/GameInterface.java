import com.loversQuest.*;
import com.loversQuest.IO.*;
import com.loversQuest.gameWorldPieces.RuckSack;

public class GameInterface {

    public static void main(String[] args) {
        GameWorld g1 = new GameWorld();
        Input input = new Input(g1);
        Output output = new Output(g1);
        g1.createMap();




        g1.equipPlayer();

        output.displayIntroDialog();



        while(!g1.p1.getCurrentLocation().getName().equals("GAZEBO")){

            //TODO: do we need this line / method?
//            System.out.println(output.displayPlayerStatus());

            input.userActionPrompt();
        }

    }
}
