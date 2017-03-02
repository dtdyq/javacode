package swing;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator{
	 public static void main(String[] args)
	   {
	      EventQueue.invokeLater(new Runnable()
	         {
	            public void run()
	            {
	               CalculatorFrame frame = new CalculatorFrame();
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
	            }
	         });
	   }
}
class CalculatorFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	public CalculatorFrame(){
		this.setTitle("calculator");
		CalculatorPanel cp=new CalculatorPanel();
		this.add(cp);
		this.setLocation(300, 300);
		this.setSize(350, 250);
		
	}
	
}
class CalculatorPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastcommend;
	private boolean start;
	public CalculatorPanel(){
		setLayout(new BorderLayout());
		result = 0;
		lastcommend="=";
		start=true;
		display = new JButton("0");
		display.setForeground(new Color(0,0,0));
		display.setBackground(new Color(250,250,250));
		display.setFont(new Font("serif",Font.BOLD,25));
		display.setEnabled(false);
		add(display,BorderLayout.NORTH);
		
		ActionListener insert=new InsertAction();
		ActionListener command=new CommandAction();
		
		panel=new JPanel();
		panel.setLayout(new GridLayout(4,4));
		
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);
		
		addButton("4",insert);
		addButton("5",insert);
		addButton("6",insert);
		addButton("*",command);
		
		addButton("1",insert);
		addButton("2",insert);
		addButton("3",insert);
		addButton("-",command);
		
		addButton("0",insert);
		addButton(".",insert);
		addButton("=",command);
		addButton("+",command);
		add(panel,BorderLayout.CENTER);
	}
	private void addButton(String str,ActionListener al){
		
		JButton jb;
		if(al instanceof CommandAction){
			jb=new JButton("<html><p style='color:red;font-size:18px;'>"+" "+str+" "+"</p><html>");
			jb.setActionCommand(str);
		}
		else{
			jb=new JButton("<html><p style='color:blue;font-size:18px;'>"+" "+str+" "+"</p><html>");
			jb.setActionCommand(str);
		}
		jb.addActionListener(al);
		panel.add(jb);
	}
	 private class InsertAction implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	         String input = event.getActionCommand();
	         if (start)
	         {
	            display.setText("");
	            start = false;
	         }
	         display.setText(display.getText() + input);
	      }
	   }
	private class CommandAction implements ActionListener
	   {
	      public void actionPerformed(ActionEvent event)
	      {
	         String command = event.getActionCommand();

	         if (start)
	         {
	            if (command.equals("-"))
	            {
	               display.setText(command);
	               start = false;
	            }
	            else lastcommend = command;
	         }
	         else
	         {
	            Calculate(Double.parseDouble(display.getText()));
	            lastcommend = command;
	            start = true;
	         }
	      }
	   }
	public void Calculate(double x){
		if (lastcommend.equals("+"))	    result += x;
	    else if (lastcommend.equals("-")) 	result -= x;
	    else if (lastcommend.equals("*")) 	result *= x;
	    else if (lastcommend.equals("/")) 	result /= x;
	    else if (lastcommend.equals("=")) 	result  = x;
	    display.setText("" + result);
	}
}
