package com.loversQuest.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MapPanel extends JPanel {

    private MapFactory mapFactory = new MapFactory();
    private JTextArea mapText = new JTextArea(10, 20);

    MapPanel(JFrame mainFrame){
        // set layout of panel
        GridLayout gridLayoutBottomRight = new GridLayout(2, 1);
        this.setLayout(gridLayoutBottomRight);

        //create a button called map
        JButton map = new JButton("Map");
        //create event listener for map button, brings up new window with map
        map.addMouseListener(new MouseListener() {

//            public void setButtonTestLabel(JLabel buttonTestLabel) {
//                this.buttonTestLabel = buttonTestLabel;
//            }

            //on mouse click, show map of game world
            // must import MapFactory for this to work
            @Override
            public void mouseClicked(MouseEvent e) {
                mapFactory.showMapFrame();
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

        mapText.append("bottom right");
        this.add(map);

        //adds map image to the panel.
//        java.net.URL mapUrl = getClass().getResource("gameMap.jpg");
//        ImageIcon mapImage = new ImageIcon(mapUrl);
//        JLabel mapImageLabel = new JLabel(mapImage);
//        map.setSize(500, 500);
//
//        GridLayout gridLayout = new GridLayout(1, 1);
//        this.setLayout(gridLayout);
//        this.add(mapImageLabel, BorderLayout.CENTER);


    }

}
