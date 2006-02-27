import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

class ParamWindow extends javax.swing.JFrame
{
  private ChooserWindow rootChooser;
  private String burnType;
  private javax.swing.DefaultListModel burners;
  private String currentSource;
  private boolean listDefault;
  private boolean sourceDefault;
  private javax.swing.JPanel burnerListPanel;
  private javax.swing.JButton burnB;
  private javax.swing.JList burnerList;
  private javax.swing.JTextField currentSourceDisp;

  public ParamWindow(String s1, String s2, ChooserWindow c3) {
    Container c4;
    Box b5;
    Box b6;
    Box b7;
    JButton j8;
    JScrollPane j9;
    JButton j10;
    JButton j11;
    burners = new javax.swing.DefaultListModel();
    currentSource = "No source currently selected";
    listDefault = true;
    sourceDefault = true;
    rootChooser = c3;
    burnType = s1;
    setTitle(s2);
    setDefaultCloseOperation(0);
    addWindowListener(new ParamCloseListener());
    c4 = getContentPane();
    c4.setLayout(new java.awt.BorderLayout());
    b5 = new javax.swing.Box(0);
    b6 = new javax.swing.Box(0);
    b7 = new javax.swing.Box(0);
    c4.add(b5, "North");
    c4.add(b6, "Center");
    c4.add(b7, "South");
    b5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 2, 5));
    b6.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 5, 3, 5));
    b7.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 5, 5, 5));
    currentSourceDisp = new javax.swing.JTextField(currentSource);
    currentSourceDisp.setEditable(false);
    j8 = new javax.swing.JButton("Source...");
    j8.setToolTipText("Change the file(s) to be used as a data source");
    j8.addActionListener(new SourceButtonListener());
    j8.setActionCommand("sourceChange");
    b5.add(j8);
    b5.add(javax.swing.Box.createHorizontalStrut(5));
    b5.add(currentSourceDisp);
    b5.add(javax.swing.Box.createHorizontalGlue());
    burnerList = new javax.swing.JList(burners);
    burnerList.setToolTipText("Use Ctrl-click to select multiple entries");
    burners.addElement("No burners currently selected");
    j9 = new javax.swing.JScrollPane(burnerList);
    b6.add(j9);
    j10 = new javax.swing.JButton("Add Burner...");
    j10.setToolTipText("Add a burner to the list of burners to use");
    j10.addActionListener(new AddBurnerButtonListener());
    j11 = new javax.swing.JButton("Remove selected burners");
    j11.setToolTipText("Remove the burners selected above");
    j11.addActionListener(new RemBurnerButtonListener());
    burnB = new javax.swing.JButton("BURN");
    burnB.setToolTipText("Start the burning process");
    burnB.setEnabled(false);
    burnB.addActionListener(new BurnButtonListener());
    burnB.setForeground(Color.RED);
    b7.add(j10);
    b7.add(javax.swing.Box.createHorizontalStrut(2));
    b7.add(j11);
    b7.add(javax.swing.Box.createHorizontalGlue());
    b7.add(javax.swing.Box.createHorizontalStrut(5));
    b7.add(burnB);
    pack();
    setVisible(true);
  }

  public String getBurnType() {
    return burnType;
  }

  public String getSource() {
    return currentSource;
  }

  public String[] getBurners() {
    Object[] o1;
    String[] s2;
    int i3;
    o1 = burners.toArray();
    s2 = new String[o1.length];
    i3 = 0;
    while (i3 < o1.length) {
      s2[i3] = (String) o1[i3];
      i3++;
    }
    return s2;
  }

  public void setSource(String s1) {
    currentSource = s1;
    currentSourceDisp.setText(currentSource);
    sourceDefault = false;
    updateBurnB();
  }

  public void addBurner(String s1) {
    if (listDefault) {
      burners.clear();
      listDefault = false;
    }
    burners.addElement(s1);
    updateBurnB();
  }

  public void remBurner(int i1) {
    burners.remove(i1);
    if (burners.size() == 0) {
      addBurner("No burners currently selected");
      listDefault = true;
    }
    updateBurnB();
  }

  void resetRoot() {
	  if (rootChooser != null) {
		  rootChooser.reset();
	  }
  }

  public int[] getSelectedBurners() {
    return burnerList.getSelectedIndices();
  }

  public void updateBurnB() {
    if ((listDefault) || (sourceDefault)) {
      burnB.setEnabled(false);
    }
    else {
      burnB.setEnabled(true);
    }
  }

  public void destroyWin() {
    dispose();
  }

  public void destroyParent() {
	  if (rootChooser != null) {
		  rootChooser.destroyWin();
	  }
  }
}
