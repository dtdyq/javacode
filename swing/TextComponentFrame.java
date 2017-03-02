package swing;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class TextComponentFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	private JTextField textfield;
	private JPasswordField password;
	private JTextArea textarea;
	public TextComponentFrame(){
		
		textfield=new JTextField(15);
		password=new JPasswordField(15);
		
		northPanel=new JPanel();
		northPanel.setLayout(new GridLayout(2,2,2,2));
		northPanel.add(new JLabel("                        username:"));
		northPanel.add(textfield);
		northPanel.add(new JLabel("                        password:"));
		northPanel.add(password);
		
		centerPanel=new JPanel();
		textarea=new JTextArea(10,30);
		JScrollPane jsp=new JScrollPane(textarea);
		centerPanel.add(jsp);
		
		southPanel=new JPanel();
		JButton jb=new JButton("view");
		southPanel.add(jb);
		
		this.add(northPanel,"North");
		this.add(centerPanel);
		this.add(southPanel,"South");
		
		this.setLocation(200,200);
		this.pack();
		this.setVisible(true);
		
		jb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				textarea.setText("username:  "+textfield.getText()+"\n"+"pasworld:  "+new String(password.getPassword()));
				
			}
			
		});
		
	}
	public static void main(String[] args){
		new TextComponentFrame();
	}
	
}
