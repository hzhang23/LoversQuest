import com.loversQuest.*;
import com.loversQuest.IO.*;
import com.loversQuest.gameWorldPieces.RuckSack;

public class GameInterface {

    public static void main(String[] args) {
        GameWorld g1 = new GameWorld();
        Input input = new Input(g1);
        Output output = new Output(g1);
        g1.createMap();
//        output.displayIntroDialog();

        // testing items/ruckSack class
//        g1.p1.get("whiteclaw");
//        g1.p1.get("tourniquet");
//        g1.p1.get("pt belt");
//        g1.p1.displayItems();



        g1.equipPlayer();
        g1.p1.displayItems();
        System.out.println(g1.barracks.getItemsList());



        while(!g1.p1.getCurrentLocation().getName().equals("GAZEBO")){

            //TODO: do we need this line / method?
//            System.out.println(output.displayPlayerStatus());

            System.out.println("\n" + output.locationDescription());
            input.userActionPrompt();
        }

    }
}
