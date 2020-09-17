package com.loversQuest.clsMinigame;

import static com.loversQuest.gameWorldPieces.Location.locationMap;

import com.loversQuest.gameWorldPieces.Player;
import java.util.Scanner;

public class CombatLifeSaverMinigame extends CLSGame {

  private static CLSGame clsGame;

  private CombatLifeSaverMinigame() {
  }

  /**
   * @return instance of the CombatLifeSaverMinigame class if null
   */
  public static CLSGame getInstance() {
    if (clsGame == null) {
      clsGame = new CombatLifeSaverMinigame();
    }
    return clsGame;
  }

  /**
   * @param player uses player object
   * @return boolean true or false if player wins or loses
   */
  // returns a boolean as to whether or not the player passed the test

  // GUI - Questions in pane across top
//  Answer with appropriate key press?
//  buttons that are linked to string inputs?
//  timer for responses?
  @Override
  public Boolean clsGame(Player player) {
    Scanner sc = new Scanner(System.in);
    int correctAnswers = 0;
    boolean playerHasWon = false;
    String answer;
    String drillQuestion = "Drill SGT NOGO asks in a commanding voice: ";
    System.out
        .println(drillQuestion + "What's the first thing you do when your buddy goes down?"
            + "\n a) take cover, return fire, direct him to provide self aid"
            + "\n b) tell him to 'hop on, buddy ol' pal!'"
            + "\n c) ditch him"
            + "\n d) call for medic \n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("a")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    System.out
        .println(drillQuestion + "You apply a tourniquet to your battle-buddy. What are you "
            + "supposed to write on their forehead?"
            + "\n a) their unit"
            + "\n b) their injury"
            + "\n c) the time the tourniquet was applied"
            + "\n d) all of those \n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("c")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    System.out
        .println(drillQuestion + "You are shot in the leg and are under heavy fire. What should "
            + "you do?"
            + "\n a) provide self aid"
            + "\n b) call for the medic"
            + "\n c) tell the enemy to 'hol up!'"
            + "\n d) take cover, return fire, provide self aid when able \n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("d")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    System.out
        .println(
            drillQuestion + "What is your first action when you reach a wounded soldier while "
                + "under fire?"
                + "\n a) check pockets for MRE goodies"
                + "\n b) check responsiveness"
                + "\n c) take their ammo and weapons"
                + "\n d) ask them, 'whodunnit?' \n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("b")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    System.out
        .println(drillQuestion + "Your battle is injured but only responds with a wince from \n"
            + "a brisk nuggie to his chest. What is this known as on the AVPU scale?"
            + "\n a) alert"
            + "\n b) verbal"
            + "\n c) pain"
            + "\n d) unresponsive \n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("c")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    System.out
        .println(drillQuestion + "You've been wounded, are unable to return fire, and there \n"
            + "is nowhere nearby to take cover. What should you do?"
            + "\n a) play dead"
            + "\n b) surrender"
            + "\n c) pretend you're not a combatant"
            + "\n d) snap and say 'o no u di'int!' \n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("a")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    System.out
        .println(drillQuestion + "The look/listen/feel method is used to determine what?"
            + "\n a) tremors... those dang worm things!"
            + "\n b) if there are nearby troops"
            + "\n c) whether you are upwind or downwind from the enemy"
            + "\n d) whether a casualty is breathing or not \n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("d")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    System.out
        .println(drillQuestion + "A casualty is bleeding severely from a head wound. Should you \n "
            + "apply a tourniquet?"
            + "\n a) yes"
            + "\n b) no"
            + "\n c) yes, pop that head like a pimple"
            + "\n d) iono \n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("b")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    System.out
        .println(drillQuestion + "A casualty is bleeding bright red blood from a wound on their \n "
            + "thigh. What's the first thing you should do?"
            + "\n a) determine if they are responsive"
            + "\n b) ask if they want anything from the grocery store"
            + "\n c) apply a tourniquet"
            + "\n d) apply direct pressure to the wound, then apply a tourniquet\n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("d")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    System.out
        .println(drillQuestion + "A casualty you're treating has lost a fair amount of blood, looks \n "
            + "like a ghost, is mumbling incoherently and is cool and clammy. These are signs of...?"
            + "\n a) REM sleep"
            + "\n b) elation from being MEDEVAC'd"
            + "\n c) shock"
            + "\n d) dat special sauce\n > ");
    answer = sc.next().toLowerCase().strip();
    if (answer.equals("c")) {
      correctAnswers++;
      if (answer != "a" || answer != "b" || answer != "c" || answer != "d") {
        System.out.println("That's not an answer, worm! Next question!");
      }
    }
    if (correctAnswers >= 7) {
      playerHasWon = true;
      System.out.println("You passed, fuzzy. Now go clean the latrine!");
      return playerHasWon;
    } else {
      System.out.println("You are the biggest failure I've ever seen in my life! Half right~ FACE! \n "
          + "Front lean-and-rest position~ MOVE!");
      return playerHasWon;
    }
  }

  public static void main(String[] args) {
    Player p1 = new Player("p1", locationMap.get("barracks"));
    CLSGame game = new CombatLifeSaverMinigame();
    game.clsGame(p1);
  }
}