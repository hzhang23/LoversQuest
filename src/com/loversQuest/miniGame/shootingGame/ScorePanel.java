package com.loversQuest.miniGame.shootingGame;

import javax.swing.*;

public class ScorePanel extends JPanel {

    public String shootScore;
    JTextField scoreField = new JTextField(3);

    public ScorePanel(){
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Seize Fire! Seize Fire! Seize Fire!"),
                BorderFactory.createEmptyBorder(5,5,5,5)
        ));
        JLabel titleLabel = new JLabel("Your Score is: ", JLabel.LEFT);

        scoreField.setEditable(false);
        scoreField.setOpaque(false);
        this.add(titleLabel);
        this.add (scoreField);
        this.setShootScore(scoreField.getText());
    }

    public String getShootScore() {
        return shootScore;
    }
    public void setShootScore(String shootScore) {
        this.shootScore = shootScore;
    }


}
