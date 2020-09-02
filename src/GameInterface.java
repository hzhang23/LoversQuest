import com.loversQuest.*;
import com.loversQuest.IO.*;


public class GameInterface {

    public static void main(String[] args) {
        GameWorld g1 = new GameWorld();
        Input input = new Input();
        Output output = new Output(g1);

        g1.createMap();
        g1.equipPlayer();


        output.displayIntroDialog();

        while(!g1.p1.getCurrentLocation().getName().equals("GAZEBO")){
            //TODO: do we need this line / method?
//            System.out.println(output.displayPlayerStatus());

            input.userActionPrompt(g1.p1);
        }

    }
}
