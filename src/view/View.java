package src.view;

import java.awt.Rectangle;

import javax.swing.JFrame;

import config.Config;

public class View {
    private static JFrame frame;

    public static JFrame show() {
        frame = new JFrame();
        View.applyStyle();
        View.setConfigs();
        View.setComponents();
        
        return frame;
    }

    private static JFrame applyStyle() {
        frame.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);

        return frame;
    }

    private static JFrame setConfigs() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMaximizedBounds(new Rectangle(Config.FRAME_WIDTH, Config.FRAME_HEIGHT));

        return frame;
    }

    private static JFrame setComponents() {
        frame.add(AppPanel.getComponent());

        return frame;
    }
}
