package com.loversQuest.GUI;

import com.loversQuest.gameWorldPieces.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import java.awt.event.*;


public class GameFrame {
    JFrame mainFrame;
    MapFactory generateMap = new MapFactory();
    JTextArea topLeftText = new JTextArea();
    JTextArea topRightText = new JTextArea(10, 20);
    JTextField bottomLeftText = new JTextField(15);
    JFrameInput input;
    Player player;


    String gameCommand;

    public GameFrame(String gameResponse, JFrameInput input, Player player){
        //TODO: Text input area at bottom has event listener for enter key and button press.
        // When event is triggered the panes are re-rendered with the following
        // Game response text, Inventory, Map(if location is included), Ascii art..
        this.input = input;
        this.player = player;


        //create main frame with title
        mainFrame = new JFrame("Lovers Quest");
        //stop function on exit of main frame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set layout
        GridLayout gridLayout = new GridLayout(2, 2);
        ///apply layout to content of frame
        mainFrame.getContentPane().setLayout(gridLayout);





        JPanel topLeft = new JPanel();
        GridLayout layoutTopLeft = new GridLayout(1,1);
        topLeft.setLayout(layoutTopLeft);
//        JTextArea topLeftText = new JTextArea();
        //adds text to text area


        topLeftText.append(gameResponse);
        // make it so text cannot be changed
        topLeftText.setEditable(false);
        topLeftText.setLineWrap(true);
        topLeftText.setWrapStyleWord(true);
        topLeft.add(topLeftText);

        // create text area and set how many rows and columns of text there are
        JPanel bottomLeft = new JPanel();
        GridLayout layoutBottomLeft = new GridLayout(1,2);
        topLeft.setLayout(layoutBottomLeft);

//        bottomLeftText.append("");
        bottomLeftText.setEditable(true);
        bottomLeftText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                        GameFrame.this.runCommand(bottomLeftText.getText());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        bottomLeft.add(bottomLeftText);

        JButton submitButton = new JButton("Submit");
        submitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gameCommand = bottomLeftText.getText();
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
        mainFrame.getRootPane().setDefaultButton(submitButton);
        bottomLeft.add(submitButton);



        JPanel topRight = new JPanel();
        GridLayout layoutTopRight = new GridLayout(1,1);
        topLeft.setLayout(layoutTopRight);

        topRightText.append("top right");
        topRightText.setEditable(false);
        topRightText.setLineWrap(true);
        topRightText.setWrapStyleWord(true);
        topRight.add(topRightText);


        // done correctly with a panel
        JPanel bottomRight = new JPanel();
        // set layout of panel
        GridLayout gridLayoutBottomRight = new GridLayout(2, 1);
        bottomRight.setLayout(gridLayoutBottomRight);

        //create a button called map
        JButton map = new JButton("Map");

        // TODO: finish east, west, south buttons + figure out sizing of buttons
        // create a button called "north"
        JButton north = new JButton("Go North");
        JButton south = new JButton("Go South");
        JButton east = new JButton("Go East");
        JButton west = new JButton("Go West");
//        north.setPreferredSize(new Dimension(1, 1)); ***how to set size of button?


        // add event listener to map button, overrides a lot of methods
        map.addMouseListener(new MouseListener() {

//            public void setButtonTestLabel(JLabel buttonTestLabel) {
//                this.buttonTestLabel = buttonTestLabel;
//            }

            //on mouse click, show map of game world
            // must import MapFactory for this to work
            @Override
            public void mouseClicked(MouseEvent e) {
                generateMap.showMapFrame();
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

        // TODO: CLEAN THIS ISH UP ( 4 VERY SIMILAR LOOKING METHODS? )
        // TODO: CONNECT ACTION LISTENERS TO APPROPRIATE MOVE METHODS IN GAME
        // add action listener and add text to bottomLeft of frame
        north.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bottomLeftText.setText(" north button working b. ");
            }
        });

        south.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bottomLeftText.setText(" South button working b. ");
            }
        });

        east.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bottomLeftText.setText(" easT button working b. ");
            }
        });

        west.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bottomLeftText.setText(" WEST button working b. ");
            }
        });

        JTextArea bottomRightText = new JTextArea(10, 20);
        bottomRightText.append("bottom right");
        bottomRight.add(map);
        bottomRight.add(bottomRightText);
        bottomRightText.setEditable(true);

        // movement buttons
        bottomRight.add(north);
        bottomRight.add(south);
        bottomRight.add(east);
        bottomRight.add(west);

        // testing arrowkey input by visual count
        JLabel upArrowKey = new JLabel();
        JLabel downArrowKey = new JLabel();
        JLabel leftArrowKey = new JLabel();
        JLabel rightArrowKey = new JLabel();

        upArrowKey.setText("Up: 0");
        downArrowKey.setText("Down: 0");
        leftArrowKey.setText("Left: 0");
        rightArrowKey.setText("Right: 0");

        bottomRight.add(upArrowKey);
        bottomRight.add(downArrowKey);
        bottomRight.add(leftArrowKey);
        bottomRight.add(rightArrowKey);

        mainFrame.setFocusable(true);
        mainFrame.addKeyListener(new KeyListener() {
            int upCount = 0;
            int downCount = 0;
            int rightCount = 0;
            int leftCount = 0;

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP -> upArrowKey.setText("Up: " + Integer.toString(upCount++));
                    case KeyEvent.VK_DOWN -> downArrowKey.setText("Down: " + Integer.toString(downCount++));
                    case KeyEvent.VK_RIGHT -> rightArrowKey.setText("Right: " + Integer.toString(rightCount++));
                    case KeyEvent.VK_LEFT -> leftArrowKey.setText("Left: " + Integer.toString(leftCount++));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });

        // add all jcomponents to the main game frame
        mainFrame.getContentPane().add(topLeft);
        mainFrame.getContentPane().add(topRight);
        mainFrame.getContentPane().add(bottomLeft);
        mainFrame.getContentPane().add(bottomRight);


        //idk what this does
        mainFrame.pack();
        //make frame visible
        mainFrame.setVisible(true);
    }

    public void changeTopLeftText (String newText){
        topLeftText.setText(newText);
    }

    public void changeTopRightText(String inventory){
        topRightText.setText(inventory);

    }

    //runs all internal in this method. need to uncouple
    public void runCommand(String command) throws IOException {

        String response = input.getUserAction(this.player, command);
        this.changeTopLeftText(response);
        this.bottomLeftText.setText(null);
        this.topRightText.setText(this.player.getAllItems().toString());

    }




}
