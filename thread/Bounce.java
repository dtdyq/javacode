package thread;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
public class Bounce{
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame frame=new BounceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
class BounceFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private ballComponent comp;
	

	public BounceFrame(){
		setTitle("Bounce");

		comp=new ballComponent();
		this.add(comp,BorderLayout.CENTER);
		JPanel buttonPanel=new JPanel();
		this.addButton(buttonPanel,"start",new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addBall();
			}
		});
		this.addButton(buttonPanel,"Close",new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		this.add(buttonPanel,BorderLayout.SOUTH);
		this.pack();
	}
	
	public void addButton(Container c,String title,ActionListener listener){
		JButton button=new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	public void addBall(){
		Ball ball=new Ball();
		comp.add(ball);
		Runnable r=new BallRunnable(ball,comp);
		Thread t=new Thread(r);
		t.start();
	}
}
class BallRunnable implements Runnable{
	private Ball ball;
	private Component comp;
	public static final int STEPS=10000;
	public static final int DELAY=1;
	public BallRunnable(Ball ball ,Component c){
		this.ball=ball;
		this.comp=c;
	}
	@Override
	public void run() {
	
		try{
			for(int i=0;i<=STEPS;i++){
				ball.move(comp.getBounds());
				comp.paint(comp.getGraphics());
				Thread.sleep(DELAY);
			}
			Thread.interrupted();

		}catch(InterruptedException e){
			System.out.println("error");
		}
		
	}
	
}
class Ball{
	private static final int XSIZE=15;
	private static final int YSIZE=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;

	public void move(Rectangle2D bounds){
		x+=dx;
		y+=dy;
		if(x<bounds.getMinX()){
			x=bounds.getMinX();
			dx=-dx;
		}
		if(x+XSIZE>=bounds.getMaxX()){
			x=bounds.getMaxX()-XSIZE;
			dx=-dx;
		}
		if(y<bounds.getMinY()){
			y=bounds.getMinY();
			dy=-dy;
		}
		if(y+YSIZE>=bounds.getMaxY()){
			y=bounds.getMaxY()-YSIZE;
			dy=-dy;
		}
	}
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,XSIZE,YSIZE);
	}
}
class ballComponent extends JPanel{
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH=450;
	private static final int DEFAULT_HEIGHT=350;

	private java.util.List<Ball> balls=new ArrayList<>();
	public synchronized void add(Ball b){
		balls.add(b);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		for(Ball b:balls){
			g2.fill(b.getShape());
		}
	}
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}
