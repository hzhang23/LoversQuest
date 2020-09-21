package com.loversQuest.soldierOfTheMonthGame;


import com.loversQuest.GUI.GameFrame;
import com.loversQuest.gameWorldPieces.Item;

import javax.swing.*;

public class SOMClient {
  GameFrame gameFrame;
  JFrame somGame;
  SOMQuestionsPanel questionsPanel;
  private int score;
  int questionNumber;




  public SOMClient(GameFrame gameFrame){
    this.gameFrame = gameFrame;
  }

  public void init(){
    score = 0;
    somGame = new JFrame("Quiz Game");
    somGame.setSize(700, 700);
    somGame.setLocationRelativeTo(null);
    somGame.setResizable(false);

    questionNumber=0;
    score = 0;

      SOMLandingPage landingPage = new SOMLandingPage(somGame);
      landingPage.choose(60);

      String preQ = "Drill SGT Dicks asks in a commanding voice: ";
      SOMQuiz[] quizObj = {
              new SOMQuiz(preQ + "What's the first Amazonian leadership principle?",
                      "Learn and Be Curious",
                      "Ownership",
                      "Customer Obsession",
                      "Do Your Best",
                      "Customer Obsession"),
              new SOMQuiz(preQ + "Your manager tells you to ship your code but there are a few things that you can't let go of just quite yet because "
                      + "you continually check your work and have found additional areas that need to be addressed. Which Amazonian Leadership Principle is this an"
                      + "example of?",
                      "Insist on the Highest Standards",
                      "Think Big",
                      "Bias for Action",
                      "all of those",
                      "Insist on the Highest Standards"),
              new SOMQuiz(preQ + "How many Leadership Principles does Amazon have?",
                      "Eleven",
                      "Eight",
                      "Twenty",
                      "Fourteen",
                      "Fourteen"),
              new SOMQuiz(preQ + "You have always ascribed to the idea that leadership does not have to be formal - informal leadership is just as valuable "
                      + "as formal leadership. Through this practice, you are always connected to various levels and echelons of your team and help where and when you are able. "
                      + "what Amazonian Leadership Principle does this demonstrate?",
                      "Have Backbone; Disagree and Commit",
                      "Are Right, A Lot",
                      "Dive Deep",
                      "Earn Trust",
                      "Dive Deep"),
              new SOMQuiz(preQ + "Amazon values calculated risk taking. Which Leadership Principle describes this?",
                      "iono ¯\\_(ツ)_/¯",
                      "Invent and Simplify",
                      "Ownership",
                      "Bias for Action",
                      "Bias for Action"),
              new SOMQuiz(preQ + "As everyone at Amazon is a leader, the purview is never, 'That's not my job'. Which Amazonian principle describes this?",
                      "Frugality",
                      "Deliver Results",
                      "Earn Trust",
                      "Ownership",
                      "Ownership"),
              new SOMQuiz(preQ + "At Amazon, we accomplish more with less. We operate within the framework that constraints breed resourcefulness, self-sufficiency, "
                      + "and invention. Which Amazonian Leadership Principle does this fall under?",
                      "Frugality",
                      "Earn Trust",
                      "Deliver Results",
                      "Invent and Simplify",
                      "Frugality"),
              new SOMQuiz(preQ + "What is Amazon's motto?",
                      "'Be What's Next'",
                      "'Do The Right Thing'",
                      "'Work Hard. Have Fun. Make History.'",
                      "'I'm Lovin' it'",
                      "'Work Hard. Have Fun. Make History.'")};

      while (questionNumber != quizObj.length) {
        questionsPanel = new SOMQuestionsPanel(quizObj[questionNumber], somGame);
        try {
          questionsPanel.getAnswer(60);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        score = questionsPanel.getScore();
        if (questionNumber == quizObj.length-1) { questionsPanel.reset(); }
        questionNumber++;
//        if (score >= 7) { DrillSGT_CLS.setCLSComplete(true); }
      }
      int numberOfQuestions = quizObj.length;
      String[] options = {"Thanks for participating in the Soldier of the Month board!"};
      int response = JOptionPane.showOptionDialog(null, "your scored: " + score + " out of " + numberOfQuestions, "Soldier of The Month Board Result",
              JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
      if(score >= 5){
        gameFrame.changeTopLeftText("You are now the Soldier of the Month and you can get that Diamond Ring with 99% discount");
        Item SOM = new Item("Soldier of Month Certificate", "Sham Perks");
        gameFrame.getPlayer().addItem(SOM);
      } else {
        gameFrame.changeTopLeftText("Half Right Face!!! Front Lean and Rest Position Move!!!! now study your leadership principles");
      }
    gameFrame.refreshPanel();
    if (response == 0) {
        somGame.dispose();
      }
      System.out.println("You scored " + score + " out of " + numberOfQuestions);
    }

  public boolean isGameOver(){
    if(this.questionNumber >= 8){
      return true;
    }
    return false;
  }
}