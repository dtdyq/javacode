package swing;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class FrameTest extends JFrame{
	public FrameTest(){
		init();
	}
	private void init(){
		this.setBounds(200, 300, 400, 500);
//		this.setLayout(null);
		JLabel j=new JLabel("location");
		this.add(j);
//		Font f=new Font("CamingoCode",50,Font.PLAIN);
		j.setFont(new Font("Arial",50,Font.PLAIN));
//		j.setBounds(100, 100, 200, 200);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new FrameTest();
	}
}
