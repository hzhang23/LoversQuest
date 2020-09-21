package com.loversQuest.clsMinigame;


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

      CLSLandingPage landingPage = new CLSLandingPage(window);
      landingPage.choose(60);

      String preQ = "Drill SGT NOGO asks in a commanding voice: ";
      CLSQuiz[] quizObj = {
          new CLSQuiz(preQ + "What's the first thing you do when your buddy goes down?",
              "take cover, return fire, direct him to provide self aid",
              "tell him to 'hop on, buddy ol' pal!'",
              "ditch him",
              "call for medic",
              "take cover, return fire, direct him to provide self aid"),
          new CLSQuiz(preQ + "You apply a tourniquet to your battle-buddy. What are you supposed to write on their forehead?",
              "their unit",
              "their injury",
              "the time the tourniquet was applied",
              "all of those",
              "the time the tourniquet was applied"),
          new CLSQuiz(preQ + "You are shot in the leg and are under heavy fire. What should you do?",
              "provide self aid",
              "call for the medic",
              "tell the enemy to 'hol up!'",
              "take cover, return fire, provide self aid when able",
              "take cover, return fire, provide self aid when able"),
          new CLSQuiz(preQ + "What is your first action when you reach a wounded soldier while under fire?",
              "check pockets for MRE goodies",
              "check responsiveness",
              "take their ammo and weapons",
              "ask them, 'whodunnit?",
              "check responsiveness"),
          new CLSQuiz(preQ + "Your battle is injured but only responds with a wince from a brisk nuggie to his chest. What is this known as on the AVPU scale?",
              "alert",
              "verbal",
              "pain",
              "unresponsive",
              "pain"),
          new CLSQuiz(preQ + "You've been wounded, are unable to return fire, and there is nowhere nearby to take cover. What should you do?",
              "play dead",
              "surrender",
              "pretend you're not a combatant",
              "snap and say 'o no u di'int!'",
              "play dead"),
          new CLSQuiz(preQ + "The look/listen/feel method is used to determine what?",
              "tremors... those dang worm things!",
              "if there are nearby troops",
              "whether you are upwind or downwind from the enemy",
              "whether a casualty is breathing or not",
              "whether a casualty is breathing or not"),
          new CLSQuiz(preQ + "A casualty is bleeding severely from a head wound. Should you apply a tourniquet?",
              "yes",
              "no",
              "yes, pop that head like a pimple!",
              "iono ¯\\_(ツ)_/¯",
              "no"),
          new CLSQuiz(preQ + "A casualty is bleeding bright red blood from a wound on their thigh. What's the first thing you should do?",
              "determine if they are responsive",
              "ask if they have any last words",
              "apply a tourniquet",
              "apply direct pressure to the wound, then apply a tourniquet",
              "apply direct pressure to the wound, then apply a tourniquet"),
          new CLSQuiz(preQ + "A casualty you're treating has lost a fair amount of blood, looks like a ghost, is mumbling incoherently and is cool and clammy. These are signs of...?",
              "REM sleep",
              "elation from the impending MEDEVAC",
              "shock",
              "dat special sauce",
              "shock")};

      while (questionNumber != quizObj.length) {
        CLSQuestionsPanel quiz = new CLSQuestionsPanel(quizObj[questionNumber], window);
        quiz.getAnswer(60);
        score = quiz.getScore();
        if (questionNumber == quizObj.length-1) { quiz.reset(); }
        questionNumber++;
        if (score >= 7) { DrillSGT_CLS.setCLSComplete(true); }
      }

      int numberOfQuestions = quizObj.length;
      System.out.println("You scored " + score + " out of " + numberOfQuestions);
    }
  }
}