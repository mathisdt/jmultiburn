import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ParamCloseListener extends java.awt.event.WindowAdapter
{

  ParamCloseListener() {
  }

  public void windowClosing(java.awt.event.WindowEvent w1) {
    ParamWindow p2;
    p2 = (ParamWindow) w1.getWindow();
    p2.resetRoot();
    p2.dispose();
  }
}
