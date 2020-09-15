package com.loversQuest.GUI;

import javax.swing.*;
import java.awt.*;

public class GameResponsePanel extends JPanel{

    private JTextArea responseText = new JTextArea(8, 35);

    GameResponsePanel(int x, int y){

        GridBagLayout layoutTopLeft = new GridBagLayout();
        this.setLayout(layoutTopLeft);

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
        this.add(topLeftLabel, gbcTopLeft);


        // make it so text cannot be changed
        responseText.setEditable(false);
        responseText.setLineWrap(true);
        responseText.setWrapStyleWord(true);
        responseText.setFont(new Font("Helvetica", Font.PLAIN, 20));
        gbcTopLeft.fill = GridBagConstraints.BOTH;
        gbcTopLeft.gridx = 0;
        gbcTopLeft.gridy = 1;
        this.add(responseText, gbcTopLeft);

    }

    public void setResponseText(String text){
        this.responseText.setText(text);
    }
}
