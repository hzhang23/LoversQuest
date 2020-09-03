package com.loversQuest.GUI;

import com.loversQuest.IO.Input;
import com.loversQuest.IO.Output;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameFrame {
    JFrame mainFrame;
    MapFactory generateMap = new MapFactory();
    public GameFrame(Input input, Output output){
        //create main frame with title
        mainFrame = new JFrame("Lovers Quest");
        //stop function on exit of main frame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set layout
        GridLayout gridLayout = new GridLayout(2, 2);
        ///apply layout to content of frame
        mainFrame.getContentPane().setLayout(gridLayout);

        // TODO: create text areas, should be panels not just text ares
        JTextArea topLeft = new JTextArea(10, 20);
        //adds text to text area
        topLeft.append(output.displayIntroDialog());
        // make it so text cannot be changed
        topLeft.setEditable(false);

        // create text area and set how many rows and columns of text there are
        JTextArea bottomLeft = new JTextArea(10, 20);
        bottomLeft.append("Bottom left");
        bottomLeft.setEditable(true);

        JTextArea topRight = new JTextArea(10, 20);
        topRight.append("top right");
        topRight.setEditable(false);

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
        //idk what this does
        mainFrame.pack();
        //make frame visible
        mainFrame.setVisible(true);
    }


}
