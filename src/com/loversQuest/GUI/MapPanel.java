package com.loversQuest.GUI;

import javax.swing.*;
import java.awt.*;


public class MapPanel extends JPanel{

    // variables
    private JLabel imageLabel;
    private JPanel imagePanel;
    private JScrollPane scrollPane;

    // ctor
    public MapPanel(String location){
        String picLocation = location.replaceAll(" ", "");
        String fileName = String.format("resources/%s.png", picLocation);
        ImageIcon image = new ImageIcon(fileName);

        // make the label
        imageLabel = new JLabel();
        imageLabel.setIcon(image);

        // make the panel
        //imagePanel = new JPanel(new BorderLayout());
        imagePanel = new JPanel(new GridBagLayout());
        imagePanel.add(imageLabel);
        imagePanel.setSize(imageLabel.getWidth(), imageLabel.getHeight());

        // make the scroll pane
        scrollPane = new JScrollPane(imagePanel);
        scrollPane.setOpaque(true);
        scrollPane.setPreferredSize(new Dimension (880, 550));
        this.add(scrollPane);
    }

    // method to update the corresponding map image
    public void updateImageLabel(String location) {
        String picLocation = location.replaceAll(" ", "");
        String fileName = String.format("resources/%s.png", picLocation);
        if (fileName.contains("ending")){
            fileName = "resources/ending.gif";
        }
        ImageIcon image = new ImageIcon(fileName);
        this.imageLabel.setIcon(image);
    }
}