import com.loversQuest.*;
import com.loversQuest.IO.*;

public class GameInterface {

    public static void main(String[] args) {
        GameWorld g1 = new GameWorld();
        Input input = new Input(g1);
        Output output = new Output(g1);
        g1.createMap();
        Output.displayIntroDialog();


        while(!g1.p1.getCurrentLocation().getName().equals("GAZEBO")){

            System.out.println(output.displayPlayerStatus());
            System.out.println(output.locationDescription());
            input.userActionPrompt();
        }

    }
}
