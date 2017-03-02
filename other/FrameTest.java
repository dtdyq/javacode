package other;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class FrameTest extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FrameTest(){
		init();
	}
	@SuppressWarnings("unchecked")
	private void init(){
		this.setBounds(200, 200, 500, 500);
		@SuppressWarnings("rawtypes")
		JComboBox j=new JComboBox();
		j.addItem(new String("1111"));
		j.addItem(new String("2222"));
		System.out.println(j.getSelectedItem());
		this.add(j,"North");
	}
	public static void main(String[] args){
		new FrameTest().setVisible(true);
		
	}
}
