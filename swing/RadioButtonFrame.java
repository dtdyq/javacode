package swing;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class RadioButtonFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel buttonpanel;
	private ButtonGroup group;
	private JLabel label;
	private static final int DEFAULT_SIZE=20;
	public RadioButtonFrame(){
		label=new JLabel("set the size of text");
		label.setFont(new Font("serif",Font.PLAIN,DEFAULT_SIZE));
		group=new ButtonGroup();
		buttonpanel=new JPanel();
		buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addButton("small",12);
		addButton("medium",20);
		addButton("large",28);
		
		this.add(label);
		this.add(buttonpanel,"South");
		this.setBounds(222, 222, 300, 200);
		this.setVisible(true);
	}
	private void addButton(String name,int size){
		
		boolean selected=size==DEFAULT_SIZE;
		JRadioButton button=new JRadioButton("name",selected);
		group.add(button);
		buttonpanel.add(button);
		
		ActionListener listener=new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				label.setFont(new Font("serif",Font.PLAIN,size));
				
			}
			
		};
		button.addActionListener(listener);
	}
	public static void main(String[] args) {
		
		new RadioButtonFrame();
 
	}

}
