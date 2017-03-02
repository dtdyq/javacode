package swing;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class JComboBoxFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel comboPanel;
	private JLabel text;
	private JComboBox<String> echo;
	public JComboBoxFrame(){
		text=new JLabel("you can set the font family");
		text.setFont(new Font("serif",Font.PLAIN,18));
		this.add(text);
		
		comboPanel=new JPanel();
		echo=new JComboBox<>();
		echo.addItem("serif");
		echo.addItem("sansSerif");
		echo.addItem("Monospaced");
		echo.addItem("Dialog");
		comboPanel.add(echo);
		this.add(comboPanel,"South");
		
		echo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				text.setFont(new Font(echo.getItemAt(echo.getSelectedIndex()),Font.PLAIN,18));
				
			}
			
		});
		
		this.setBounds(200, 200, 330, 150);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new JComboBoxFrame();

	}

}
