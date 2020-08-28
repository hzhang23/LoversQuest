import com.loversQuest.*;
import com.loversQuest.IO.*;

public class GameInterface {

    public static void main(String[] args) {
        GameWorld g1 = new GameWorld();
        Input input = new Input(g1);
        g1.createMap();
        Output.displayIntroDialog();
        System.out.println(g1.px);;

        while(!g1.p1.getCurrentLocation().getName().equals("GAZEBO")){
            System.out.println(g1.p1.getCurrentLocation());
            input.userActionPrompt();
        }

    }
}
