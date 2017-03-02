package swing;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.*;
public class SwingTest {
	
	JFrame f=new JFrame("test");
	Icon okIcon=new ImageIcon("icon/ok.png");
	JButton ok=new JButton("确认",okIcon);
	
	JRadioButton male=new JRadioButton("男",true);
	JRadioButton female=new JRadioButton("女",false);
	ButtonGroup bg=new ButtonGroup();
	
	JCheckBox married=new JCheckBox("是否已婚？",false);
	
	String[] colors=new String[]{"red","green","blue"};
	JComboBox<String> colorChooser=new JComboBox<String>(colors);
	
	JList<String> colorList=new JList<String>(colors);
	
	JTextArea ta=new JTextArea(8,20);
	JTextField name=new JTextField(40);
	
	JMenuBar mb=new JMenuBar();
	JMenu file=new JMenu("file");
	JMenu edit=new JMenu("edit");
	
	Icon newIcon=new ImageIcon("icon/new.png");
	JMenuItem newItem=new JMenuItem("save",newIcon);
	Icon saveIcon=new ImageIcon("icon/new.png");
	JMenuItem saveItem=new JMenuItem("save",saveIcon);
	Icon exitIcon=new ImageIcon("iocn/exit.png");
	JMenuItem exitItem=new JMenuItem("exit",exitIcon);
	JCheckBoxMenuItem autoWrap=new JCheckBoxMenuItem("autoWrap");
	JMenuItem copyItem=new JMenuItem("copy",new ImageIcon("icon/copy.png"));
	JMenuItem pasteItem=new JMenuItem("paste",new ImageIcon("icon/paste.png"));
	
	JMenu format=new JMenu("format");
	JMenuItem commentItem=new JMenuItem("comment");
	JMenuItem cancelItem=new JMenuItem("cancel");
	
	JPopupMenu pop=new JPopupMenu();
	ButtonGroup flavorGroup=new ButtonGroup();
	JRadioButtonMenuItem metalItem=new JRadioButtonMenuItem("metal",true);
	JRadioButtonMenuItem nimbusItem=new JRadioButtonMenuItem("nimbus");
	JRadioButtonMenuItem windowItem=new JRadioButtonMenuItem("window");
	JRadioButtonMenuItem classicItem=new JRadioButtonMenuItem("classic");
	JRadioButtonMenuItem motifItem=new JRadioButtonMenuItem("motif");
	
	public void init(){
		JPanel bottom=new JPanel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom,"South");
		
		JPanel checkPanel=new JPanel();
		checkPanel.add(colorChooser);
		bg.add(male);
		bg.add(female);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		
		Box topleft=Box.createVerticalBox();
		JScrollPane taJsp=new JScrollPane(ta);
		topleft.add(taJsp);
		topleft.add(checkPanel);
		
		Box top=Box.createHorizontalBox();
		top.add(topleft);
		top.add(colorList);
		f.add(top);
		
		newItem.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		newItem.addActionListener(e->ta.append("user click the button 'new'"));
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		
		edit.add(autoWrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		
		commentItem.setToolTipText("add the comment to code!");
		format.add(commentItem);
		format.add(cancelItem);
		
		edit.add(new JMenuItem("-"));
		edit.add(format);
		
		
		mb.add(file);
		mb.add(edit);
		
		f.setJMenuBar(mb);

		flavorGroup.add(metalItem);
		flavorGroup.add(nimbusItem);
		flavorGroup.add(windowItem);
		flavorGroup.add(classicItem);
		flavorGroup.add(motifItem);
		
		pop.add(metalItem);
		pop.add(nimbusItem);
		pop.add(windowItem);
		pop.add(classicItem);
		pop.add(motifItem);
		
		ActionListener flavorListener=e->{
			try{
				switch(e.getActionCommand()){
				case "metal":ChangeFlavor(1);
				break;
				case "nimbus":ChangeFlavor(2);
				break;
				case "window":ChangeFlavor(3);
				break;
				case "classic":ChangeFlavor(4);
				break;
				case "motif":ChangeFlavor(5);
				break;
				}
			}catch(Exception ee){
				ee.printStackTrace();
			}
		};
		
		metalItem.addActionListener(flavorListener);
		nimbusItem.addActionListener(flavorListener);
		windowItem.addActionListener(flavorListener);
		classicItem.addActionListener(flavorListener);
		motifItem.addActionListener(flavorListener);
		
		ta.setComponentPopupMenu(pop);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	private void ChangeFlavor(int flavor)throws Exception{
		switch(flavor){
		case 1:
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			break;
		case 2:
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			break;
		case 3:
			UIManager.setLookAndFeel("com.sun.javax.swing.plaf.windows.WindowsLookAndFeel");
			break;
		case 4:
			UIManager.setLookAndFeel("com.sun.javax.swing.plaf.windows.WindowsClassicLookAndFeel");
			break;
		case 5:
			UIManager.setLookAndFeel("com.sun.javax.swing.plaf.motif.MotifLookAndFeel");
			break;
		}
		SwingUtilities.updateComponentTreeUI(f.getContentPane());
		SwingUtilities.updateComponentTreeUI(mb);
		SwingUtilities.updateComponentTreeUI(pop);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new SwingTest().init();

	}

}
