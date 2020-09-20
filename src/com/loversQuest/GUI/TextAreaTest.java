package com.loversQuest.GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextAreaTest
{
    DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
    JTextArea ta;
    JFrame frame;


    public void highlighter(String keywords){
        int i = 0;
        while ((i = ta.getText().indexOf(keywords, i))>=0){
            Highlighter highlighter = ta.getHighlighter();
            try {
                highlighter.addHighlight(i, i+keywords.length(), painter);
                i += keywords.length();
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    public void hightlightKeywords(){
        String[] keywords = {"sgt", "ricky", "drill"};
        for (int i = 0; i<keywords.length; i++){
            if (ta.getText().contains(keywords[i])){
                this.highlighter(keywords[i]);
            }
        }
    }

    public void init(){
        frame = new JFrame();
        ta = new JTextArea(10,20);
        ta.setText("drill ricky ricky kiki dicks");
        this.hightlightKeywords();
        frame.add(new JScrollPane(ta));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args)
    {
        String[] keywords = {"sgt", "ricky", "drill"};

        TextAreaTest tat = new TextAreaTest();
        tat.init();
        boolean flag = tat.ta.getText().contains(keywords[0]);
        System.out.println(flag);
    }
}