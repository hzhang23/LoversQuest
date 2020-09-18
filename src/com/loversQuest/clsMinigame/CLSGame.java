package com.loversQuest.clsMinigame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CLSGame extends JFrame {

    // variables
    private JPanel questionsPanel;
    private JPanel optionsPanel;

    private ArrayList<JButton> buttonsList;

    private JTextArea question;
    private int score;


    // ctor
    public CLSGame(int questionNumber) {
      JFrame gameFrame = new JFrame("Quiz Game");
      gameFrame.setSize(800,800);
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
        if (questionNumber > 10) {
            System.out.println("Game Over");
            System.out.println("You scored " + getScore());
            System.exit(0);
        }
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

            // what do we want the button to do?
                // check to see if that answer is correct
                optionButton.addActionListener(new ActionListener() {

                    AnswersList answersList = new AnswersList();
                    HashMap<Integer, String> answersMap = answersList.getAnswers();
                    String correctAnswer = answersMap.get(questionNumber);
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (optionButton.getText().equals(correctAnswer)) {
                            System.out.println("got it right");
                            score++;
                        }

                        // go to the next question
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(optionButton);
                        frame.remove(questionsPanel);
                        questionsPanel = makeQuestionsPanel(questionNumber + 1);
                        frame.add(questionsPanel);
                        frame.revalidate();
                        frame.repaint();

                        // update the answer choices
                        frame.remove(optionsPanel);
                        optionsPanel = makeOptionsPanel(questionNumber + 1);
                        frame.add(optionsPanel);
                        frame.revalidate();
                        frame.repaint();
                    }
                });
            result.add(optionButton);
        }
        return result;
    }

    public int getScore() {
        return this.score;
    }

    public static void main(String[] args) {
      new CLSGame(1);
    }
}

