package awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MailListener implements ActionListener{

	private TextField mailAddress=null;
	public MailListener(){}
	public MailListener(TextField tf){
		this.mailAddress=tf;
	}
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("程序向"+mailAddress.getText()+"发送邮件...");
		
	}
	
}
public class SendMailer {
	private Frame f=new Frame("test");
	private TextField tf=new TextField(40);
	
	private Button b=new Button("send");
	
	public void init(){
		b.addActionListener(new MailListener(tf));
		f.add(b,"South");
		f.add(tf);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args){
		new SendMailer().init();
	}
}





