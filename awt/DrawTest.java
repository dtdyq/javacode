package awt;
import java.awt.*;
import java.util.Random;
public class DrawTest {
	private Frame f=new Frame("test");
	private final String OVAL_SHAPE="oval";
	private final String RECT_SHAPE="rect";
	
	private Button b1=new Button("drawrect");
	private Button b2=new Button("drawoval");
	private myCanvas drawArea =new myCanvas();
	private String shape="";
	public void init(){
		Panel p=new Panel();
		b1.addActionListener(E->{
			shape=RECT_SHAPE;
			drawArea.repaint();
		});
		b2.addActionListener(e->{
			shape =OVAL_SHAPE;
			drawArea.repaint();
		});
		p.add(b1);
		p.add(b2);
		drawArea.setPreferredSize(new Dimension(300,300));
		f.add(drawArea);
		f.add(p,"South");
		f.pack();
		f.setVisible(true);
	}
	class myCanvas extends Canvas{

		public void paint(Graphics g){
			Random rand=new Random();
			if(shape.equals(RECT_SHAPE)){
				g.setColor(new Color(220,100,80));
				g.drawRect(rand.nextInt(250), rand.nextInt(250), rand.nextInt(80), rand.nextInt(80));
			}
			if(shape.equals(OVAL_SHAPE)){
				g.setColor(new Color(200,70,220));
				g.drawOval(rand.nextInt(250), rand.nextInt(250),rand.nextInt(80), rand.nextInt(80));
			}
		}
		
		private static final long serialVersionUID = 1L;
		
	}
	public static void main(String[] args) {
		
		new DrawTest().init();

	}
	
}
