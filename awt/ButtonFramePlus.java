package awt;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;
public class ButtonFramePlus extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel jp=new JPanel();
	private static final int DEFAULT_WIDTH=300;
	private static final int DEFAULT_HEIGHT=200;
	public ButtonFramePlus(){
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		Action yellowAction=new ColorAction("<html><p style='color:yellow'>YELLOW</p></html>",new ImageIcon("yellow-ball.gif"),Color.yellow);
		Action redAction=new ColorAction("<html><p style='color:red'>RED</p></html>",new ImageIcon("red-ball.gif"),Color.RED);
		Action blueAction=new ColorAction("<html><p style='color:blue'>BLUE</p></html>",new ImageIcon("blue-ball.gif"),Color.BLUE);
		Action greenAction=new ColorAction("<html><p style='color:green'>GREEN</p></html>",new ImageIcon("blue-ball.gif"),Color.GREEN);
		jp.add(new JButton(yellowAction));
		jp.add(new JButton(redAction));
		jp.add(new JButton(blueAction));
		jp.add(new JButton(greenAction));
		
		this.add(jp);
		this.pack();
		this.setVisible(true);
		
		InputMap imap=jp.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl G"), "panel.green");
		ActionMap amap=jp.getActionMap();
		amap.put("panel.yellow",yellowAction);
		amap.put("panel.red",redAction);
		amap.put("panel.blue",blueAction);
		amap.put("panel.green",greenAction);
	}
	public class ColorAction extends AbstractAction{
		private static final long serialVersionUID = 1111L;
		public ColorAction(String name,Icon icon,Color c){
			this.putValue(Action.NAME, name);
			this.putValue(Action.SMALL_ICON, icon);
			this.putValue(Action.SHORT_DESCRIPTION, "set panel color to"+name.toLowerCase());
			this.putValue("color", c);
		}
		public void actionPerformed(ActionEvent event){
			Color c=(Color)getValue("color");
			jp.setBackground(c);
		}
	}
	public static void main(String[] args) {
		
		new ButtonFramePlus();

	}

}
