import java.net.URL;
import javax.swing.ImageIcon;

class IconLoader
{

  IconLoader() {
  }

  public javax.swing.ImageIcon getIcon(String s1) {
    URL u2;
    ImageIcon i3;
    u2 = getClass().getResource(s1);
    i3 = new javax.swing.ImageIcon(u2);
    return i3;
  }
}
