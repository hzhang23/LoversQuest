package com.loversQuest.GUI;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel{

    private JTextArea inventoryText;

    InventoryPanel(int x, int y){
        inventoryText = new JTextArea(8,35);
        GridBagLayout layoutTopRight = new GridBagLayout();
        this.setLayout(layoutTopRight);
        GridBagConstraints gbcTopRight = new GridBagConstraints();
        gbcTopRight.gridx = x;
        gbcTopRight.weightx = 1;
        gbcTopRight.gridy = y;
        gbcTopRight.weighty = 1;
        JLabel topRightLabel = new JLabel("Rucksack Inventory", SwingConstants.CENTER);
        topRightLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));

        gbcTopRight.fill = GridBagConstraints.HORIZONTAL;
        gbcTopRight.gridx = 0;
        gbcTopRight.gridy = 0;
        this.add(topRightLabel, gbcTopRight);
        inventoryText.setEditable(false);
        inventoryText.setLineWrap(true);
        inventoryText.setWrapStyleWord(true);
        inventoryText.setFont(new Font("Helvetica", Font.PLAIN, 20));
        gbcTopRight.fill = GridBagConstraints.BOTH;
        gbcTopRight.gridx = 0;
        gbcTopRight.gridy = 1;
        this.add(inventoryText, gbcTopRight);
    }

    public void setInventoryText(String text) {
        this.inventoryText.setText(text);
    }

    public JTextArea getInventoryText() {
        return inventoryText;
    }

    public void setInventoryText(JTextArea inventoryText) {
        this.inventoryText = inventoryText;
    }
}
