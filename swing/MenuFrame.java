package swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class MenuFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;
	private Action saveAction;
	private Action saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
	private JTextArea textarea;
	
	class TestAction extends AbstractAction{

		private static final long serialVersionUID = 1L;

		public TestAction(String name){
			super(name);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(getValue(Action.NAME)+"selected.");
			
		}
		
	}
	public MenuFrame(){
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		textarea=new JTextArea(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		JScrollPane scroll=new JScrollPane(textarea);
		JPanel jp=new JPanel();
		jp.add(scroll);
		this.add(jp);
		
		JMenu fileMenu=new JMenu("file");
		fileMenu.add(new TestAction("new"));
		
		JMenuItem openItem=fileMenu.add(new TestAction("open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		
		fileMenu.addSeparator();
		saveAction=new TestAction("save");
		JMenuItem saveItem=fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		saveAsAction= new TestAction("save as");
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		
		fileMenu.add(new AbstractAction("Exit"){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		readonlyItem=new JCheckBoxMenuItem("read-only");
		readonlyItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean saveOk=!readonlyItem.isSelected();
				saveAction.setEnabled(saveOk);
				saveAsAction.setEnabled(saveOk);
			}
		});
		
		ButtonGroup group=new ButtonGroup();
		JRadioButtonMenuItem insertItem=new JRadioButtonMenuItem("insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem=new JRadioButtonMenuItem("overtype");
		
		group.add(insertItem);
		group.add(overtypeItem);
		
		Action cutAction=new TestAction("cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction=new TestAction("copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction=new TestAction("paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
		
		JMenu editMenu=new JMenu("edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		JMenu optionMenu=new JMenu("options");
		
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);
		
		editMenu.addSeparator();
		editMenu.add(optionMenu);
		
		
		JMenu helpMenu=new JMenu("help");
		helpMenu.setMnemonic('H');
		
		JMenuItem indexItem=new JMenuItem("index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
		
		Action aboutAction=new TestAction("about");
		aboutAction.putValue(Action.MNEMONIC_KEY,new Integer('A'));
		helpMenu.add(aboutAction);
		
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		popup=new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		//jp.setComponentPopupMenu(popup);
		
	//	jp.addMouseListener(new MouseAdapter(){});

		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new MenuFrame();

	}

}
