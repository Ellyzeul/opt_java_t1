package src.view.components;

import javax.swing.JPanel;

import config.Config;

import java.awt.Color;
import java.awt.GridBagConstraints;

public class BtnCol {
    public static JPanel getComponent() {
        JPanel btnCol = new JPanel();
        btnCol.setBackground(new Color(176, 176, 176));

        return btnCol;
    }

    public static GridBagConstraints getConstraints() {
        GridBagConstraints cons = new GridBagConstraints();

        cons.anchor = GridBagConstraints.FIRST_LINE_START;
        cons.ipadx = (int) (Config.FRAME_WIDTH * 0.35);
        cons.ipady = Config.FRAME_HEIGHT;
        cons.weightx = 1;
        cons.weighty = 1;

        return cons;
    }
}
