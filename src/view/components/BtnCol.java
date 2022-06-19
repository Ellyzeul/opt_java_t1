package src.view.components;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import config.Config;

public class BtnCol {
  public static JPanel getComponent() {
    JPanel btnCol = new JPanel();
    btnCol.setBackground(new Color(176, 176, 176));
    btnCol.setLayout(new GridBagLayout());

    BtnCol.setTotalCars(btnCol);
    BtnCol.setTotalLaps(btnCol);

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

  private static void setTotalCars(JPanel btnCol) {
    JPanel container = new JPanel();
    JLabel label = new JLabel();
    JTextField totalCars = new JTextField(5);
    GridBagConstraints cons = new GridBagConstraints();
    
    label.setText("Carros:");
    cons.gridy = 0;
    cons.gridx = 0;
    cons.ipady = 1;

    container.add(label);
    container.add(totalCars);
    btnCol.add(container, cons);
  }

  private static void setTotalLaps(JPanel btnCol) {
    JPanel container = new JPanel();
    JLabel label = new JLabel();
    JTextField totalLaps = new JTextField(5);
    GridBagConstraints cons = new GridBagConstraints();
    
    label.setText("Voltas:");
    cons.gridy = 1;
    cons.gridx = 0;
    cons.ipady = 1;

    container.add(label);
    container.add(totalLaps);
    btnCol.add(container, cons);
  }
}
