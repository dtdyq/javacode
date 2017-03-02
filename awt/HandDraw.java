package awt;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.*;

class ImageSelection implements Transferable{

	private Image image;
	public ImageSelection(Image image){
		this.image=image;
	}
	
		
	@Override
	public DataFlavor[] getTransferDataFlavors() {
	
		return new DataFlavor[]{DataFlavor.imageFlavor};
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		
		return flavor.equals(DataFlavor.imageFlavor);
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if(flavor.equals(DataFlavor.imageFlavor)){
			return image;
		}
		else{
		throw new UnsupportedFlavorException(flavor);
		}
	
	}
}
public class HandDraw {
	private Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
	java.util.List<Image> imagelist=new ArrayList<Image>();
	private final int AREA_WIDTH=500;
	private final int AREA_HEIGHT=400;
	private int preX=-1;
	private int preY=-1;
	PopupMenu pop=new PopupMenu();
	MenuItem redItem=new MenuItem("红色");
	MenuItem greenItem=new MenuItem("绿色");
	MenuItem blueItem=new MenuItem("蓝色");
	MenuItem clearItem=new MenuItem("新建");
	
	BufferedImage image=new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	Graphics g=image.getGraphics();
	private Frame f=new Frame("简单手绘程序");
	private DrawCanvas drawArea=new DrawCanvas();
	private Color foreColor=new Color(255,0,0);
	public void init(){
		ActionListener menuListener=e->{
			if(e.getActionCommand().equals("绿色")){
				foreColor=new Color(0,255,0);
			}
			if(e.getActionCommand().equals("红色")){
				foreColor=new Color(255,0,0);
			}
			if(e.getActionCommand().equals("蓝色")){
				foreColor=new Color(0,0,255);
			}
		};
		
		redItem.addActionListener(menuListener);
		greenItem.addActionListener(menuListener);
		blueItem.addActionListener(menuListener);
		clearItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("新建")){
					new HandDraw().init();
				}
				
			}
			
		});
		pop.add(redItem);
		pop.add(blueItem);
		pop.add(greenItem);
		pop.addSeparator();
		pop.add(clearItem);
		
		drawArea.add(pop);
		
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH , AREA_HEIGHT));
		
		drawArea.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				if(preX>0 && preY>0){
					g.setColor(foreColor);
					((Graphics2D) g).setStroke(new BasicStroke(2.0f));
					g.drawLine(preX, preY, e.getX(), e.getY());
				}
				preX=e.getX();
				preY=e.getY();
				drawArea.repaint();
			}
		});
		drawArea.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(e.isPopupTrigger()){
					pop.show(drawArea, e.getX(), e.getY());
				}
				preX=-1;
				preY=-1;
			}
		});
		f.add(drawArea);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		Panel p=new Panel();
		Button copy=new Button("copy");
		Button paste=new Button("paste");
		copy.addActionListener(event->{
			ImageSelection contents=new ImageSelection(image);
			clipboard.setContents(contents, null);
		});
		paste.addActionListener(event->{
			try{
				imagelist.add((Image)clipboard.getData(DataFlavor.imageFlavor));
				drawArea.repaint();
			}catch(Exception e){
				e.printStackTrace();
			}
		});
		p.add(copy);
		p.add(paste);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	class DrawCanvas extends Canvas{
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g){
			g.drawImage(image, 0, 0, null);
		}
	}
	public static void main(String[] args){
		new HandDraw().init();
	}
}
