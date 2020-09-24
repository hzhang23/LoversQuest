package com.loversQuest.GUI;
import com.loversQuest.fileHandler.JsonGetter;
import com.loversQuest.gameWorldPieces.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartPanel extends JPanel {
    private static String startImage = "resources/start_image.jpg";
    JFrame startFrame;

    Player player;
    GameFrame gameFrame;
    //ctor
    public StartPanel(){
        startFrame = new JFrame("Love Quest");
        JLabel title = new JLabel("Love Quest");
        title.setBounds(40,10,900,100);
        Font font = new Font("Comic Sans MS", Font.ITALIC + Font.BOLD, 99);
        title.setFont(font);
        title.setForeground(Color.white);
        MyButton startBtn = new MyButton("New Story");
        MyButton resumeBtn = new MyButton("Resume a Story");
        startBtn.setBounds(550,150,300,100);
        resumeBtn.setBounds(550,300,300,100);
        this.setLayout(null);
        this.add(startBtn);
        this.add(resumeBtn);
        startFrame.add(title);
        startFrame.add(this);
        startFrame.setSize(900,600);
        startFrame.setLocationRelativeTo(null);
        startFrame.setVisible(true);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameInit("newgame");
                startFrame.dispose();
            }
        });
        resumeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoadGamePanel(StartPanel.this);
                startFrame.dispose();
            }
        });
    }

    public Player readGameFile(String gamefile){
        player = JsonGetter.readGame(gamefile);
        return player;
    }

    public String displayIntroDialog(){
        String output = "WELCOME TO LOVERSQUEST \n" +
                "You have almost completed AIT at Fort Sam Houston. You about to graduate but you still " +
                "have tasks to finish. \nYour mission is to gather as many white claws as possible and find diamond ring for your other half." +
                "Beware of fellow students, and drill sergeants. \nTry to complete all your basic warrior skills " +
                "while acquiring as many white claws as possible before graduation.... \n" +
                "You open your eyes, and find yourself in the barracks staring up at the crooked ceiling above.\n" +
                "You must complete all the warrior tasks while collecting as many badges as possible to meet up with your AIT bf/gf for a few adult beverages\n" +
                "and surprise her/him before you are both sent off to your duty stations.";
        return output;
    }

    public void gameInit(String gamefile){
        //Output output = new Output();
        JFrameInput jFrameInput = new JFrameInput();
        gameFrame = new GameFrame(this.displayIntroDialog(), jFrameInput, this.readGameFile(gamefile));
        gameFrame.changeTopRightText("This is your rucksack.\nIn it you will find all the items you are currently carrying and can use.\n" +
                "Below is the command window. Enter any of the commands listed. You may also maneuver using the arrow keys.");
    }

    //Business Methods
    @Override
    public void paintComponent(Graphics graph){
        super.paintComponent(graph);
        ImageIcon bgImg = new ImageIcon(startImage);
        graph.drawImage(bgImg.getImage(),0,0, this.getWidth(),this.getHeight(),bgImg.getImageObserver());
    }


    private class MyButton extends JButton{

        public MyButton(String name){
            MyButton.this.setText(name);
            MyButton.this.setMargin(new Insets(0,0,0,0));
            MyButton.this.setForeground(Color.white);
            MyButton.this.setBorder(BorderFactory.createLineBorder(Color.white, 3));
            MyButton.this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    MyButton.this.setForeground(Color.orange);
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    MyButton.this.setForeground(Color.white);
                }
            });
            Font fontBtn = new Font("Comic Sans MS", Font.ITALIC + Font.BOLD, 30);
            MyButton.this.setFont(fontBtn);
        }
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

}
