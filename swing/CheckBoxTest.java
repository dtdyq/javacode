package swing;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CheckBoxTest extends JFrame{

	private JLabel text;
	private JCheckBox bold;
	private JCheckBox italic;
	private JPanel setCheckbox;
	public CheckBoxTest(){
		text=new JLabel("this text can be setted the font");
		this.add(text);
		
		bold=new JCheckBox("bold");
		bold.addActionListener(new Listener());
		italic=new JCheckBox("italic");
		italic.addActionListener(new Listener());
		setCheckbox=new JPanel();
		setCheckbox.setLayout(new FlowLayout(FlowLayout.CENTER));
		setCheckbox.add(bold);
		setCheckbox.add(italic);
		
		this.add(setCheckbox,"South");
		this.setBounds(200, 200, 300, 200);
		this.setVisible(true);
		
		
	}
	private static final long serialVersionUID = 1L;
	
	private class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int mode=0;
			if(bold.isSelected())	mode+=Font.BOLD;
			if(italic.isSelected())	mode+=Font.ITALIC;
			text.setFont(new Font("serif",mode,14));
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new CheckBoxTest();

	}

}
