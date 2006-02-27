import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

class AddBurnerButtonListener
implements
  java.awt.event.ActionListener
{

  AddBurnerButtonListener() {
  }

  public void actionPerformed(java.awt.event.ActionEvent a1) {
    IconLoader i2;
    ImageIcon i3;
    JButton j4;
    String s5;
    ParamWindow p6;
    i2 = new IconLoader();
    i3 = i2.getIcon("question.png");
    j4 = (javax.swing.JButton) a1.getSource();
    s5 = (String) javax.swing.JOptionPane.showInputDialog(j4, "Please enter the burner location.", "New Burner", 3, i3, null, "");
    if ((s5 != null) && (s5.equals("") == false)) {
      p6 = (ParamWindow) j4.getTopLevelAncestor();
      p6.addBurner(s5);
    }
  }
}
