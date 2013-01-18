import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class RemBurnerButtonListener
implements
  java.awt.event.ActionListener
{

  RemBurnerButtonListener() {
  }

  public void actionPerformed(java.awt.event.ActionEvent a1) {
    JButton j2;
    ParamWindow p3;
    int[] i4;
    j2 = (javax.swing.JButton) a1.getSource();
    p3 = (ParamWindow) j2.getTopLevelAncestor();
    i4 = p3.getSelectedBurners();
    int l5 = i4.length - 1;
    while (l5 >= 0) {
      p3.remBurner(i4[l5]);
      l5--;
    }
  }
}
