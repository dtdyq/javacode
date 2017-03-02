package awt;

import javax.swing.JFrame;
import javax.swing.JLabel;
public class HtmlTest {

	public static void main(String[] args) {
		JFrame f=new JFrame("test");
		JLabel l=new JLabel("<html><h2 style='padding-left:80px;'>title</h2><div style='background:"
				+ "red;text-align:center;margin:0 auto;width:200px;height:200px;line-height:40px;font-"
				+ "size:25px;color:purple;'><b>welcome</b><a href='http://www.baidu.com'>link</a><div><html>");
		f.add(l);
		f.pack();
		f.setVisible(true);
	}

}
