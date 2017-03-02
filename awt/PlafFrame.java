package awt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class PlafFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel buttonPanel;
	public PlafFrame(){
		buttonPanel=new JPanel();
		UIManager.LookAndFeelInfo[] infos=UIManager.getInstalledLookAndFeels();
		for(UIManager.LookAndFeelInfo info:infos){
			makeButton(info.getName(),info.getClassName());
			this.add(buttonPanel);
			pack();
			this.setVisible(true);
		}
		
	}
	void makeButton(String name,final String platName){
		JButton button=new JButton(name);
		buttonPanel.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					UIManager.setLookAndFeel(platName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
				}catch(Exception ee){
					ee.printStackTrace();
				}
			}
		});
		
	}
	public static void main(String[] args) {
		
		new PlafFrame(); 

	}

}
