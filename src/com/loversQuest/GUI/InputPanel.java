package com.loversQuest.GUI;

import javax.swing.*;
import java.awt.*;


public class InputPanel extends JPanel {

//    private JLabel bottomLeftLabel = new JLabel("Commands: Go <direction>, Look, Inspect <suspicious container>, Use <item>, Interact");
    private JLabel bottomLeftLabel = new JLabel("<html>Commands: <font color=blue> Go </font> 'direction', <font color=orange> Look </font>, <font color=purple> Inspect </font>'suspicious container',<font color=red> Use </font> 'item', <font color=green> Interact </font></html>");

    private JTextField inputText = new JTextField(20);
    private JButton submitButton = new JButton("Submit");

    InputPanel(JFrame mainFrame){
        GridLayout layoutBottomLeft = new GridLayout(3, 1);
        this.setLayout(layoutBottomLeft);
        inputText.setEditable(true);
        inputText.setFont(new Font("Helvetica", Font.PLAIN, 20));

        this.add(bottomLeftLabel);
        this.add(inputText);
        this.add(submitButton);
        mainFrame.getRootPane().setDefaultButton(submitButton);
    }

    public JTextField getInputText(){
        return this.inputText;
    }

    public JButton getSubmitButton(){
        return this.submitButton;
    }
}
