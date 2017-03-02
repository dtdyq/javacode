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
			
			ta.append("窗口初次被打开");
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			
			ta.append("用户关闭窗口");
			System.exit(0);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			
			ta.append("窗口被成功关闭");
			
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			
			ta.append("窗口被最小化");
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			
			ta.append("窗口被恢复");
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			
			ta.append("窗口被激活");
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			
			ta.append("窗口失去焦点");
			
		}
		
	}
	*/
	class myListener extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			
			ta.append("用户关闭窗口");
			System.exit(0);
			
		}
	}
	public static void main(String[] agrs){
		new WindowsListenwerTest().init();
	}
}














