package com.loversQuest.GUI;

import com.loversQuest.clsMinigame.CLSGame;
import com.loversQuest.excelReader.JsonGetter;
import com.loversQuest.gameWorldPieces.Player;
import com.loversQuest.gameWorldPieces.models_NPC.NPC_Properties;
import com.loversQuest.gymGame.ptGame;
import com.loversQuest.shootingGame.RangeFrame;
import com.loversQuest.soldierOfTheMonthGame.SOMClient;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class GameFrame extends JFrame{

    JFrame mainFrame;
    JPanel mainPanel;
    JFrameInput input;
    Player player;
    String command;
    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);

    //this thing makes panels
    JPanelFactory panelFactory;
    //top right panel
    InventoryPanel inventoryPanel;
    //top left panel
    GameResponsePanel gameResponsePanel;
    InputPanel inputPanel;
    MapPanel mapPanel;
    Action inputEnterAction;
    private SafetyBriefPanel safetyBriefPanel;

    public GameFrame(String gameResponse, JFrameInput input, Player player) {
        //TODO: Text input area at bottom has event listener for enter key and button press.
        // When event is triggered the panes are re-rendered with the following
        // ptGame response text, Inventory, Map(if location is included), Ascii art..
        this.input = input;
        this.player = player;

        //make some panels
        this.panelFactory = new JPanelFactory(this);
        this.gameResponsePanel = panelFactory.getGameResponsePanel();
        this.inventoryPanel = panelFactory.getInventoryPanel();
        this.inputPanel = panelFactory.getInputPanel();
        this.mapPanel = new MapPanel(this.player.getCurrentLocation().getName());

        //main panel
        this.mainPanel = new JPanel();

        //set intro dialogue TODO: refactor if have time
        this.gameResponsePanel.setResponseText(gameResponse);

        //create main frame with title
        mainFrame = new JFrame("Lovers Quest");
        //stop function on exit of main frame TODO: refactor to add leave message/ save game function
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set layout
        GridLayout mainGridLayout = new GridLayout(1, 1, 3, 3);

        //TODO: check to see if need save this function, probably not due to the enter to next function
        inputEnterAction = new GameFrame.inputEnterKeyAction();
        inputPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "inputEnterSubmit");
        inputPanel.getActionMap().put("inputEnterSubmit", inputEnterAction);
        inputPanel.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gameCommand = inputPanel.getInputText().getText();
                //calls relay command function of GameFrame class instance
                GameFrame.this.runCommand(gameCommand);
            }
        });
        mainFrame.setFocusable(true);
        //set border
        mainFrame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        gameResponsePanel.setBorder(blackBorder);
        inventoryPanel.setBorder(blackBorder);
        inputPanel.setBorder(blackBorder);
        mapPanel.setBorder(blackBorder);

        //add main panel to frame, then add other panels to main panel.
        mainFrame.getContentPane().add(mainPanel);
        mainPanel.add(gameResponsePanel);
        mainPanel.add(inventoryPanel);
        mainPanel.add(inputPanel);
        mainPanel.add(mapPanel);

        //idk what this does
        mainFrame.pack();
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitGame();
            }
        });
        this.gameResponsePanel.addPainter();
    }

    public void changeTopLeftText (String newText){
        gameResponsePanel.setResponseText(newText);
    }

    public void changeTopRightText(String inventory){
        inventoryPanel.setInventoryText(inventory);
        inputPanel.getInputText().requestFocus();
    }

    public String getCommand(){
        return this.command;
    }


    //runs all internal in this method. need to uncouple
    public void runCommand(String command) {
        String response = input.getUserAction(this.player, command);
        if (response.equals("miniGameInit")){
            openMiniGame(); // open game Frame
        } else if(response.equals("happyEnding")){
            openHappyEnding();
        } else {
            this.gameResponsePanel.setResponseText(response);
            this.refreshPanel();
        }
        this.gameResponsePanel.addPainter();
    }

    public void exitGame() {
        String[] options = {"yes", "no"};
        int flag = JOptionPane.showOptionDialog(null, "Do you want to save the game before leave?",
                "LOVE QUEST", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1] + options[0]
        );
        if (flag == 0) {
            String gameFile = JOptionPane.showInputDialog("please enter a name for your game file");
            JsonGetter.saveGame(gameFile, this.getPlayer());
        }
        if (flag == 1){
            System.exit(0);
        }
    }

    public void openMiniGame(){
        if(this.getPlayer().getCurrentLocation().hasNPC_Property(NPC_Properties.DRILL_RANGE)) {
            this.gameResponsePanel.setResponseText("you better show me that your can shoot better than my grandma. \nstay tight for the SAFETY BRIEF");
            showSafetyBrief("range");
            RangeFrame miniGame = new RangeFrame(this);
            miniGame.init();
        } else if (this.getPlayer().getCurrentLocation().hasNPC_Property(NPC_Properties.DRILL_CLS)){
            //NPC tell back miniGameInit
            this.gameResponsePanel.setResponseText("Private! Time to check your CLS knowledge! Don't tell me that you still use duct tape for everything!" +
                    "\nsit down and wait for the Combat Life saver qualification exam SAFETY BRIEF");
            showSafetyBrief("cls");
            CLSGame miniGame = new CLSGame(this);
            miniGame.init(1);
        } else if (this.getPlayer().getCurrentLocation().hasNPC_Property(NPC_Properties.DRILL_PT)){
            this.gameResponsePanel.setResponseText("It's about time you showed up! change to your PT uniform and we're about to start this PT test");
            showSafetyBrief("pt");
            ptGame miniGame = new ptGame(GameFrame.this);
            Thread newTH = new Thread(new Runnable() {
                @Override
                public void run() {
                    GameFrame.this.inputPanel.getInputText().setEditable(false);
                    miniGame.init();
                    if (!miniGame.isGameRun()){
                        GameFrame.this.inputPanel.getInputText().setEditable(true);
                    }
                }
            });
            newTH.start();
        } else if(this.getPlayer().getCurrentLocation().hasNPC_Property(NPC_Properties.DRILL_DICKS)){
            SOMClient miniGame = new SOMClient(this);
            Thread gameTh = new Thread(new Runnable() {
                @Override
                public void run() {
                    GameFrame.this.inputPanel.getInputText().setEditable(false);
                    miniGame.init();
                    if(miniGame.isGameOver()){
                        GameFrame.this.inputPanel.getInputText().setEditable(true);
                    }
                }
            });
            gameTh.start();
        } else {
            this.gameResponsePanel.setResponseText("You need report to the Drill SGT first");
        }

    }

    public void refreshPanel(){
        this.inventoryPanel.setInventoryText(this.player.getAllItems().toString());
        this.mapPanel.updateImageLabel(this.player.getCurrentLocation().getName());
        this.inputPanel.getInputText().setText("");
    }

    public void showSafetyBrief(String game){
        String[] options = {"Start Qualification Test"};
        safetyBriefPanel = new SafetyBriefPanel(game);
        JOptionPane.showOptionDialog(null, safetyBriefPanel, "Safety Brief", JOptionPane.NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
    }

    public void openHappyEnding(){
        this.gameResponsePanel.setResponseText("OMG!!! You Did get that Ring for me! I love you!");
        this.gameResponsePanel.setResponseText(this.getPlayer().displayItems());
        this.inputPanel.getInputText().setBackground(Color.pink);
        this.inputPanel.getInputText().setForeground(Color.MAGENTA);
        this.inputPanel.getInputText().setEditable(false);
        this.gameResponsePanel.getResponseText().setBackground(Color.pink);
        this.inventoryPanel.getInventoryText().setBackground(Color.pink);
        this.mapPanel.updateImageLabel("ending");
        Thread endTh = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Font font = new Font("Apple Casual", Font.PLAIN,20);
                    GameFrame.this.gameResponsePanel.getResponseText().setFont(font);
                    GameFrame.this.inputPanel.getInputText().setText("you are surround by happiness right now (*^︹^*) ❤❤");
                    GameFrame.this.gameResponsePanel.setResponseText("you are surround by happiness right now (*^︹^*) ❤❤");
                    Thread.sleep(3000);
                    useWhiteClaw();
                    Thread.sleep(3000);
                    GameFrame.this.gameResponsePanel.setResponseText("Congrats soldier! you've just graduate AIT. Now go buy a Camaro with 24% APR");
                    Thread.sleep(3000);
                    GameFrame.this.gameResponsePanel.setResponseText("Your quest for Love has ended");
                    Thread.sleep(3000);
                    String[] options = {"OK"};
                    int response = JOptionPane.showOptionDialog(null, "Thanks for playing the game!", "THE END",
                            JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (response == 0) {
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        endTh.start();

        //at last: OptionPane to thank playing game
    }
    public void useWhiteClaw(){
       String itemList = this.getPlayer().displayItems();
       itemList.replace("[", "");
       itemList.replace("]","");
       if (itemList.contains("claw")){
           String[] allwhiteClaws= input.parser.findMatchObj("claw", "use");
           StringBuilder boardResponse = new StringBuilder();

           for (int i = 0; i< allwhiteClaws.length; i++){
               if(this.getPlayer().isHasCertainItem(allwhiteClaws[i])){
               String whiteClaw = "use " + allwhiteClaws[i];
               String response = "\n" + input.getUserAction(this.player, whiteClaw) + " with your sweet heart";
               boardResponse.append(response);}
           }
           this.gameResponsePanel.setResponseText(boardResponse.toString());
       } else{
           this.gameResponsePanel.setResponseText("you wish you could have some white claws to celebrate with your sweetheart at this moment..");
       }


    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MapPanel getMapPanel() {
        return mapPanel;
    }

    public void setMapPanel(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }


    public class inputEnterKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameFrame.this.runCommand(inputPanel.getInputText().getText());
            inputPanel.cursorFocus();
        }
    }

}
