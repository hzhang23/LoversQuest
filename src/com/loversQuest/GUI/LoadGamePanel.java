package com.loversQuest.GUI;

import com.google.gson.JsonObject;
import com.loversQuest.StartPanel;
import com.loversQuest.excelReader.ExcelManager;
import com.loversQuest.excelReader.JsonGetter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoadGamePanel extends JPanel {
    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);
    public StartPanel startPanel;

    public LoadGamePanel(StartPanel startPanel) {
        this.startPanel = startPanel;
        JsonObject gamefile = JsonGetter.getGameFile();
        this.setSize(600,600);
        Set<String> keySet = gamefile.keySet();
        String[] keys = keySet.toArray(new String[0]);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Saved File"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        GridBagConstraints gbc;
        for (int i = 0; i < keys.length; i++) {
            gbc = createGbc(0, i);
            add(new JLabel((i+1)+":", JLabel.LEFT), gbc);
            gbc = createGbc(1, i);
            JButton button = new JButton(keys[i]);
            int finalI = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startPanel.gameInit(keys[finalI]);
                    if (finalI != 0){
                    startPanel.getGameFrame().changeTopLeftText("Welcome come Back to Love Quest!");
                    startPanel.getGameFrame().changeTopRightText(startPanel.getGameFrame().getPlayer().getAllItems().toString());
                    }
                }
            });
            add(button, gbc);
        }

        JFrame frame = new JFrame("Choose Game File to Start");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setSize(400,200);
        frame.setLocationRelativeTo(null);

    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.anchor = (x == 0) ? GridBagConstraints.WEST : GridBagConstraints.EAST;
        gbc.fill = (x == 0) ? GridBagConstraints.BOTH
                : GridBagConstraints.HORIZONTAL;

        gbc.insets = (x == 0) ? WEST_INSETS : EAST_INSETS;
        gbc.weightx = (x == 0) ? 0.1 : 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }




}
