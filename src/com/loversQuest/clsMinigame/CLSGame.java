package com.loversQuest.clsMinigame;

import javax.swing.*;
import java.awt.*;

public class CLSGame extends JFrame {

    // variables
    private JPanel questionsPanel;
    private JPanel optionsPanel;

    private JTextArea question;

    // ctor
    public CLSGame() {
      JFrame gameFrame = new JFrame("Quiz Game");
      gameFrame.setSize(400,400);
      GridLayout myLayout = new GridLayout(2, 1);
      gameFrame.setLayout(myLayout);
//      gameFrame.pack();
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // bring in the panels
      questionsPanel = makeQuestionsPanel();
      optionsPanel = makeOptionsPanel();

      // appending the panels onto the frame
      gameFrame.add(questionsPanel);
      gameFrame.add(optionsPanel);


      gameFrame.setVisible(true);
    }

    // create a panel with question
    public JPanel makeQuestionsPanel() {
        JPanel result = new JPanel();
        result.setBackground(Color.pink);

        // in this panel, we want to have a textbox to have the question
        question = getQuestion();
        result.add(question);
        return result;
    }

    // getting a question
    public JTextArea getQuestion() {
        JTextArea result = new JTextArea();
        result.setText("What's the first thing you do when your buddy goes down?");
        return result;
    }

    // create a panel with 4 options
    public JPanel makeOptionsPanel() {
        JPanel result = new JPanel();
        result.setBackground(Color.magenta);

        // putting the buttons
        return result;
    }

    public static void main(String[] args) {
      new CLSGame();
    }
}

