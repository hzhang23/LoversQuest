package com.loversQuest.GUI;

import com.loversQuest.excelReader.ExcelManager;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class GameResponsePanel extends JPanel{


    private JTextArea responseText;
    private DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
    Highlighter highlighter;

    //ctor
    GameResponsePanel(int x, int y){
        responseText = new JTextArea(8,35);
        GridBagLayout layoutTopLeft = new GridBagLayout();
        this.setLayout(layoutTopLeft);

        GridBagConstraints gbcTopLeft = new GridBagConstraints();
        gbcTopLeft.gridx = getX();
        gbcTopLeft.weightx = 1;
        gbcTopLeft.gridy = getY();
        gbcTopLeft.weighty = 1;
        JLabel topLeftLabel = new JLabel("The Quest for Love", SwingConstants.CENTER);
        topLeftLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        gbcTopLeft.fill = GridBagConstraints.HORIZONTAL;
        gbcTopLeft.gridx = 0;
        gbcTopLeft.gridy = 0;
        this.add(topLeftLabel, gbcTopLeft);


        // make it so text cannot be changed
        responseText.setEditable(false);
        responseText.setLineWrap(true);
        responseText.setWrapStyleWord(true);
        responseText.setFont(new Font("Helvetica", Font.PLAIN, 20));
        gbcTopLeft.fill = GridBagConstraints.BOTH;
        gbcTopLeft.gridx = 0;
        gbcTopLeft.gridy = 1;
        this.add(responseText, gbcTopLeft);
    }

    public void setResponseText(String text){
        this.responseText.setText(text);
    }

    /**
     * add highlighter to key items on response panel
     */
    public void addPainter(){
        Map<String, List<String>> gameObjList = ExcelManager.getGameObjList();
        List<String> npcList = gameObjList.get("interact");
        List<String> containerList = gameObjList.get("inspect");
        List<String> itemList = gameObjList.get("get/use");
        String text = responseText.getText();
        for (String npc : npcList){
            if(text.toLowerCase().contains(npc.toLowerCase())){
                setPainterPink();
                this.highlightKeyword(npc);
            }
        }
        for (String container : containerList){
            if(text.toLowerCase().contains(container.toLowerCase())){
                setPainterOrange();
                this.highlightKeyword(container);
            }
        }
        for (String item: itemList){
            if(text.toLowerCase().contains(item.toLowerCase())){
                setPainterCyan();
                this.highlightKeyword(item);
            }
        }
    }

    /**
     * find the key words to highlighter
     * @param keyword
     */
    public void highlightKeyword(String keyword){
        int i = 0;
        highlighter = responseText.getHighlighter();
        while ((i = responseText.getText().toLowerCase().indexOf(keyword, i))>=0){
            try {
                highlighter.addHighlight(i, i+keyword.length(), painter);
                i += keyword.length();
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPainterPink(){
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
    }
    public void setPainterOrange(){
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.orange);
    }
    public void setPainterCyan() { painter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);}


    public JTextArea getResponseText() {
        return responseText;
    }

    public void setResponseText(JTextArea responseText) {
        this.responseText = responseText;
    }
}
