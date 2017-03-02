package awt;
import javax.swing.*;
public class MouseFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public MouseFrame(){
		this.add(new MouseComponent());
		setLocation(200,200);
		setSize(600,500);
		setVisible(true);
	}
	public static void main(String[] args){
		new MouseFrame();
	}
}
