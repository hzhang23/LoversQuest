package com.loversQuest.GUI;

import com.loversQuest.IO.GraphicClass;
import com.loversQuest.gameWorldPieces.Player;
import com.loversQuest.IO.GraphicClass.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

import java.awt.event.*;


public class GameFrame extends JFrame implements KeyListener{
    JFrame mainFrame;
    MapFactory generateMap = new MapFactory();
    JTextArea topLeftText = new JTextArea(20, 20);
    JTextArea topRightText = new JTextArea(20,20);
    JTextField bottomLeftText = new JTextField(20);
    JTextArea locationArt = new JTextArea();
    JFrameInput input;
    Player player;
    GraphicClass asciiPrinter;
    Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);


    String gameCommand;

    public GameFrame(String gameResponse, JFrameInput input, Player player, GraphicClass asciiPrinter) throws IOException {
        //TODO: Text input area at bottom has event listener for enter key and button press.
        // When event is triggered the panes are re-rendered with the following
        // Game response text, Inventory, Map(if location is included), Ascii art..
        this.input = input;
        this.player = player;
        this.asciiPrinter = asciiPrinter;


        //create main frame with title
        mainFrame = new JFrame("Lovers Quest");
        //stop function on exit of main frame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set layout
        GridLayout mainGridLayout = new GridLayout(2, 2, 3, 3);
        ///apply layout to content of frame
        mainFrame.getContentPane().setLayout(mainGridLayout);


        JPanel topLeft = new JPanel();
        GridBagLayout layoutTopLeft = new GridBagLayout();
        topLeft.setLayout(layoutTopLeft);
        GridBagConstraints gbcTopLeft = new GridBagConstraints();
        gbcTopLeft.gridx = getX();
        gbcTopLeft.weightx = 1;
        gbcTopLeft.gridy = getY();
        gbcTopLeft.weighty = 1;
        JLabel topLeftLabel = new JLabel("The Quest for Love", SwingConstants.CENTER);
        topLeftLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        gbcTopLeft.fill = GridBagConstraints.HORIZONTAL;
        gbcTopLeft.gridx = 0;
        gbcTopLeft.gridy = 0;
        topLeft.add(topLeftLabel, gbcTopLeft);

        // make it so text cannot be changed
        topLeftText.setEditable(false);
        topLeftText.setLineWrap(true);
        topLeftText.setWrapStyleWord(true);
        topLeftText.setFont(new Font("Helvetica", Font.PLAIN, 20));
        gbcTopLeft.fill = GridBagConstraints.BOTH;
        gbcTopLeft.gridx = 0;
        gbcTopLeft.gridy = 1;
        topLeft.add(topLeftText, gbcTopLeft);
        //adds text to text area
        topLeftText.append(gameResponse);


        // create text area and set how many rows and columns of text there are
        JPanel bottomLeft = new JPanel();
        GridLayout layoutBottomLeft = new GridLayout(3, 1);
        JLabel bottomLeftLabel = new JLabel("Commands: Go <direction>, Look, Inspect <suspicious container>, Use <item>, Interact");

//        bottomLeft.add(locationArt);
        bottomLeft.setLayout(layoutBottomLeft);
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
        bottomLeftText.setFont(new Font("Helvetica", Font.PLAIN, 20));

        bottomLeft.add(bottomLeftLabel);
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
        GridBagLayout layoutTopRight = new GridBagLayout();
        topRight.setLayout(layoutTopRight);
        GridBagConstraints gbcTopRight = new GridBagConstraints();
        gbcTopRight.gridx = getX();
        gbcTopRight.weightx = 1;
        gbcTopRight.gridy = getY();
        gbcTopRight.weighty = 1;
        JLabel topRightLabel = new JLabel("Rucksack Inventory", SwingConstants.CENTER);
        topRightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));

        gbcTopRight.fill = GridBagConstraints.HORIZONTAL;
        gbcTopRight.gridx = 0;
        gbcTopRight.gridy = 0;
        topRight.add(topRightLabel, gbcTopRight);
        topRightText.setEditable(false);
        topRightText.setLineWrap(true);
        topRightText.setWrapStyleWord(true);
        topRightText.setFont(new Font("Helvetica", Font.PLAIN, 20));
        gbcTopRight.fill = GridBagConstraints.BOTH;
        gbcTopRight.gridx = 0;
        gbcTopRight.gridy = 1;
        topRight.add(topRightText, gbcTopRight);


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

        //set border
        mainFrame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        topLeft.setBorder(blackBorder);
        topRight.setBorder(blackBorder);
        bottomLeft.setBorder(blackBorder);
        bottomRight.setBorder(blackBorder);
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
        this.locationArt.setText(this.asciiPrinter.printCurrentAscii(this.player));

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //does this put an event listener on the whole frame?
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            try {
                GameFrame.this.runCommand(bottomLeftText.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            try {
                GameFrame.this.runCommand("go south");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
