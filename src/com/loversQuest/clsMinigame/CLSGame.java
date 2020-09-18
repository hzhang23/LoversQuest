package com.loversQuest.clsMinigame;

import com.loversQuest.gymGame.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CLSGame extends JFrame {

    // variables
    private JFrame gameFrame;
    private JPanel questionsPanel;
    private JPanel optionsPanel;

    private ArrayList<JButton> buttonsList;

    private JTextArea question;
    private int score;


    // ctor
    public CLSGame(int questionNumber) {
      gameFrame = new JFrame("Quiz Game");
      gameFrame.setSize(800,800);
      GridLayout myLayout = new GridLayout(2, 1);
      gameFrame.setLayout(myLayout);
//      gameFrame.pack();
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // bring in the panels
      questionsPanel = makeQuestionsPanel(questionNumber);
      optionsPanel = makeOptionsPanel(questionNumber);

      // adding a welcome message box
      JOptionPane.showInternalMessageDialog(gameFrame.getContentPane(), "Welcome to the CLS quiz, you need to answer at least 7 questions correctly to receive the CLS badge.");

      // appending the panels onto the frame
      gameFrame.add(questionsPanel);
      gameFrame.add(optionsPanel);


      gameFrame.setVisible(true);
    }

    // create a panel with question
    public JPanel makeQuestionsPanel(int questionNumber) {

        JPanel result = new JPanel();
        result.setBackground(Color.gray);

        // in this panel, we want to have a textbox to have the question
        question = getQuestion(questionNumber);
        result.add(question);
        return result;
    }

    // handling the end of the game
    public void handleResult() {
        gameFrame.remove(optionsPanel);
        gameFrame.remove(questionsPanel);
        if (getScore() >= 7) {
            JOptionPane.showInternalMessageDialog(gameFrame.getContentPane(), "Congrats! You passed the test!");
            System.exit(0);
        } else {
            gameOver();
        }
    }

    public void gameOver() {
        int response = JOptionPane.showConfirmDialog(null, "You scored " + this.getScore() + " points. You need at least 7. Do you want to play again?", "Game Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        else if (response == JOptionPane.YES_OPTION) {
//            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            gameFrame.dispose();
//            System.exit(0);
            new CLSGame(1);
        }
        else if (response == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
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
        if (questionNumber > 10) {
            return null;
        }
        JPanel result = new JPanel();
        result.setBackground(Color.darkGray);


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
        if (questionNumber > 10) {
            return null;
        }
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

                        // at the end of question 10, pass it to the handler
                        if (questionNumber + 1 > 10) {
                            handleResult();
                        }
                        questionsPanel = makeQuestionsPanel(questionNumber + 1);
                        frame.add(questionsPanel);
                        frame.revalidate();
                        frame.repaint();

                        // update the answer choices
                        frame.remove(optionsPanel);
                        if (questionNumber + 1 > 10) {
                            return;
                        }
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

