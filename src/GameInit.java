import com.loversQuest.excelReader.ReadExcel;
import com.loversQuest.gameWorldPieces.*;

import java.util.List;

public class GameInit {
    public static String filePath = "resources/gameBook.xlsx";
    public static List<Location> locationList = ReadExcel.getLocationList(filePath);
    public static List<Item> itemList = ReadExcel.getItemList(filePath);
    public static List<Container> containersList = ReadExcel.getContainerList(filePath);
    //public static List<NonPlayerCharacters> npcList = ReadExcel.getNpcList(filePath,locationList);

    //TODO: change locationList to a HashMap to extract value better
    public Player p1 = new Player("Bob", locationList.get(1));


    public boolean isGameOver(){
        boolean gameOver = false;
        if(this.p1.isHasKiss()){
            gameOver = true;
        }
        return gameOver;
    }

    public static void main(String[] args) {
        Player p1 = new Player("Bob", locationList.get(1));
        System.out.println(p1.getCurrentLocation().getName());
        p1.go("north");
        System.out.println(p1.getCurrentLocation().getName());
        p1.go("south");
        System.out.println(p1.getCurrentLocation().getName());
    }





}
