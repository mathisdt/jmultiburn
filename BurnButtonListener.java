import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class BurnButtonListener
implements
  java.awt.event.ActionListener
{

  BurnButtonListener() {
  }

  public void actionPerformed(java.awt.event.ActionEvent a1) {
    JButton j2;
    ParamWindow p3;
    String s4;
    String s5;
    String[] s6;
    BurnWindow b7;
    j2 = (javax.swing.JButton) a1.getSource();
    p3 = (ParamWindow) j2.getTopLevelAncestor();
    s4 = BurnCommands.getBurnCommand(p3.getBurnType());
    s5 = p3.getSource();
    s6 = p3.getBurners();
    p3.destroyWin();
    p3.destroyParent();
    System.out.println("new BurnWindow("+s4+", "+s5+", "+s6+")");
    b7 = new BurnWindow(s4, s5, s6);
  }
}
