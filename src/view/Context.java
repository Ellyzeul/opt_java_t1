package src.view;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Context {
  private static JTextField totalCars;
  private static JTextField totalLaps;

  public static void setTotalCars(JTextField totalCars) {
    totalCars.getDocument().addDocumentListener(new DocumentListener() {
      private String previousValue = "";
      private String actualValue;

      private void handleUpdate() {
        try {
          actualValue = totalCars.getText();
          Integer.parseInt(actualValue);
          previousValue = actualValue;
        }
        catch (NumberFormatException error) {
          totalCars.setText(previousValue);
        }
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
        this.handleUpdate();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        
      }

      @Override
      public void changedUpdate(DocumentEvent e) {}
    });

    Context.totalCars = totalCars;
  }

  public static void setTotalLaps(JTextField totalLaps) {
    Context.totalLaps = totalLaps;
  }

  public static JTextField getTotalCars() {
    return Context.totalCars;
  }

  public static JTextField getTotalLaps() {
    return Context.totalLaps;
  }
}
