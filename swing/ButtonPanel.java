package swing;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonGroup group;
	public ButtonPanel(String title , String... options){
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),title));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		group=new ButtonGroup();
		for(String option : options){
			JRadioButton b=new JRadioButton(option);
			b.setActionCommand(option);
			this.add(b);
			group.add(b);
			b.setSelected(option==options[0]);
		}
		
	}
	public String getSelection(){
		return group.getSelection().getActionCommand();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
