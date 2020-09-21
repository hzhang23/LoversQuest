package com.loversQuest.soldierOfTheMonthGame;


import com.loversQuest.gameWorldPieces.models_NPC.DrillSGT_CLS;
import javax.swing.JFrame;

public class QuizClient {

  public static void main(String[] args) throws InterruptedException {

    JFrame window = new JFrame("Quiz Game");
    window.setSize(700, 700);
    window.setLocationRelativeTo(null);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);

    while (true) {
      int questionNumber = 0, score = 0;

      SOMLandingPage landingPage = new SOMLandingPage(window);
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
        SOMQuestionsPanel quiz = new SOMQuestionsPanel(quizObj[questionNumber], window);
        quiz.getAnswer(60);
        score = quiz.getScore();
        if (questionNumber == quizObj.length-1) { quiz.reset(); }
        questionNumber++;
//        if (score >= 7) { DrillSGT_CLS.setCLSComplete(true); }
      }

      int numberOfQuestions = quizObj.length;
      System.out.println("You scored " + score + " out of " + numberOfQuestions);
    }
  }
}