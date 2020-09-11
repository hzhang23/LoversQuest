package com.loversQuest.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * a class just for map frame
 *
 */



public class MapFrame {
    JFrame frame;

    public MapFrame(){
        frame = new JFrame("Map");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setSize(100, 300);

//        JTextArea mapDisplay = new JTextArea(200, 200);
//        mapDisplay.append(mapString);
//        frame.getContentPane().add(mapDisplay);
//        frame.add(mapDisplay);

        java.net.URL mapUrl = getClass().getResource("gameMap.jpg");
        ImageIcon mapImage = new ImageIcon(mapUrl);
        JLabel map = new JLabel(mapImage);
//        map.setSize(500, 500);

        GridLayout gridLayout = new GridLayout(1, 1);
        frame.setLayout(gridLayout);

        frame.getContentPane().add(map, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
