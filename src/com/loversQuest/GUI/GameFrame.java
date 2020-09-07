package com.loversQuest.GUI;

import com.loversQuest.gameWorldPieces.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class GameFrame {
    JFrame mainFrame;
    MapFactory generateMap = new MapFactory();
    JTextArea topLeftText = new JTextArea();
    JTextArea topRightText = new JTextArea();
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
        GridLayout gridLayout = new GridLayout(3, 2);
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
        // add event listener to map button, overrides a lot of methods
        map.addMouseListener(new MouseListener() {

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

        JTextArea bottomRightText = new JTextArea(10, 20);
        bottomRightText.append("bottom right");
        bottomRight.add(map);
        bottomRight.add(bottomRightText);
        bottomRightText.setEditable(false);

        // add all jcomponents to the main game frame
        mainFrame.getContentPane().add(topLeft);

        mainFrame.getContentPane().add(topRight);
        mainFrame.getContentPane().add(bottomLeft);
        mainFrame.getContentPane().add(bottomRight);

        JTextPane testPane = new JTextPane();
        testPane.setText(gameResponse);
        testPane.setVisible(true);
        mainFrame.getContentPane().add(testPane);

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

    }




}
