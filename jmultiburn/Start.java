import javax.swing.ImageIcon;
import javax.swing.JButton;

class Start
{

  Start() {
  }

  static public void main(String[] s1) {
    ChooserWindow c2;
    IconLoader i3;
    ImageIcon i4;
    JButton j5;
    ImageIcon i6;
    JButton j7;
    ImageIcon i8;
    JButton j9;
    ImageIcon i10;
    JButton j11;
    ImageIcon i12;
    JButton j13;
    ImageIcon i14;
    JButton j15;
    c2 = new ChooserWindow();
    c2.setTitle("Jmultiburn");
    i3 = new IconLoader();
    i4 = i3.getIcon("audioDir.png");
    j5 = new javax.swing.JButton("Directory of audio files", i4);
    j5.setActionCommand("audioDir");
    c2.addButton(j5);
    i6 = i3.getIcon("data.png");
    j7 = new javax.swing.JButton("Data file or directory", i6);
    j7.setActionCommand("data");
    c2.addButton(j7);
    i8 = i3.getIcon("audioSingle.png");
    j9 = new javax.swing.JButton("Single audio file", i8);
    j9.setActionCommand("singleAudio");
    c2.addButton(j9);
    i10 = i3.getIcon("image.png");
    j11 = new javax.swing.JButton("ISO or other image", i10);
    j11.setActionCommand("image");
    c2.addButton(j11);
    i12 = i3.getIcon("toc.png");
    j13 = new javax.swing.JButton("TOC or cue file", i12);
    j13.setActionCommand("toc");
    c2.addButton(j13);
    i14 = i3.getIcon("clone.png");
    j15 = new javax.swing.JButton("Clone existing CD", i14);
    j15.setActionCommand("clone");
    c2.addButton(j15);
    c2.reveal();
  }
  
  /*
  public static void main(String[] args) {
	  new ParamWindow("singleAudio", "Burn Audio File", null);
  }
  */
}

  
  