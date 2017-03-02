package swing;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class BorderTest {
	private JFrame jf=new JFrame("test");
	public void init(){
		jf.setLayout(new GridLayout(2,4));
		Border bb=BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY);
		jf.add(getPanelWithBorder(bb,"BevelBorder"));
		
		Border lb=BorderFactory.createLineBorder(Color.ORANGE,10);
		jf.add(getPanelWithBorder(lb,"LineBorder测试"));
		
		Border eb=BorderFactory.createEmptyBorder(20,10,5,30);
		jf.add(getPanelWithBorder(eb,"Emptyborder"));
		
		Border etb=BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.RED,Color.GREEN);
		jf.add(getPanelWithBorder(etb,"EtchedBorder"));
		
		TitledBorder tb=BorderFactory.createTitledBorder(lb,"test",TitledBorder.LEFT,TitledBorder.TOP,new Font("StSong",Font.BOLD,18),Color.BLUE);
		jf.add(getPanelWithBorder(tb,"TitledBorder"));
		
		MatteBorder mb=new MatteBorder(20,5,10,30,Color.GREEN);
		jf.add(getPanelWithBorder(mb,"matteBorder"));
		
		CompoundBorder cb=new CompoundBorder(new LineBorder(Color.RED,8),tb);
		jf.add(getPanelWithBorder(cb,"compoundBorder"));
		jf.pack();
		jf.setVisible(true);
	}
	public JPanel getPanelWithBorder(Border b,String BorderName){
		JPanel p=new JPanel();
		p.add(new JLabel(BorderName));
		p.setBorder(b);
		return p;
	}
	public static void main(String[] args) {
		
		new BorderTest().init();

	}

}
