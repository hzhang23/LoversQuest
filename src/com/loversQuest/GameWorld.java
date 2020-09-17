package com.loversQuest;


import com.loversQuest.gameWorldPieces.*;

public class GameWorld {
//    public Location nothing = new Location("NOTHING", "THIS IS NOTHING");
//    public Location barracks = new Location("BARRACKS", "It smells of gym socks and peanut butter.");
//
//    public Location gym = new Location("GYM", "You watch a soldier conduct the “BEND AND REACH” in the " +
//            "squat rack while grunts and clanking of weights \n" +
//            "can be heard in the far back corner. You see your battle buddies taking an APFT (ARMY PHYSICAL FITNESS TEST) in the basketball courts.");
//
//    public Location laundryRoom = new Location("LAUNDRYROOM",
//            "Oxyclean and bleach are the scents noticed in this area. Stuffed in the corner is a copious \n" +
//                    "amount of green laundry bags");
//
//    public Location courtYard = new Location("COURTYARD", "A vast field littered with cigarettes butts, empty monster cans, and fellow soldiers. \n" +
//            "Your unit is conducting some sort of exam. Upon closer look, there’s a COMBAT LIFE SAVER WARRIOR SKILL LEVEL 1 EXAM taking place.");
//
//    public Location range = new Location("RANGE", "hear the sounds of rifles and the cries of soldiers as they are getting smoked.\n");
//
//    public Location portaJohn = new Location("PORTAJOHN", "It smells of elephant flatulence and rotting garbage.");
//
//    public Location chowHall = new Location("CHOWHALL", "Your stomach grumbles as you pass by the variety of fried foods in the red categorized section. \n" +
//            "You're tempted to pocket some tater tots.");
//
//    public Location px = new Location("PX", "see a Barber Shop, Eyebrow Threading station, and a GNC.\n" +
//            "You look far to the WEST and see a silhouette of a full-bodied individual.\n");
//
//    public Location gazebo = new Location("GAZEBO", "at first glance, you don’t see anything through the misty night \n" +
//            ".  \n" +
//            "They ask, “How many white claws did you bring me?”\n");
//
//    public Player p1 = new Player("Bob", barracks);
//
//    public Player getP1() {
//        return p1;
//    }
//
//    public void setP1(Player p1) {
//        this.p1 = p1;
//    }
//
//    //create items
//    public Item rifle = new Item("M16", "You shoot your rifle in the air in celebration");
//    public Item uncrustable = new Item("uncrustable", "You look lovingly at the peanut butter and jelly sandwich");
//    public Item camelback = new Item("CamelBack", "You take a refreshing drink of moldy water.");
//    public Item ptBelt = new Item("Pt Belt", "You put it on and are now super safe and visible.");
//
//    public Item whiteClaw1 = new Item("Natural Lime WhiteClaw", "You take a refreshing drink of Natural Lime");
//    public Item whiteClaw2 = new Item("Black Cherry WhiteClaw", "You take a refreshing drink of Black Cherry.");
//    public Item whiteClaw3 = new Item("Ruby Grapefruit WhiteClaw", "You take a refreshing drink of Ruby Grapefruit");
//    public Item whiteClaw4 = new Item("Mango WhiteClaw", "You take a refreshing drink of Mango");
//    public Item whiteClaw5 = new Item("Watermelon WhiteClaw", "You take a refreshing drink of Watermelon");
//    public Item sickCallSlip = new Item("Sick call slip", "You enjoy your soft shoe profile");
//
//    public Item expertBadge = new Item("Expert Marksmanship Badge", "You can make things more deader better");
//    public Item medicalBadge = new Item("Combat Life Saver Badge", "You can make things less deader better");
//    public Item ptBadge = new Item("Physical Training Badge", "You showed up for the pt test");
//
//
//    public Item challengeCoin = new Item("AIT Challenge Coin", "It says 'Play the Game'");
//    public Item kiss = new Item("A loving Kiss", "You're head is foggy from romance, or is it the WhiteClaws?");
//
//
//
//
//    //Instantiate NPCs
//    public NonPlayerCharacters sickCallRanger = new NonPlayerCharacters("The Sick Call Ranger"," are hiding behind the last dryer " +
//            "with the remnants of an " + uncrustable.getName() + " around their mouth.", laundryRoom);
//    public NonPlayerCharacters chowHallLady = new NonPlayerCharacters("The Chow Hall lady", " are speaking to you in your native tongue.", chowHall);
//
//    public NonPlayerCharacters clsInstructor = new NonPlayerCharacters("CLS Instructor", " are watching your every move. You see something reflecting in trashcan.", courtYard);
//    public NonPlayerCharacters rangeDrillSergeant = new NonPlayerCharacters("Drill Sergeant Gustav", " are pounding a monster under the range tower.", range);
//
//    public NonPlayerCharacters blueFalcon = new NonPlayerCharacters("The Blue Falcon", " are sleeping next to a bottomless pit of despair.", portaJohn);
//    public NonPlayerCharacters gymDrill = new NonPlayerCharacters("Drill Sergeant Winstrol"," are staring at you with their beady eyes. ", gym);
//
//    public Lover_Old lover = new Lover_Old("Your Sweetheart", " stare at you lovingly", gazebo);
//    public Officer officer = new Officer("Captain Charlie", " look at you over their sandwhich.", px);
//
//
//    public Container ammoBox = new Container("Ammo Box","Full of brass and whiteclaws" );
//    public Container trashCan = new Container("Trash Can", "Just your hopes and dreams");
//    public Container ifak = new Container("IFAK", "You feel very healthy after using the individual first aid kit");
//    public Container ceiling = new Container("Ceiling Tile", "It's dusty up here");
//
//    // sets N, S, E, W directions of rooms in relation to one another, add characters and items
//    public void createMap(){
//
//
//        barracks.setEast("gym");
//        barracks.setNorth("courtYard");
//        barracks.setSouth("nothing");
//        barracks.setWest("laundryRoom");
//        barracks.setContainer(ceiling);
//        ceiling.addItem(whiteClaw1);
//
//        laundryRoom.setWest("nothing");
//        laundryRoom.setNorth("nothing");
//        laundryRoom.setSouth("nothing");
//        laundryRoom.setEast("barracks");
//        laundryRoom.setOccupant(sickCallRanger);
//        sickCallRanger.setKeyItem(uncrustable);
//        sickCallRanger.setPrize(sickCallSlip);
//
//        courtYard.setSouth("barracks");
//        courtYard.setNorth("range");
//        courtYard.setWest("nothing");
//        courtYard.setEast("nothing");
//        courtYard.setContainer(trashCan);
//        courtYard.setOccupant(clsInstructor);
//        trashCan.addItem(ptBelt);
//
//        range.setSouth("courtYard");
//        range.setNorth("nothing");
//        range.setWest("nothing");
//        range.setEast("nothing");
//        range.setOccupant(rangeDrillSergeant);
//        ammoBox.addItem(whiteClaw2);
//        range.setContainer(ammoBox);
//        rangeDrillSergeant.setKeyItem(rifle);
//        rangeDrillSergeant.setPrize(expertBadge);
//
//        gym.setWest("barracks");
//        gym.setNorth("portaJohn");
//        gym.setSouth("chowHall");
//        gym.setEast("nothing");
//        gym.setOccupant(gymDrill);
//        gymDrill.setKeyItem(ptBelt);
//        gymDrill.setPrize(ptBadge   );
//
//        portaJohn.setSouth("gym");
//        portaJohn.setWest("nothing");
//        portaJohn.setNorth("nothing");
//        portaJohn.setEast("nothing");
//        portaJohn.setOccupant(blueFalcon);
//        blueFalcon.setKeyItem(whiteClaw2);
//        portaJohn.addItem(whiteClaw2);
//        blueFalcon.setPrize(whiteClaw4);
//
//        chowHall.setNorth("gym");
//        chowHall.setEast("nothing");
//        chowHall.setWest("nothing");
//        chowHall.setSouth("px");
//        chowHall.setOccupant(chowHallLady);
//        chowHall.addItem(whiteClaw3);
//
//        px.setNorth("chowHall");
//        px.setEast("nothing");
//        px.setWest("gazebo");
//        px.setSouth("nothing");
//
//        px.setOccupant(officer);
//        officer.setKeyItemName("badge");
//        officer.setNumOfItemsNeeded(3);
//        officer.setSendPlayerDestination(chowHall);
//        officer.setPrize(challengeCoin);
//        px.setContainer(ifak);
//        ifak.addItem(whiteClaw4);
//
//
//        gazebo.setEast("px");
//        gazebo.setNorth("nothing");
//        gazebo.setWest("nothing");
//        gazebo.setSouth("nothing");
//        gazebo.setOccupant(lover);
//        lover.setPrize(kiss);
//        lover.setKeyItemName("whiteclaw");
//        lover.setNumOfItemsNeeded(5);
//
//    }
//
//    // give player starting items
//    public void equipPlayer() {
//        p1.addItem(rifle);
//        p1.addItem(uncrustable);
//        p1.addItem(camelback);
//    }
//
//    public boolean isGameOver(){
//        boolean gameOver = false;
//        if(this.p1.isHasKiss()){
//            gameOver = true;
//        }
//        return gameOver;
//    }
}
