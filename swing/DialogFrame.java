package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DialogFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;
	private AboutDialog dialog;
	public DialogFrame(){
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu filemenu=new JMenu("File");
		menuBar.add(filemenu);
		
		JMenuItem aboutItem=new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(dialog==null)
					dialog=new AboutDialog(DialogFrame.this);
					dialog.setVisible(true);
				
			}
			
		});
		filemenu.add(aboutItem);
		JMenuItem exitItem=new JMenuItem("exit");
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		}); 
		filemenu.add(exitItem);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new DialogFrame();

	}

}
