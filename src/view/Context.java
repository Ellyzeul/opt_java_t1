package src.view;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class Context {
  private static JTextArea raceLog;
  private static ArrayList<JProgressBar> progressBars;
  private static JPanel progressBarsContainer;

  public static void setProgressBarsContainer(JPanel progressBarsContainer) {
    Context.progressBarsContainer = progressBarsContainer;
  }

  public static ArrayList<JProgressBar> getProgressBars() {
    return progressBars;
  }

  public static void setProgressBars(int totalCars, int totalLaps) {
    Context.cleanProgressBarsContainer();
    ArrayList<JProgressBar> progressBars = new ArrayList<>();

    for(int i = 0; i < totalCars; i++) {
      JPanel container = new JPanel();
      JLabel label = new JLabel();
      JProgressBar progressBar = new JProgressBar(0, totalLaps);
    
      progressBar.setBounds(new Rectangle(300, 100));
      progressBar.setValue(0);
      progressBar.setForeground(new Color(
        (int) (Math.random() % 256),
        (int) (Math.random() % 256),
        (int) (Math.random() % 256)
      ));
      progressBar.setStringPainted(true);
      progressBar.setString("0/"+totalLaps);

      label.setText(String.format("#%04d", i+1));

      container.add(label);
      container.add(progressBar);

      Context.progressBarsContainer.add(container);
      progressBars.add(progressBar);
    }

    Context.progressBars = progressBars;
  }

  public static void setRaceLog(JTextArea raceLog) {
    Context.raceLog = raceLog;
  }

  public static JTextArea getRaceLog() {
    return raceLog;
  }

  private static void cleanProgressBarsContainer() {
    if(Context.progressBars == null || Context.progressBars.size() == 0) return;

    for (JProgressBar jProgressBar : progressBars) {
      Context.progressBarsContainer.remove(jProgressBar);
    }
  }
}
