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
//    Action upAction = new UpAction();

    JFrame mainFrame;
    //////////////////////////////////////////////DANNY HERE IS YOUR PANEL //////////////////////////////////////////
    JPanel mainPanel;
    //////////////////////////////////////////////DANNY HERE IS YOUR PANEL //////////////////////////////////////////
    JFrameInput input;
    Player player;

    String command;

    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);

    //not in use at the moment
    JTextArea locationArt = new JTextArea();
    GraphicClass asciiPrinter;

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

    // creating action instance variables for arrow input
    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;


    public GameFrame(String gameResponse, JFrameInput input, Player player, GraphicClass asciiPrinter) throws IOException {
        //TODO: Text input area at bottom has event listener for enter key and button press.
        // When event is triggered the panes are re-rendered with the following
        // Game response text, Inventory, Map(if location is included), Ascii art..
        this.input = input;
        this.player = player;

        //not in use at the moment
        this.asciiPrinter = asciiPrinter;

        //make some panels
        this.panelFactory = new JPanelFactory(this);
        this.gameResponsePanel = panelFactory.getGameResponsePanel();
        this.inventoryPanel = panelFactory.getInventoryPanel();
        this.inputPanel = panelFactory.getInputPanel();
        this.mapPanel = panelFactory.getMapPanel();

        //main panel
        this.mainPanel = new JPanel();

        //set intro dialogue
        this.gameResponsePanel.setResponseText(gameResponse);

        //create main frame with title
        mainFrame = new JFrame("Lovers Quest");
        //stop function on exit of main frame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set layout

        GridLayout mainGridLayout = new GridLayout(2, 2, 3, 3);


        //comment out for main panel to have main layout
//        ///apply layout to content of frame
//        mainFrame.getContentPane().setLayout(mainGridLayout);



        // what does this label do? interfering with current layout
//        JLabel testingArrowsKeys = new JLabel();
//        inputPanel.add(testingArrowsKeys);

        //set event listeners for input panel (bottom left)
        inputPanel.getInputText().addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                        GameFrame.this.runCommand(inputPanel.getInputText().getText());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}

        });

        inputPanel.getSubmitButton().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                String gameCommand = inputPanel.getInputText().getText();
                //calls relay command function of GameFrame class instance
                try {
                    GameFrame.this.runCommand(gameCommand);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
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
        mainFrame.getContentPane().add(mainPanel);
        mainPanel.setLayout(mainGridLayout);
        mainPanel.add(gameResponsePanel);
        mainPanel.add(inventoryPanel);
        mainPanel.add(inputPanel);
        mainPanel.add(mapPanel);


//        // add all panels to main pane to the main game frame
//        mainFrame.getContentPane().add(gameResponsePanel);
//        mainFrame.getContentPane().add(inventoryPanel);
//        mainFrame.getContentPane().add(inputPanel);
//        mainFrame.getContentPane().add(mapPanel);


        //idk what this does
        mainFrame.pack();
        //make frame visible
        mainFrame.setVisible(true);

        upAction = new GameFrame.UpAction();
        downAction = new GameFrame.DownAction();
        leftAction  = new GameFrame.LeftAction();
        rightAction = new GameFrame.RightAction();

        mainFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "upAction");
        System.out.println(Arrays.toString(mainFrame.getRootPane().getInputMap().allKeys()));
        mainFrame.getRootPane().getActionMap().put("upAction", upAction);

        mainFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        mainFrame.getRootPane().getActionMap().put("downAction", downAction);

        mainFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        mainFrame.getRootPane().getActionMap().put("rightAction", rightAction);

        mainFrame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        mainFrame.getRootPane().getActionMap().put("leftAction", leftAction);
    }

    public void changeTopLeftText (String newText){
        gameResponsePanel.setResponseText(newText);
    }

    public void changeTopRightText(String inventory){

        inventoryPanel.setInventoryText(inventory);

    }

    public String getCommand(){
        return this.command;
    }


    //runs all internal in this method. need to uncouple
    public void runCommand(String command) throws IOException {

        String response = input.getUserAction(this.player, command);
        this.gameResponsePanel.setResponseText(response);
        this.inputPanel.getInputText().setText(null);
        this.inventoryPanel.setInventoryText(this.player.getAllItems().toString());

        if(this.player.isHasKiss()){
            System.out.println("Game end");
        }

    }

    // need for key binding
    public class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                GameFrame.this.runCommand("go north");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                GameFrame.this.runCommand("go south");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("working down");
        }
    }

    public class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                GameFrame.this.runCommand("go east");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("working right");
        }
    }

    public class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                GameFrame.this.runCommand("go west");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println("working left");
        }
    }



}
