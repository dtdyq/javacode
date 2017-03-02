package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog{
	private static final long serialVersionUID = 1L;

	public AboutDialog(JFrame owner){
		super(owner,"About DIalog",true);
		this.add(new JLabel("<html><h2><i>core java</i></h2><b style='color:red;background:#222;font-size:16px;'>this is a about dialog</b></html>"));
		JButton ok=new JButton("ok");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
			
		});
		JPanel panel=new JPanel();
		panel.add(ok);
		this.add(panel,"South");
		pack();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
