package com.loversQuest.GUI;

import com.loversQuest.clsMinigame.CLSGame;
import com.loversQuest.gameWorldPieces.Player;
import com.loversQuest.gameWorldPieces.models_NPC.NPC_Properties;
import com.loversQuest.gymGame.ptFrame;
import com.loversQuest.shootingGame.RangeFrame;

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
        // Game response text, Inventory, Map(if location is included), Ascii art..
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
        } else {
            this.gameResponsePanel.setResponseText(response);
            this.refreshPanel();
            if (this.player.isHasKiss()) {
                this.gameResponsePanel.setResponseText(
                        "Your sweetheart says: OMG five WhiteClaws for me? I love you\n" +
                                "\nCongrats soldier you've just graduated AIT. Now go buy a Camaro." +
                                "\nYour quest for Love has ended.");
                this.inputPanel.setVisible(false);
                this.mapPanel.setVisible(false);
                this.inventoryPanel.setVisible(false);
            }
        }
        this.gameResponsePanel.addPainter();
    }

    public void openMiniGame(){
        if(this.getPlayer().getCurrentLocation().hasNPC_Property(NPC_Properties.DRILL_RANGE)) {
            this.gameResponsePanel.setResponseText("you better show me that your can shoot better than my grandma. \nstay tight for the SAFETY BRIEF");
            showSafetyBrief();
            RangeFrame miniGame = new RangeFrame(this);
            miniGame.init();
        } else if (this.getPlayer().getCurrentLocation().hasNPC_Property(NPC_Properties.DRILL_CLS)){
            //NPC tell back miniGameInit
            this.gameResponsePanel.setResponseText("Private! Time to check your CLS knowledge! Don't tell me that you still use duct tape for everything!" +
                    "\nsit down and wait for the Combat Life saver qualification exam SAFETY BRIEF");
            showSafetyBrief();
            CLSGame miniGame = new CLSGame(this);
            miniGame.init(1);
        } else if (this.getPlayer().getCurrentLocation().hasNPC_Property(NPC_Properties.DRILL_PT)){
            showSafetyBrief();
            Thread newTH = new Thread(new Runnable() {
                @Override
                public void run() {
                    ptFrame miniGame = new ptFrame(GameFrame.this);
                    miniGame.init();
                }
            });
            newTH.start();
        } else {
            this.gameResponsePanel.setResponseText("You need report to the Drill SGT first");
        }

    }

    public void refreshPanel(){
        this.inputPanel.getInputText().setText("");
        this.inventoryPanel.setInventoryText(this.player.getAllItems().toString());
        this.mapPanel.updateImageLabel(this.player.getCurrentLocation().getName());
    }

    public void showSafetyBrief(){
        String[] options = {"Start Qualification Test"};
        safetyBriefPanel = new SafetyBriefPanel();
        JOptionPane.showOptionDialog(null, safetyBriefPanel, "Safety Brief", JOptionPane.NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
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
