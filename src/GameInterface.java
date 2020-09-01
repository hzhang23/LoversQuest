import com.loversQuest.*;
import com.loversQuest.IO.*;
import com.loversQuest.gameWorldPieces.RuckSack;
import com.loversQuest.gameWorldPieces.Container;

public class GameInterface {

    public static void main(String[] args) {
        GameWorld g1 = new GameWorld();
        Input input = new Input(g1);
        Output output = new Output(g1);
        Container box = g1.ammoBox;
        g1.createMap();




        g1.equipPlayer();
        output.displayIntroDialog();
        box.addItem(g1.whiteClaw3);
        box.addItem(g1.uncrustable);
        System.out.println(box.displayContents());
        System.out.println(box.getItem("whiteclaw"));



        while(!g1.p1.getCurrentLocation().getName().equals("GAZEBO")){
            //TODO: do we need this line / method?
//            System.out.println(output.displayPlayerStatus());

            input.userActionPrompt();
        }

    }
}
