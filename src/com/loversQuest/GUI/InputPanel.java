package com.loversQuest.GUI;

import javax.swing.*;
import java.awt.*;


public class InputPanel extends JPanel{

    private JLabel bottomLeftLabel = new JLabel("Commands: Go <direction>, Look, Inspect <suspicious container>, Use <item>, Interact");
    private JTextField inputText = new JTextField(20);
    private JButton submitButton = new JButton("Submit");

    InputPanel(JFrame mainFrame){
        inputText.setEditable(true);
        inputText.setFont(new Font("Helvetica", Font.PLAIN, 20));
        this.add(bottomLeftLabel);
        this.add(inputText);
        this.add(submitButton);

//        mainFrame.getRootPane().setDefaultButton(submitButton);
    }

    public void cursorFocus() {
        inputText.requestFocus();
        inputText.grabFocus();
    }

    public JTextField getInputText(){
        return this.inputText;
    }

    public JButton getSubmitButton(){
        return this.submitButton;
    }
}
