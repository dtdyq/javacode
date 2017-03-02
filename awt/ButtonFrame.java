package awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel jp=new JPanel();
	private final int WIDTH=200;
	private final int HEIGHT=300;
	
	public ButtonFrame(){
		this.setSize(WIDTH,HEIGHT);
		JButton yellowB=new JButton("<html><b style='color:red'>yellow</b><html>");
		JButton redB=new JButton("red");
		JButton greenB=new JButton("green");
		JButton blueB=new JButton("blue");
		Button b=new Button("awt");
		
		jp.add(greenB);
		jp.add(blueB);
		jp.add(redB);
		jp.add(yellowB);
		jp.add(b);
		ColorListen yellowL=new ColorListen(Color.YELLOW);
		ColorListen redL=new ColorListen(Color.RED);
		ColorListen greenL=new ColorListen(Color.GREEN);
		ColorListen blueL=new ColorListen(Color.BLUE);
		
		greenB.addActionListener(greenL);
		redB.addActionListener(redL);
		blueB.addActionListener(blueL);
		yellowB.addActionListener(yellowL);
		
		this.add(jp);
		this.pack();
		this.setVisible(true);
	}
	class ColorListen implements ActionListener{
		private Color backgroundColor;
		public ColorListen(Color c){
			backgroundColor=c;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			jp.setBackground(backgroundColor);
			
		}
	}
	public static void main(String[] args){
		new ButtonFrame();
	}
	
}










