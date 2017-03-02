package swing;
import java.awt.event.ActionEvent;

import javax.swing.*;
public class BindKeyTest {
	
	JFrame jf=new JFrame("test");
	JTextArea jta=new JTextArea(5,30);
	JButton jb=new JButton("send");
	JTextField jtf=new JTextField(15);
	public void init(){
		jf.add(jta);
		JPanel jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jf.add(jp,"South");
		
		Action msgSend=new AbstractAction(){

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				
				jta.setText(jta.getText()+jtf.getText()+"\n");
				jtf.setText("");
				
			}
			
		};
		jb.addActionListener(msgSend);
		jtf.getInputMap().put(KeyStroke.getKeyStroke('V',java.awt.event.InputEvent.CTRL_MASK), "send");
		jtf.getActionMap().put("send", msgSend);
		
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new BindKeyTest().init();

	}

}
