package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class HandDraw {
	private final int AREA_WIDTH=500;
	private final int AREA_HEIGHT=400;
	private int preX=-1;
	private int preY=-1;
	JPopupMenu pop=new JPopupMenu();
	JMenuItem chooseColor=new JMenuItem("choosecolor");
	BufferedImage image=new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);
	Graphics g=image.getGraphics();
	private JFrame jf=new JFrame("hand--draw");
	private DrawCanvas drawarea=new DrawCanvas();
	private Color foreColor=new Color(255,0,0);
	public void init(){
		chooseColor.addActionListener(ae->{
		//	foreColor=JColorChooser.showDialog(jf, "choose color", foreColor);
			final JColorChooser colorPane=new JColorChooser(foreColor);
			JDialog jd=JColorChooser.createDialog(jf, "choose color", true, colorPane, e->foreColor=colorPane.getColor(), null);
			jd.setVisible(true);
		});
		
		pop.add(chooseColor);
		drawarea.setComponentPopupMenu(pop);
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		drawarea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));
		
		drawarea.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				if(preX>0&&preY>0){
					g.setColor(foreColor);
					g.drawLine(preX, preY, e.getX(), e.getY());
				}
				preX=e.getX();
				preY=e.getY();
				drawarea.repaint();
			}
		});
		
		drawarea.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				preX=-1;
				preY=-1;
			}
		});
		
		jf.add(drawarea);
		jf.pack();
		jf.setVisible(true);
	}
	class DrawCanvas extends JPanel{
	
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			g.drawImage(image, 0, 0, null);
		}
	}
	public static void main(String[] args) {
		new HandDraw().init();

	}

}
