package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EventTest {
	Frame f=new Frame("test");
	Button b=new Button("ok");
	TextField tf=new TextField(20);
	public void init(){
		b.addActionListener(new OkListener());
		f.add(tf);
		f.add(b,"South");
		f.pack();
		f.setVisible(true);
	}
	class OkListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			System.out.println("user click the button'b'");
			tf.setText("Hello World");
			
		}
	}
	public static void main(String[] args){
		new EventTest().init();
	}
}
