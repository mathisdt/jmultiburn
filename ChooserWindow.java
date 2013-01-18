import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

class ChooserWindow extends javax.swing.JFrame
implements
  java.awt.event.ActionListener
{
  private java.util.ArrayList allButtons;
  private java.awt.Container buttonsPane;

  public ChooserWindow() {
    allButtons = new java.util.ArrayList();
    buttonsPane = getContentPane();
    buttonsPane.setLayout(new java.awt.GridLayout(0, 1));
  }

  public void addButton(javax.swing.JButton j1) {
    allButtons.add(j1);
    j1.setHorizontalTextPosition(0);
    j1.setVerticalTextPosition(3);
    j1.addActionListener(this);
    buttonsPane.add(j1);
  }

  public void reset() {
    int i1;
    setEnabled(true);
    i1 = 0;
    while (i1 < allButtons.size()) {
      ((javax.swing.JButton) allButtons.get(i1)).setEnabled(true);
      i1++;
    }
    setDefaultCloseOperation(3);
  }

  public void reveal() {
    int i1;
    int i2;
    int i3;
    i1 = 0;
    i2 = 0;
    i3 = 0;
    while (i3 < allButtons.size()) {
      if (((javax.swing.JButton) allButtons.get(i3)).getPreferredSize().width > i1) {
        i1 = ((javax.swing.JButton) allButtons.get(i3)).getPreferredSize().width;
      }
      if (((javax.swing.JButton) allButtons.get(i3)).getPreferredSize().height > i2) {
        i2 = ((javax.swing.JButton) allButtons.get(i3)).getPreferredSize().height;
      }
      i3++;
    }
    setResizable(false);
    setDefaultCloseOperation(3);
    pack();
    setVisible(true);
  }

  public void destroyWin() {
    dispose();
  }

  public void actionPerformed(java.awt.event.ActionEvent a1) {
    JButton j2;
    int i3;
    JButton j4;
    ParamWindow p2;
    setEnabled(false);
    setDefaultCloseOperation(0);
    j2 = (javax.swing.JButton) a1.getSource();
    i3 = 0;
    while (i3 < allButtons.size()) {
      j4 = (javax.swing.JButton) allButtons.get(i3);
      if (j4 != j2) {
        j4.setEnabled(false);
      }
      i3++;
    }
    p2 = new ParamWindow(a1.getActionCommand(), j2.getText(), this);
  }
}
