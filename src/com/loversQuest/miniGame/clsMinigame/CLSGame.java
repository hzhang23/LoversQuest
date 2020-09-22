package com.loversQuest.miniGame.clsMinigame;
import com.loversQuest.GUI.GameFrame;
import com.loversQuest.gameWorldPieces.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CLSGame {

    GameFrame gameFrame;
    private JFrame clsGameFrame;
    private JPanel questionsPanel;
    private JPanel optionsPanel;
    private ArrayList<JButton> buttonsList;
    private JTextArea question;
    private int score;

    public CLSGame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public void init(int questionNumber) {
        clsGameFrame = new JFrame("Army Combat Life Saver Qualification Exam");
        clsGameFrame.setSize(800, 800);
        GridLayout myLayout = new GridLayout(2, 1);
        clsGameFrame.setLayout(myLayout);
        // bring in the panels
        questionsPanel = makeQuestionsPanel(questionNumber);
        optionsPanel = makeOptionsPanel(questionNumber);
        clsGameFrame.add(questionsPanel);
        clsGameFrame.add(optionsPanel);
        clsGameFrame.setLocationRelativeTo(null);
        clsGameFrame.setVisible(true);
        clsGameFrame.setAlwaysOnTop(true);
    }

    // create a panel with question
    public JPanel makeQuestionsPanel(int questionNumber) {
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.setBackground(Color.gray);
        // in this panel, we want to have a textbox to have the question
        question = getQuestion(questionNumber);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setSize(new Dimension(600,400));
        question.setOpaque(false);
        Font questionFont = new Font("textile", Font.BOLD, 60);
        question.setFont(questionFont);
        result.add(question, BorderLayout.CENTER);
        return result;
    }

    // handling the end of the game
    public void handleResult() {
        clsGameFrame.remove(optionsPanel);
        clsGameFrame.remove(questionsPanel);
        clsGameFrame.dispose();
        gameOver();
    }

    public void gameOver() {
        String[] options = {"CLS Qualification Exam Time Out!"};
        int response = JOptionPane.showOptionDialog(null, "your scored: " + this.getScore(), "CLS Test Result",
                JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (response == 0) {
            this.returnGameFrame();
            gameFrame.setVisible(true);
        }
    }

    public void returnGameFrame() {
        if (this.getScore() >= 7) {
            Item MedicalBadge = new Item("Combat Life Saver Badge", "You can make things less deader better");
            gameFrame.changeTopLeftText("You are tired from FIREMAN carry your battle buddy but feel happy that you passed the exam");
            gameFrame.getPlayer().addItem(MedicalBadge);
        } else {
            gameFrame.changeTopLeftText("you are smoked by Drill SGT and have to bear crawl back to Barracks");
            gameFrame.getPlayer().go("south");
            gameFrame.getMapPanel().updateImageLabel(gameFrame.getPlayer().getCurrentLocation().getName());
        }
        gameFrame.refreshPanel();
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
            optionButton.setFont(new Font("textile", Font.PLAIN, 20));
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
}

