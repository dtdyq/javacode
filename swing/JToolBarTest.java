package swing;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

import javax.swing.*;
public class JToolBarTest {
	
	JFrame jf=new JFrame("JToolBarTest");
	JToolBar jtb=new JToolBar();
	JTextArea jta=new JTextArea(30,50);
	JMenu edit=new JMenu("edit");
	Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
	Action pasteAction=new AbstractAction("paste"){

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
				try{
					String content=(String)clipboard.getData(DataFlavor.stringFlavor);
					jta.replaceRange(content, jta.getSelectionStart(), jta.getSelectionEnd());;
					
				}catch(Exception ee){
					ee.printStackTrace();
				}
			}		
		}
	};
	Action copyAction=new AbstractAction("coyp"){
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			StringSelection contents=new StringSelection(jta.getSelectedText());
			clipboard.setContents(contents, null);
			if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
				pasteAction.setEnabled(true);
			}
			
		}
		
	};
	public void init(){
		pasteAction.setEnabled(false);
		
		JMenuBar jmb=new JMenuBar();
		edit.add(copyAction);
		edit.addSeparator();
		edit.add(pasteAction);
		jmb.add(edit);
		jf.setJMenuBar(jmb);
		
		JButton copybn=new JButton(copyAction);
		JButton pastebn=new JButton(pasteAction);
		JPanel jp=new JPanel();
		jp.add(copybn);
		jp.add(pastebn);
		jf.add(jp,"South");
		
		jtb.setFloatable(true);
		jtb.add(copyAction);
		jtb.addSeparator();
		jtb.add(pasteAction);
		jtb.setMargin(new Insets(5,5,5, 5));
		jtb.setOrientation(1);
		jf.add(jtb,"North");
		jf.add(jta);
		jf.pack();
		jf.setVisible(true);	
	}
	
	public static void main(String[] args) {
		
		new JToolBarTest().init();
		
	}

}
