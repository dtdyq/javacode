package awt;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class EventHander extends WindowAdapter{
	private Frame f=new Frame("test");
	private TextArea ta=new TextArea(6,40);
	public void init(){
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.print("close the window!\n");
				System.exit(0);
			}
		});
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	/*
	public void windowClosing(WindowEvent e){
		System.out.println("close the windows!\n");
		System.exit(0);
	}
	*/
	public static void main(String[] args){
		new EventHander().init();
	}
}
