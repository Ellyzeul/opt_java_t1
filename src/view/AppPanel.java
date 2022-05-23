package src.view;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import src.view.components.BtnCol;
import src.view.components.ContentCol;

public class AppPanel {
    public static JPanel getComponent() {
        JPanel appPanel = new JPanel();

        appPanel.setLayout(new GridBagLayout());

        appPanel.add(
            BtnCol.getComponent(),
            BtnCol.getConstraints()
        );

        appPanel.add(
            ContentCol.getComponent(),
            ContentCol.getConstraints()
        );

        return appPanel;
    }
}
