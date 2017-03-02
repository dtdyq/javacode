package awt;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;

public class FrameFileDialog {
	Frame f=new Frame("Test");
	FileDialog d1=new FileDialog(f,"select the file which need open",FileDialog.LOAD);
	FileDialog d2=new FileDialog(f,"select a path to save file",FileDialog.SAVE);
	
	Button b1=new Button("open");
	Button b2=new Button("save");
	
	public void init(){
		b1.addActionListener(e->{
			d1.setVisible(true);
			System.out.println(d1.getDirectory()+d1.getFile());
		});
		b2.addActionListener(e->{
			d2.setVisible(true);
			System.out.println(d2.getDirectory()+d2.getFile());
		});
		
		f.add(b1);
		f.add(b2,"South");
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args){
		new FrameFileDialog().init();
	}
}






