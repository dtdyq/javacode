package awt;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MenuTest {
	private Frame f=new Frame("test");
	private MenuBar mb=new MenuBar();
	Menu file=new Menu("file");
	Menu edit=new Menu("edit");
	
	MenuItem newItem=new MenuItem("�½�");
	MenuItem saveItem=new MenuItem("����");
	MenuItem exitItem=new MenuItem("exit",new MenuShortcut(KeyEvent.VK_X));
	
	CheckboxMenuItem autowrap=new CheckboxMenuItem("�Զ�����");
	MenuItem copyItem=new MenuItem("����");
	MenuItem pasteItem=new MenuItem("ճ��");
	Menu format = new Menu("��ʽ");
	MenuItem commentItem=new MenuItem("ע��",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem cancelItem=new MenuItem("ȡ��ע��");
	
	PopupMenu pop=new PopupMenu();
	
	private TextArea ta=new TextArea(6,40);
	public void init(){
		ActionListener menuListener=e->{
			String cmd=e.getActionCommand();
			ta.append("����"+cmd+"�˵�\n");
			if(cmd.equals("exit")){
				System.exit(0);
			}
		};
		commentItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		format.add(commentItem);
		format.add(cancelItem);
		
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		
		edit.add(autowrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		edit.add(new MenuItem("-"));
		edit.add(format);
		
		pop.add(autowrap);
		pop.addSeparator();
		pop.add(copyItem);
		pop.add(pasteItem);
		pop.add(new MenuItem("-"));
		pop.add(format);
		
		
		mb.add(file);
		mb.add(edit);
		f.setMenuBar(mb);
		f.add(ta,"North");
		
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		Panel p=new Panel();
		p.add(new Label("this is a popupMenu"));
		//p.setPreferredSize(new Dimension(300,160));
		p.add(pop);
		p.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(e.isPopupTrigger()){
					pop.show(p, e.getX(), e.getY());
				}
			}
		});
		f.add(p);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args){
		new MenuTest().init();
	}
}
