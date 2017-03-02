package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OptionDialogFrame extends JFrame{
	
	private ButtonPanel typePanel;
	private ButtonPanel messagePanel;
	private ButtonPanel messageTypePanel;
	private ButtonPanel optionTypePanel;
	private ButtonPanel optionsPanel;
	private ButtonPanel inputPanel;
	private String messageString="Message";
	private Icon messageIcon=new ImageIcon("blue-ball.gif");
	private Object messageObject=new Date();
	private Component messageComponent=new SampleComponent();
	
	public OptionDialogFrame(){
		JPanel gridPanel=new JPanel();
		gridPanel.setLayout(new GridLayout(2,3));
		typePanel=new ButtonPanel("Type","Message","Confirm","Option","Input");
		messageTypePanel = new ButtonPanel("Message Type","ERROR-MESSAGE","INFORMATION_MESSAGE",
				"WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE");
		messagePanel=new ButtonPanel("Message","String","Icon","Component","Other","Object[]");
		optionTypePanel=new ButtonPanel("Confrim","DEFAULT_OPTION","YES_NO_OPTION",
				"YES_NO_CANEL_OPTION","OK_CANCEL_OPTION");
		optionsPanel=new ButtonPanel("Option","String[]","Icon[]","Object[]");
		inputPanel=new ButtonPanel("Input","text field","Combo box");
		
		gridPanel.add(typePanel);
		gridPanel.add(messageTypePanel);
		gridPanel.add(messagePanel);
		gridPanel.add(optionTypePanel);
		gridPanel.add(optionsPanel);
		gridPanel.add(inputPanel);
		
		JPanel showPanel=new JPanel();
		JButton showButton=new JButton("show");
		showButton.addActionListener((ActionListener) new ShowAction());
		showPanel.add(showButton);
		
		this.add(gridPanel,BorderLayout.CENTER);
		this.add(showPanel, BorderLayout.SOUTH);
		pack();
		this.setVisible(true);
	}
	public Object getMessage(){
		String s=messagePanel.getSelection();
		if(s.equals("String"))	return messageString;
		else if(s.equals("Icon"))	return messageIcon;
		else if(s.equals("Component"))	return messageComponent;
		else if(s.equals("Object[]"))	return new Object[] {
				messageString,messageIcon,messageComponent,messageObject
		};
		else if(s.equals("Other"))	return messageObject;
		else return null;
	}
	
	 public Object[] getOptions()
	   {
	      String s = optionsPanel.getSelection();
	      if (s.equals("String[]")) return new String[] { "Yellow", "Blue", "Red" };
	      else if (s.equals("Icon[]")) return new Icon[] { new ImageIcon("yellow-ball.gif"),
	            new ImageIcon("blue-ball.gif"), new ImageIcon("red-ball.gif") };
	      else if (s.equals("Object[]")) return new Object[] { messageString, messageIcon,
	            messageComponent, messageObject };
	      else return null;
	   }
	 public int getType(ButtonPanel panel)
	   {
	      String s = panel.getSelection();
	      try
	      {
	         return JOptionPane.class.getField(s).getInt(null);
	      }
	      catch (Exception e)
	      {
	         return -1;
	      }
	   }
	 private class ShowAction implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	         if (typePanel.getSelection().equals("Confirm")) JOptionPane.showConfirmDialog(
	               OptionDialogFrame.this, getMessage(), "Title", getType(optionTypePanel),
	               getType(messageTypePanel));
	         else if (typePanel.getSelection().equals("Input"))
	         {
	            if (inputPanel.getSelection().equals("Text field")) JOptionPane.showInputDialog(
	                  OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel));
	            else JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Title",
	                  getType(messageTypePanel), null, new String[] { "Yellow", "Blue", "Red" },
	                  "Blue");
	         }
	         else if (typePanel.getSelection().equals("Message")) JOptionPane.showMessageDialog(
	               OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel));
	         else if (typePanel.getSelection().equals("Option")) JOptionPane.showOptionDialog(
	               OptionDialogFrame.this, getMessage(), "Title", getType(optionTypePanel),
	               getType(messageTypePanel), null, getOptions(), getOptions()[0]);
	      }

	   }

	   public static final int DEFAULT_WIDTH = 600;
	   public static final int DEFAULT_HEIGHT = 400;
	
	   class SampleComponent extends JComponent
	   {
	      /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public void paintComponent(Graphics g)
	      {
	         Graphics2D g2 = (Graphics2D) g;
	         Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
	         g2.setPaint(Color.YELLOW);
	         g2.fill(rect);
	         g2.setPaint(Color.BLUE);
	         g2.draw(rect);
	      }
	      public Dimension getPreferredSize()
	      {
	         return new Dimension(10, 10);
	      }
	   }
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		new OptionDialogFrame();

	}

}
