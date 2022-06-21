package src.view;

import javax.swing.JTextArea;

public class Context {
  private static JTextArea raceLog;

  public static void setRaceLog(JTextArea raceLog) {
    Context.raceLog = raceLog;
  }

  public static JTextArea getRaceLog() {
    return raceLog;
  }
}
