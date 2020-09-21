package com.loversQuest.GUI;

import com.loversQuest.excelReader.ReadExcel;

import java.awt.*;
import java.util.Map;
import javax.swing.*;

class SafetyBriefPanel extends JPanel {

    private static final Insets WEST_INSETS = new Insets(5, 0, 5, 5);
    private static final Insets EAST_INSETS = new Insets(5, 5, 5, 0);


    public SafetyBriefPanel(String game) {
        Map<String, String[]> safetyBriefMap = ReadExcel.getSafetyBrief();
        String[] briefList = safetyBriefMap.get(game);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Safety Brief"),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        GridBagConstraints gbc;
        for (int i = 0; i < briefList.length; i++) {
            gbc = createGbc(0, i);
            add(new JLabel((i+1)+":", JLabel.LEFT), gbc);
            gbc = createGbc(1, i);
            JLabel label = new JLabel(briefList[i]);
            add(label, gbc);
        }
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