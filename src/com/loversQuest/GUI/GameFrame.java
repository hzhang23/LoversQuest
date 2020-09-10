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
    //legend panel
    ColoredLegendMap legendMapPanel;

    // creating action instance variables for arrow input
    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;
    Action inputEnterAction;

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
        this.legendMapPanel = panelFactory.getLegendPanel();

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
//        inputPanel.getInputText().addKeyListener(new KeyListener() {
//
//            @Override
//            public void keyTyped(KeyEvent e) {
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode()==KeyEvent.VK_ENTER){
//                    try {
//                        GameFrame.this.runCommand(inputPanel.getInputText().getText());
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {}
//
//        });

        inputEnterAction = new GameFrame.inputEnterKeyAction();
        inputPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "inputEnterSubmit");
        inputPanel.getActionMap().put("inputEnterSubmit", inputEnterAction);


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




        // TODO: finish east, west, south buttons + figure out sizing of buttons
        // create a button called "north"
//        JButton north = new JButton("Go North");
//        JButton south = new JButton("Go South");
//        JButton east = new JButton("Go East");
//        JButton west = new JButton("Go West");
//        north.setPreferredSize(new Dimension(1, 1)); ***how to set size of button?

        // add event listener to map button, overrides a lot of methods


        // TODO: CLEAN THIS ISH UP ( 4 VERY SIMILAR LOOKING METHODS? )
        // TODO: CONNECT ACTION LISTENERS TO APPROPRIATE MOVE METHODS IN GAME
        // add action listener and add text to bottomLeft of frame
//        north.addActionListener(e -> {
//            try {
//                GameFrame.this.runCommand("go north");
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        });
//
//        south.addActionListener(e -> {
//            try {
//                GameFrame.this.runCommand("go south");
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        });
//
//        east.addActionListener(e -> {
//            try {
//                GameFrame.this.runCommand("go east");
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        });
//
//        west.addActionListener(e -> {
//            try {
//                GameFrame.this.runCommand("go west");
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        });



        // movement buttons
//        bottomRight.add(north);
//        bottomRight.add(south);
//        bottomRight.add(east);
//        bottomRight.add(west);

        // testing arrowkey input by visual count

//        bottomLeft.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UPARROW");
//        bottomLeft.getActionMap("UPARROW", GameFrame.this.runCommand("go north"));
//
//        JLabel downArrowKey = new JLabel();
//        JLabel leftArrowKey = new JLabel();
//        JLabel rightArrowKey = new JLabel();

//        upArrowKey.setText("Up: 0");
//        downArrowKey.setText("Down: 0");
//        leftArrowKey.setText("Left: 0");
//        rightArrowKey.setText("Right: 0");
//
//        bottomRight.add(upArrowKey);
//        bottomRight.add(downArrowKey);
//        bottomRight.add(leftArrowKey);
//        bottomRight.add(rightArrowKey);

        mainFrame.setFocusable(true);
//        mainFrame.addKeyListener(new KeyListener() {
//            int upCount = 0;
//            int downCount = 0;
//            int rightCount = 0;
//            int leftCount = 0;
//
//            @Override
//            public void keyTyped(KeyEvent e) {}
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                int keyCode = e.getKeyCode();
//                try {
//                    switch (keyCode) {
//                        case KeyEvent.VK_UP -> GameFrame.this.runCommand("go north");
//                        case KeyEvent.VK_DOWN -> GameFrame.this.runCommand("go south");
//                        case KeyEvent.VK_RIGHT -> GameFrame.this.runCommand("go east");
//                        case KeyEvent.VK_LEFT -> GameFrame.this.runCommand("go west");
//                    }
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//            }


//            @Override
//                public void keyReleased (KeyEvent e){
//            }

//        });

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
        mainPanel.add(legendMapPanel);


//        // add all panels to main pane to the main game frame
//        mainFrame.getContentPane().add(gameResponsePanel);
//        mainFrame.getContentPane().add(inventoryPanel);
//        mainFrame.getContentPane().add(inputPanel);
//        mainFrame.getContentPane().add(mapPanel);


        //idk what this does
        mainFrame.pack();
        //make frame visible
        mainFrame.setVisible(true);

        // key bindings testing instead of using key event/listener as we are running into issues
//        private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
//
//        bottomLeft.getInputMap().put(KeyStroke.getKeyCode(KeyEvent.VK_UP), "upAction");
//        bottomLeft.getActionMap().put("upAction", UpAction);

        upAction = new GameFrame.UpAction();
        downAction = new GameFrame.DownAction();
        leftAction  = new GameFrame.LeftAction();
        rightAction = new GameFrame.RightAction();

//        JLabel testLabel = new JLabel();
//        mainFrame.add(testLabel);
//        InputMap testingArrows = new InputMap();
//        mainFrame.getContentPane().add(testingArrowsKeys);

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

    //runs all internal in this method. need to uncouple
    public void runCommand(String command) throws IOException {

        String response = input.getUserAction(this.player, command);
        this.gameResponsePanel.setResponseText(response);
        this.inputPanel.getInputText().setText(null);
        this.inventoryPanel.setInventoryText(this.player.getAllItems().toString());

        //ascii art not working at the moment
        this.locationArt.setText(this.asciiPrinter.printCurrentAscii(this.player));

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

    public class inputEnterKeyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                GameFrame.this.runCommand(inputPanel.getInputText().getText());
                mainFrame.getRootPane().requestFocusInWindow();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

}
