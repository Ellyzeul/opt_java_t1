package src.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import config.Config;

public class View {
    private static JFrame frame;


    public static JFrame show() {
        frame = new JFrame();
        View.applyStyle();
        View.setLayout();
        View.setPanels();
        View.setConfigs();
        
        return frame;
    }

    private static JFrame applyStyle() {
        frame.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    private static JFrame setLayout() {
        frame.setLayout(new GridBagLayout());

        return (frame);
    }

    private static JFrame setPanels() {
        frame = View.setBtnCol();
        frame = View.setContentCol();

        return frame;
    }

    private static JFrame setBtnCol() {
        JPanel btnCol = new JPanel();
        GridBagConstraints cons = new GridBagConstraints();

        btnCol.setBackground(new Color(176, 176, 176));
        cons.anchor = GridBagConstraints.FIRST_LINE_START;
        cons.ipadx = (int) (Config.FRAME_WIDTH * 0.35);
        cons.ipady = Config.FRAME_HEIGHT;
        cons.weightx = 1;
        cons.weighty = 1;

        frame.add(btnCol, cons);

        return frame;
    }

    private static JFrame setContentCol() {
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
        GridBagConstraints cons = new GridBagConstraints();

        cons.anchor = GridBagConstraints.FIRST_LINE_END;
        cons.ipadx = (int) (Config.FRAME_WIDTH * 0.65);
        cons.ipady = Config.FRAME_HEIGHT;
        cons.weightx = 1;
        cons.weighty = 1;

        frame.add(contentCol, cons);

        return frame;
    }

    private static JFrame setConfigs() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMaximizedBounds(new Rectangle(Config.FRAME_WIDTH, Config.FRAME_HEIGHT));

        return frame;
    }
}
