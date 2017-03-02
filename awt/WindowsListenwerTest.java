package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowsListenwerTest {
	private Frame f=new Frame("test");
	private TextArea ta=new TextArea(6,40);
	public void init(){
		f.addWindowListener(new myListener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	/*
	class MyListener implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
			
			ta.append("���ڳ��α���");
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			
			ta.append("�û��رմ���");
			System.exit(0);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			
			ta.append("���ڱ��ɹ��ر�");
			
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			
			ta.append("���ڱ���С��");
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			
			ta.append("���ڱ��ָ�");
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			
			ta.append("���ڱ�����");
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			
			ta.append("����ʧȥ����");
			
		}
		
	}
	*/
	class myListener extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			
			ta.append("�û��رմ���");
			System.exit(0);
			
		}
	}
	public static void main(String[] agrs){
		new WindowsListenwerTest().init();
	}
}














