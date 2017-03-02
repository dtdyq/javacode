package awt;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class ClipBoard {
	private Frame f=new Frame("¼òµ¥µÄ¼ôÇÐ°å³ÌÐò");
	private Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
	Clipboard clipborard=new Clipboard("cb");
	private TextArea jtaCopyTo=new TextArea(5,20);
	private TextArea jtaPaste=new TextArea(5,20);
	
	private Button btCopy=new Button("copy");
	private Button btPaste=new Button("paste");
	public void init(){
		Panel p=new Panel();
		p.add(btCopy);
		p.add(btPaste);
		btCopy.addActionListener(evet->{
			StringSelection contents =new StringSelection(jtaCopyTo.getText());
			clipboard.setContents(contents, null);
		});
		btPaste.addActionListener(event->{
			if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
				try{
					String content=(String)clipboard.getData(DataFlavor.stringFlavor);
					jtaPaste.append(content);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(jtaCopyTo);
		box.add(jtaPaste);
		f.add(box);
		f.add(p,"South");
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		
		new ClipBoard().init();

	}

}
