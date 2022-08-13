package src.view.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import config.Config;
import src.view.Context;

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

        ContentCol.setRaceLog(contentCol);
        ContentCol.setProgressBarsContainer(contentCol);

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

    private static void setRaceLog(JPanel contentCol) {
        JPanel container = new JPanel();
        JTextArea raceLog = new JTextArea(10, 40);
        JScrollPane scroll = new JScrollPane(raceLog);
        GridBagConstraints cons = new GridBagConstraints();
        
        cons.gridy = 0;
        cons.gridx = 0;
        cons.ipady = 1;
        cons.anchor = GridBagConstraints.CENTER;

        Context.setRaceLog(raceLog);
    
        container.add(scroll);
        contentCol.add(container, cons);
    }

    private static void setProgressBarsContainer(JPanel contentCol) {
        JPanel container = new JPanel();
        JPanel progressBarsContainer = new JPanel();
        JScrollPane scrollContainer = new JScrollPane(progressBarsContainer);
        GridBagConstraints cons = new GridBagConstraints();

        progressBarsContainer.setPreferredSize(new Dimension(500, 300));

        cons.gridy = 1;
        cons.gridx = 0;
        cons.ipady = 1;
        cons.anchor = GridBagConstraints.CENTER;
        
        Context.setProgressBarsContainer(progressBarsContainer);
        container.add(scrollContainer);
        contentCol.add(progressBarsContainer, cons);
      }
}
