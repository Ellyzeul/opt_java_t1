package src.view.components;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import config.Config;
import src.controller.CarController;
import src.view.Context;

public class BtnCol {
  private static JTextField totalCars;
  private static JTextField totalLaps;

  public static JPanel getComponent() {
    JPanel btnCol = new JPanel();
    btnCol.setBackground(new Color(176, 176, 176));
    btnCol.setLayout(new GridBagLayout());

    BtnCol.setTotalCars(btnCol);
    BtnCol.setTotalLaps(btnCol);
    BtnCol.setProbCrash(btnCol);
    BtnCol.setProbRefuel(btnCol);
    BtnCol.setStartBtn(btnCol);

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

    totalCars.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void insertUpdate(DocumentEvent e) {
        try {
          CarController.setTotalCars(Integer.parseInt(totalCars.getText()));
        }
        catch(Exception err) {}
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        try {
          CarController.setTotalCars(Integer.parseInt(totalCars.getText()));
        }
        catch(Exception err) {}
      }

      @Override
      public void changedUpdate(DocumentEvent e) {}
      
    });

    BtnCol.totalCars = totalCars;

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

    totalLaps.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void insertUpdate(DocumentEvent e) {
        try {
          CarController.setTotalLaps(Integer.parseInt(totalLaps.getText()));
        }
        catch(Exception err) {}
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        try {
          CarController.setTotalLaps(Integer.parseInt(totalLaps.getText()));
        }
        catch(Exception err) {}
      }

      @Override
      public void changedUpdate(DocumentEvent e) {}
      
    });

    BtnCol.totalLaps = totalLaps;

    container.add(label);
    container.add(totalLaps);
    btnCol.add(container, cons);
  }

  private static void setProbCrash(JPanel btnCol) {
    JPanel container = new JPanel();
    JLabel label = new JLabel();
    JTextField probCrash = new JTextField(5);
    GridBagConstraints cons = new GridBagConstraints();
    
    label.setText("Chance de quebrar (ex.: 0.35):");
    cons.gridy = 2;
    cons.gridx = 0;
    cons.ipady = 1;

    probCrash.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void insertUpdate(DocumentEvent e) {
        try {
          CarController.setProbCrash(Float.parseFloat(probCrash.getText()));
        }
        catch(Exception err) {}
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        try {
          CarController.setProbCrash(Float.parseFloat(probCrash.getText()));
        }
        catch(Exception err) {}
      }

      @Override
      public void changedUpdate(DocumentEvent e) {}
      
    });

    container.add(label);
    container.add(probCrash);
    btnCol.add(container, cons);
  }

  private static void setProbRefuel(JPanel btnCol) {
    JPanel container = new JPanel();
    JLabel label = new JLabel();
    JTextField probRefuel = new JTextField(5);
    GridBagConstraints cons = new GridBagConstraints();
    
    label.setText("Chance de reabestecer (ex.: 0.35):");
    cons.gridy = 3;
    cons.gridx = 0;
    cons.ipady = 1;

    probRefuel.getDocument().addDocumentListener(new DocumentListener() {

      @Override
      public void insertUpdate(DocumentEvent e) {
        try {
          CarController.setProbRefuel(Float.parseFloat(probRefuel.getText()));
        }
        catch(Exception err) {}
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        try {
          CarController.setProbRefuel(Float.parseFloat(probRefuel.getText()));
        }
        catch(Exception err) {}
      }

      @Override
      public void changedUpdate(DocumentEvent e) {}
      
    });

    container.add(label);
    container.add(probRefuel);
    btnCol.add(container, cons);
  }

  private static void setStartBtn(JPanel btnCol) {
    JPanel container = new JPanel();
    JButton startBtn = new JButton("Iniciar");
    GridBagConstraints cons = new GridBagConstraints();
    
    cons.gridy = 4;
    cons.gridx = 0;
    cons.ipady = 1;

    startBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Context.setProgressBars(
          Integer.parseInt(BtnCol.totalCars.getText()), 
          Integer.parseInt(BtnCol.totalLaps.getText())
        );
        CarController.startRace();
      }
    });

    container.add(startBtn);
    btnCol.add(container, cons);
  }
}
