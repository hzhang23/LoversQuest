import com.loversQuest.*;
import com.loversQuest.IO.Output;
import com.loversQuest.gameWorld.Player;

public class GameInterface {

    public static void main(String[] args) {
        Game g1 = new Game();
        g1.createMap();

        Output.displayIntroDialog();
        System.out.println(g1.p1.getCurrentLocation());
        g1.p1.go("east");
        System.out.println(g1.p1.getCurrentLocation());
    }
}
