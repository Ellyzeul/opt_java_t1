package src.view.components;

import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import config.Config;

public class ContentCol {
    public static JPanel getComponent() {
        JPanel contentCol = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ico = new ImageIcon(Config.getFilePath("grass_background.jpg", "assets"));
                g.drawImage(
                    ico.getImage(), 
                    0, 
                    0, 
                    null
                );
            }
        };

        return contentCol;
    }

    public static GridBagConstraints getConstraints() {
        GridBagConstraints cons = new GridBagConstraints();

        cons.anchor = GridBagConstraints.FIRST_LINE_END;
        cons.ipadx = (int) (Config.FRAME_WIDTH * 0.65);
        cons.ipady = Config.FRAME_HEIGHT;
        cons.weightx = 1;
        cons.weighty = 1;

        return cons;
    }
}
