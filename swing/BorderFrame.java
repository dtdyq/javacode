package swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class BorderFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel demoPanel;
	private JPanel buttonPanel;
	private ButtonGroup group;
	public BorderFrame(){
		demoPanel=new JPanel();
		buttonPanel=new JPanel();
		group=new ButtonGroup();
		
		addRadioButton("Lowered bevel",BorderFactory.createLoweredBevelBorder());
		addRadioButton("Raised bevel",BorderFactory.createRaisedBevelBorder());
		addRadioButton("Etched bevel",BorderFactory.createEtchedBorder());
		addRadioButton("Line bevel",BorderFactory.createLineBorder(Color.blue));
		addRadioButton("Matte bevel",BorderFactory.createMatteBorder(10,10,10,10,Color.BLUE));
		addRadioButton("Empty bevel",BorderFactory.createEmptyBorder());
		
		this.add(demoPanel);
		this.add(buttonPanel,"South");
		this.setBounds(222, 222, 800, 500);
		this.setVisible(true);
	}
	
	public void addRadioButton(String name,final Border b){
		JRadioButton button=new JRadioButton(name);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				demoPanel.setBorder(b);
			}
		});
		group.add(button);
		buttonPanel.add(button);
		
	}
	public static void main(String[] args) {
		
		new BorderFrame();

	}

}
