import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

class BurnWindow extends javax.swing.JFrame
implements
  java.awt.event.ActionListener
{
  private Runtime runEnviron;
  private javax.swing.JScrollPane burnDispScrl;
  private javax.swing.JTextArea burnDisplay;
  private boolean userQuit;

  BurnWindow(String s1, String s2, String[] s3) {
    Container c4;
    Box b5;
    Box b6;
    Box b7;
    Font f8;
    int i9;
    JButton j10;
    JLabel j11;
    String[] s12;
    int i13;
    userQuit = false;
    setTitle("Burning...");
    setDefaultCloseOperation(0);
    c4 = getContentPane();
    c4.setLayout(new java.awt.BorderLayout());
    b5 = new javax.swing.Box(0);
    b6 = new javax.swing.Box(0);
    b7 = new javax.swing.Box(0);
    c4.add(b5, "North");
    c4.add(b6, "Center");
    c4.add(b7, "South");
    burnDisplay = new javax.swing.JTextArea(24, 80);
    burnDispScrl = new javax.swing.JScrollPane(burnDisplay, 20, 31);
    f8 = burnDisplay.getFont();
    i9 = f8.getSize();
    burnDisplay.setFont(new java.awt.Font("Monospaced", 0, i9));
    burnDisplay.setEditable(false);
    j10 = new javax.swing.JButton("Quit");
    j10.setActionCommand("quit");
    j10.addActionListener(this);
    j11 = new javax.swing.JLabel("Messages");
    b5.add(j11);
    b5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 0, 5));
    b6.add(burnDispScrl);
    b6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
    b7.add(javax.swing.Box.createHorizontalGlue());
    b7.add(j10);
    b7.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
    pack();
    setResizable(false);
    s12 = new String[s3.length + 3];
    s12[0] = "multiburn";
    s12[1] = s1;
    s12[2] = s2;
    i13 = 0;
    while (i13 < s3.length) {
      s12[i13 + 3] = s3[i13];
      i13++;
    }
    runMultiburn(s12);
  }

  private void runMultiburn(String[] s1) {
    Process p2;
    IconLoader i4;
    ImageIcon i5;
    runEnviron = Runtime.getRuntime();
    try {
      p2 = runEnviron.exec(s1);
      new BurnMonitor(burnDisplay, burnDispScrl, p2);
      setVisible(true);
    }
    catch (IOException i1) {
      i4 = new IconLoader();
      i5 = i4.getIcon("error.png");
      javax.swing.JOptionPane.showMessageDialog(this, "Could not run multiburn\nPlease check that it is in your $PATH", "Error", 0, i5);
      dispose();
    }
  }

  public boolean getUserQuitState() {
    return userQuit;
  }

  public void actionPerformed(java.awt.event.ActionEvent a1) {
    Process p2;
    Process p3;
    IconLoader i2;
    ImageIcon i6;
    if (a1.getActionCommand().equals("quit")) {
      userQuit = true;
      try {
        p2 = runEnviron.exec("killall -9 multiburn");
        p3 = runEnviron.exec("rm -rf .multiburn");
      }
      catch (IOException i8) {
        i2 = new IconLoader();
        i6 = i2.getIcon("error.png");
        javax.swing.JOptionPane.showMessageDialog(this, "Could not kill multiburn\nPlease run 'killall -3 multiburn'", "Error", 0, i6);
      }
      dispose();
    }
  }
}
