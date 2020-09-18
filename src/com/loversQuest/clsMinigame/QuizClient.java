package com.loversQuest.clsMinigame;

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

      CLSLandingPage landingPage = new CLSLandingPage(window);
      landingPage.choose();

      String preQ = "Drill SGT NOGO asks in a commanding voice: ";
      CLSQuiz[] quizObj = {
          new CLSQuiz(preQ + "What's the first thing you do when your buddy goes down?",
              "a) take cover, return fire, direct him to provide self aid",
              "b) tell him to 'hop on, buddy ol' pal!'",
              "c) ditch him",
              "d) call for medic",
              "a) take cover, return fire, direct him to provide self aid"),
          new CLSQuiz(preQ + "You apply a tourniquet to your battle-buddy. What are you"
              + "supposed to write on their forehead?",
              "a) take cover, return fire, direct him to provide self aid",
              "b) tell him to 'hop on, buddy ol' pal!'",
              "c) ditch him",
              "d) call for medic",
              "a) take cover, return fire, direct him to provide self aid")
      };

      while (questionNumber != quizObj.length) {
        CLSQuestionsPanel quiz = new CLSQuestionsPanel(quizObj[questionNumber], window);
        quiz.getAnswer();
        score = quiz.getScore();
        if (questionNumber == quizObj.length-1) quiz.Reset();
        questionNumber++;
      }
      int numberOfQuestions = quizObj.length;
      System.out.println("You scored " + score + " out of " + numberOfQuestions);
    }
  }
}