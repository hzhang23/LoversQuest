package com.loversQuest.miniGame.soldierOfTheMonthGame;

public class SOMQuiz {

  String question, ansA, ansB, ansC, ansD, correct_answer;

   SOMQuiz(String question, String ansA, String ansB, String ansC, String ansD, String corrAns) {
    this.question = question;
    this.ansA = ansA;
    this.ansB = ansB;
    this.ansC = ansC;
    this.ansD = ansD;
    this.correct_answer = corrAns;
  }
}
