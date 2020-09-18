package com.loversQuest.GUI;

import com.loversQuest.IO.GraphicClass;
import com.loversQuest.gameWorldPieces.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.Arrays;

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
    //bottom left panel
    InputPanel inputPanel;
    //bottom right panel
    MapPanel mapPanel;

//    Action upAction;
//    Action downAction;
//    Action leftAction;
//    Action rightAction;
    Action inputEnterAction;

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

        //set intro dialogue
        this.gameResponsePanel.setResponseText(gameResponse);

        //create main frame with title
        mainFrame = new JFrame("Lovers Quest");
        //stop function on exit of main frame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set layout
        GridLayout mainGridLayout = new GridLayout(1, 1, 3, 3);

        inputEnterAction = new GameFrame.inputEnterKeyAction();
        inputPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "inputEnterSubmit");
        inputPanel.getActionMap().put("inputEnterSubmit", inputEnterAction);
        inputPanel.getSubmitButton().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String gameCommand = inputPanel.getInputText().getText();
                //calls relay command function of GameFrame class instance
                GameFrame.this.runCommand(gameCommand);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
//        scrollPane.add(mainPanel);
        mainFrame.getContentPane().add(mainPanel);
        FlowLayout flowFromInsurance = new FlowLayout(2);


//      mainPanel.setLayout(mainGridLayout);
        mainPanel.add(gameResponsePanel);
        mainPanel.add(inventoryPanel);
        mainPanel.add(inputPanel);
        mainPanel.add(mapPanel);

        //idk what this does
        mainFrame.pack();
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setResizable(false);
        //sets window centered in screen
        mainFrame.setLocationRelativeTo(null);
        //make frame visible
        mainFrame.setVisible(true);

//        upAction = new GameFrame.UpAction();
//        downAction = new GameFrame.DownAction();
//        leftAction  = new GameFrame.LeftAction();
//        rightAction = new GameFrame.RightAction();
//
//        mainFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "upAction");
//        System.out.println(Arrays.toString(mainFrame.getRootPane().getInputMap().allKeys()));
//        mainFrame.getRootPane().getActionMap().put("upAction", upAction);
//
//        mainFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "downAction");
//        mainFrame.getRootPane().getActionMap().put("downAction", downAction);
//
//        mainFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
//        mainFrame.getRootPane().getActionMap().put("rightAction", rightAction);
//
//        mainFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
//        mainFrame.getRootPane().getActionMap().put("leftAction", leftAction);
    }

    public void hideFrame(){
        setVisible(false);
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
        this.gameResponsePanel.setResponseText(response);
        this.inputPanel.getInputText().setText("");
        this.inventoryPanel.setInventoryText(this.player.getAllItems().toString());
        this.mapPanel.updateImageLabel(this.player.getCurrentLocation().getName());
        if(this.player.isHasKiss()){
            this.gameResponsePanel.setResponseText(
                    "Your sweetheart says: OMG five WhiteClaws for me? I love you\n" +
                    "\nCongrats soldier you've just graduated AIT. Now go buy a Camaro."+
                    "\nYour quest for Love has ended.");
            this.inputPanel.setVisible(false);
            this.mapPanel.setVisible(false);
            this.inventoryPanel.setVisible(false);
        }

    }

    // need for key binding
    public class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameFrame.this.runCommand("go north");
        }
    }

    public class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameFrame.this.runCommand("go south");
            System.out.println("working down");
        }
    }

    public class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameFrame.this.runCommand("go east");
            System.out.println("working right");
        }
    }


    public class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameFrame.this.runCommand("go west");
            System.out.println("working left");
        }
    }

    public class inputEnterKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameFrame.this.runCommand(inputPanel.getInputText().getText());
            inputPanel.cursorFocus();
        }
    }

}
