package com.loversQuest.clsMinigame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CLSQuestionsPanel extends JPanel {

  JLabel Question;
  JRadioButton answerA, answerB, answerC, answerD;
  JButton submit;
  String correct_answer;
  static boolean next = false;
  static int score = 0;

   CLSQuestionsPanel(CLSQuiz obj, JFrame window) {

    Question = new JLabel(obj.question);
    answerA = new JRadioButton(obj.ansA);
    answerB = new JRadioButton(obj.ansB);
    answerC = new JRadioButton(obj.ansC);
    answerD = new JRadioButton(obj.ansD);
    ButtonGroup choices = new ButtonGroup();
    choices.add(answerA);
    choices.add(answerB);
    choices.add(answerC);
    choices.add(answerD);
    correct_answer = obj.correct_answer;
    submit = new JButton();

    JPanel background = new JPanel();
    background.setLayout(null);
    background.setBorder(BorderFactory.createLineBorder(Color.GRAY, 10, true));
    background.setBackground(Color.DARK_GRAY);
    window.setContentPane(background);
    setLayout(null);
    setBackground(Color.getHSBColor(140, 140, 140));
    setBounds(90, 200, 600, 200);
    setBorder(BorderFactory.createBevelBorder(3, Color.BLACK, Color.DARK_GRAY));
    answerA.setBounds(90, 70, 200, 40);
    answerA.setBackground(new Color(170, 170, 170));
    answerB.setBounds(90, 140, 200, 40);
    answerB.setBackground(new Color(170, 170, 170));
    answerC.setBounds(330, 70, 200, 40);
    answerC.setBackground(new Color(170, 170, 170));
    answerD.setBounds(330, 140, 200, 40);
    answerD.setBackground(new Color(170, 170, 170));
    window.setVisible(true);
  }

  void getAnswer() throws InterruptedException {

    submit.addActionListener((ActionEvent e) -> {
      if (answerA.getText().equals(correct_answer))
        score++;
      next = true;
      if (answerB.getText().equals(correct_answer))
        score++;
      next = true;
      if (answerC.getText().equals(correct_answer))
        score++;
      next = true;
      if (answerD.getText().equals(correct_answer))
        score++;
      next = true;
    });
  }

  int getScore() {
    return score;
  }

  void Reset() {
    score = 0;
  }
}