import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

class SourceButtonListener
implements
  java.awt.event.ActionListener
{

  SourceButtonListener() {
  }

  public void actionPerformed(java.awt.event.ActionEvent a1) {
    JButton jb2;
    ParamWindow p3;
    String s4;
    String s5;
    IconLoader i6;
    ImageIcon i7;
    JFileChooser j2 = null;
    int i2;
    File f10;
    JFileChooser j3;
    File f2;
	jb2 = (javax.swing.JButton) a1.getSource();
	p3 = (ParamWindow) jb2.getTopLevelAncestor();
	s4 = BurnCommands.getSourceType(p3.getBurnType());
	s5 = "";
    if (s4.equals("dev")) {
      i6 = new IconLoader();
      i7 = i6.getIcon("question.png");
      s5 = (String) javax.swing.JOptionPane.showInputDialog(j2, "Please enter the source burner location", "Clone Source", 3, i7, null, "");
    }
    else if (s4.equals("any")) {
      j2 = new javax.swing.JFileChooser();
      j2.setMultiSelectionEnabled(false);
      j2.setFileSelectionMode(2);
      i2 = j2.showOpenDialog(j2);
      if (i2 == 0) {
        f10 = j2.getSelectedFile();
        s5 = f10.getAbsolutePath();
      }
    }
    else if (s4.equals("file")) {
      j3 = new javax.swing.JFileChooser();
      j3.setMultiSelectionEnabled(false);
      j3.setFileSelectionMode(0);
      i2 = j3.showOpenDialog(j2);
      if (i2 == 0) {
        f2 = j3.getSelectedFile();
        s5 = f2.getAbsolutePath();
      }
    }
    else if (s4.equals("dir")) {
      j2 = new javax.swing.JFileChooser();
      j2.setMultiSelectionEnabled(false);
      j2.setFileSelectionMode(1);
      i2 = j2.showOpenDialog(j2);
      if (i2 == 0) {
        f2 = j2.getSelectedFile();
        s5 = f2.getAbsolutePath();
      }
    }
    if ((s5 != null) && (s5.equals("") == false)) {
      p3.setSource(s5);
    }
  }
}
