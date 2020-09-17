package com.loversQuest.clsMinigame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CLSGame extends JFrame {

    // variables
    private JPanel questionsPanel;
    private JPanel optionsPanel;

    private ArrayList<JButton> buttonsList;

    private JTextArea question;



    // ctor
    public CLSGame(int questionNumber) {
      JFrame gameFrame = new JFrame("Quiz Game");
      gameFrame.setSize(400,400);
      GridLayout myLayout = new GridLayout(2, 1);
      gameFrame.setLayout(myLayout);
//      gameFrame.pack();
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // bring in the panels
      questionsPanel = makeQuestionsPanel(questionNumber);
      optionsPanel = makeOptionsPanel(questionNumber);

      // appending the panels onto the frame
      gameFrame.add(questionsPanel);
      gameFrame.add(optionsPanel);


      gameFrame.setVisible(true);
    }

    // create a panel with question
    public JPanel makeQuestionsPanel(int questionNumber) {
        JPanel result = new JPanel();
        result.setBackground(Color.pink);

        // in this panel, we want to have a textbox to have the question
        question = getQuestion(questionNumber);
        result.add(question);
        return result;
    }

    // getting a question
    public JTextArea getQuestion(int questionNumber) {
        JTextArea result = new JTextArea();

        // getting the list of questions from QuestionsList class
        QuestionsList questionsList = new QuestionsList();
        HashMap<Integer, String> myList = questionsList.getQuestions();

        // set the text area to have the specific question
        result.setText(myList.get(questionNumber));
        return result;
    }

    // create a panel with 4 options
    public JPanel makeOptionsPanel(int questionNumber) {
        JPanel result = new JPanel();
        result.setBackground(Color.magenta);


        GridLayout myLayout = new GridLayout(4, 1);
        result.setLayout(myLayout);


        // bring in and make the buttons
        buttonsList = makeButtonsList(questionNumber);


        // adding the buttons to the panel
       for (JButton button : buttonsList) {
           result.add(button);
       }

        return result;
    }

    public ArrayList<JButton> makeButtonsList(int questionNumber) {
        ArrayList<JButton> result = new ArrayList<>();

        // accessing the optionsList, and get a list of options per that question
        OptionsList optionsList = new OptionsList();
        String[] myOptions = optionsList.getOptions().get(questionNumber);

        // make the buttons
        for (String option : myOptions) {
            JButton optionButton = new JButton(option);
            result.add(optionButton);
        }

        return result;
    }

    public static void main(String[] args) {
      new CLSGame(1);
    }
}

