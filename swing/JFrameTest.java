package swing;
import javax.swing.*;
public class JFrameTest extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public void init(){
		this.setBounds(200, 200, 390, 400);
		JMenu jm=new JMenu();
		jm.setText("menu");
		this.add(jm,"North");
		JLabel jl=new JLabel("<html><h3 'style=color:red;'>hhhh</h3></html>");
		this.add(jl,"Center");
		this.setVisible(true);
		
	}
	public static void main(String[] args){
		new JFrameTest().init();
	}
}
