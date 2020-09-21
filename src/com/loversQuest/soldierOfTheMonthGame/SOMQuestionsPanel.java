package com.loversQuest.soldierOfTheMonthGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class SOMQuestionsPanel extends JPanel {

  JTextArea Question;
  JRadioButton answerA, answerB, answerC, answerD;
  JButton submit;
  String correct_answer;
  static boolean next = false;
  static JLabel timer = new JLabel("00:000");
  static Counter countdown = new Counter();
  static int score = 0;
  List<JRadioButton> buttonGroup = new ArrayList<>();

  SOMQuestionsPanel(SOMQuiz obj, JFrame window) {

    Question = new JTextArea(obj.question);
    answerA = new JRadioButton(obj.ansA);
    answerB = new JRadioButton(obj.ansB);
    answerC = new JRadioButton(obj.ansC);
    answerD = new JRadioButton(obj.ansD);
    ButtonGroup choices = new ButtonGroup();
    choices.add(answerA);
    choices.add(answerB);
    choices.add(answerC);
    choices.add(answerD);


    buttonGroup.add(answerA);
    buttonGroup.add(answerB);
    buttonGroup.add(answerC);
    buttonGroup.add(answerD);

    correct_answer = obj.correct_answer;
    submit = new JButton("Submit");

    JPanel background = new JPanel();
    background.setLayout(null);
    background.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5, true));
    background.setBackground(Color.WHITE);
    setBackground(Color.DARK_GRAY);
    window.setContentPane(background);
    setLayout(null);
    setBounds(0, 0, 595, 595);
    setBorder(BorderFactory.createBevelBorder(3, Color.BLACK, Color.DARK_GRAY));
    window.add(this);

    //add buttons to JFrame
    add(Question);
    add(answerA);
    add(answerB);
    add(answerC);
    add(answerD);
    add(submit);

    //add question to JFrame
    Question.setBounds(10, 10, 560, 160);
    Question.setBorder(new LineBorder(Color.GRAY, 2, true));
    Question.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
    Question.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
    Question.setWrapStyleWord(true);
    Question.setLineWrap(true);
    Question.setFont(new Font("Verdana", Font.BOLD, 14));
    Question.setEditable(false);
    Question.setFocusable(false);

    //add answer selection radio buttons to JFrame
    answerA.setBackground(Color.WHITE);
    answerA.setBounds(25, 225, 533, 25);
    answerA.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, false));
    answerB.setBackground(Color.WHITE);
    answerB.setBounds(25, 253, 533, 25);
    answerB.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, false));
    answerC.setBackground(Color.WHITE);
    answerC.setBounds(25, 281, 533, 25);
    answerC.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, false));
    answerD.setBackground(Color.WHITE);
    answerD.setBounds(25, 309, 533, 25);
    answerD.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, false));

    //add submit button to JFrame
    submit.setBounds(200,365,200,40);
    submit.setBackground(new Color(255,255,255)) ;
    submit.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, false));

    //add timer to JFrame
    timer.setBounds(150, 450, 300, 50);
    timer.setFont(new Font("Verdana", Font.BOLD, 40));
    timer.setHorizontalAlignment(JLabel.CENTER);
    timer.setBorder(BorderFactory.createLineBorder(Color.white));
    timer.setForeground(Color.white);
    add(timer);
  }

    //iterate through choices, if selected button matches answer, increment  score
  void getAnswer(int time) throws InterruptedException {
    submit.addActionListener((ActionEvent a) -> {
//          for (JRadioButton button : buttonGroup) {
//            if (button.isSelected()) {
//              if (button.getText().equals(correct_answer)) {
//                score++;
//              }
//            }
//          }
//          next = true;
//        });
      if (answerA.getText().equals(correct_answer) && answerA.isSelected()) {
        score++; }
      else if (answerB.getText().equals(correct_answer) && answerB.isSelected()) {
        score++; }
      else if (answerC.getText().equals(correct_answer) && answerC.isSelected()) {
        score++; }
      else if (answerD.getText().equals(correct_answer) && answerD.isSelected()) {
        score++; }
      next = true;
    });


    while (!next) {
      timer.setText(String.format("%02d", countdown.S) + ":" + String.format("%03d", countdown.Ms));
      countdown.Ms++;
      Thread.sleep(1);
      if (countdown.Ms == 999) {
        countdown.S++;
        countdown.Ms = 0;
      }
      if (countdown.S > time - 10) {
        timer.setForeground(Color.RED);
        if (countdown.S == time) {
          return;
        }
      }
    }
    next = false;
  }

    int getScore() {
      return score;
    }

    void reset() {
      score = 0;
      countdown.Ms = 0;
      countdown.S = 0;
    }
  }
