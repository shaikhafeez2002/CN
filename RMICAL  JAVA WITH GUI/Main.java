import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyActionListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    System.out.println("Command: " + e.getActionCommand());
    Object source = e.getSource();
    if (source instanceof JButton) {
      JButton jb = (JButton) source;
      System.out.println("JButton: " + jb.getText());
    }
  }
}

public class Main {
  public static void main(String args[]) {
    JFrame frame = new JFrame();

    JButton button = new JButton("Click and holding alt, control, and shift key");
    button.addActionListener(new MyActionListener());
    frame.add(button);
    frame.pack();
    frame.setVisible(true);
  }
}