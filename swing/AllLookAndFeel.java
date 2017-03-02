package swing;

import javax.swing.UIManager;

public class AllLookAndFeel {
	public static void main(String[] args){
		for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
			System.out.println(info.getName()+"--->"+info);
		}
	}
}
