package awt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EventMlultiListener {
	private Frame f=new Frame("test");
	private TextArea ta=new TextArea(6,40);
	private Button b1=new Button("bt1");
	private Button b2=new Button("bt2");
	public void init(){
		firstListener f1=new firstListener();
		secondListener f2=new secondListener();
		b1.addActionListener(f1);
		b1.addActionListener(f2);
		b2.addActionListener(f1);
		f.add(ta);
		Panel p=new Panel();
		p.add(b1);
		p.add(b2);
		f.add(p,"South");
		f.pack();
		f.setVisible(true);
	}
	class firstListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			ta.append("第一个事件监听器被触发，监听的事件源是："+e.getActionCommand()+"\n");
			
		}
		
	}
	class secondListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ta.append("第二个事件监听器被触发，监听的事件源是；"+e.getActionCommand()+"\n");
			
		}
		
	}
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				EventMlultiListener eml=new EventMlultiListener();
				eml.init();
			}
		});
	}
}





