package com.loversQuest.gameWorldPieces.models_NPC;


import com.loversQuest.gameWorldPieces.Location;
import com.loversQuest.gameWorldPieces.NonPlayerCharacters;
import com.loversQuest.gameWorldPieces.Player;


public class DrillSGT_CLS extends NonPlayerCharacters {


    public DrillSGT_CLS(String name, String description, Location location,
        NPC_Properties properties) {
        super(name, description, location, properties);
    }
}

//    @Override
//    public String interact(Player player) {
//////        Scanner sc = new Scanner(System.in);
////        String returnMsg = null;
////        if(player.isHasCertainItem(clsBadge)){
////            returnMsg = "Good work, Private! What a shiny badge!";
////        }else {
////            returnMsg = "Private! Time to check your CLS knowledge! Don't tell me that you still use duct tape for everything!";
////
////        }
////        return returnMsg;
////    }
//    }
//}
