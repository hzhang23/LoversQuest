package com.loversQuest.GUI;

import javax.swing.*;
import java.awt.*;

public class MapFrame {
    JFrame frame;

    public MapFrame(){
        frame = new JFrame("Map");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        java.net.URL mapUrl = getClass().getResource("gameMap.jpg");
        ImageIcon mapImage = new ImageIcon(mapUrl);
        JLabel map = new JLabel(mapImage);

        GridLayout gridLayout = new GridLayout(1, 1);
        frame.setLayout(gridLayout);

        frame.getContentPane().add(map, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
