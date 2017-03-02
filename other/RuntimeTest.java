package system;

import java.io.IOException;

/*
 * runtime没有构造方法
 * 单例模式
 * 
 * */
public class RuntimeTest {
	public static void main(String[] args) throws InterruptedException{
		//exec():执行本机上的程序：
		Runtime rt=Runtime.getRuntime();
		System.out.println(rt);
		Process p=null;
		try {
			p=rt.exec("E:\\360Downloads\\Sublime Text 3\\sublime_text.exe RuntimeTest.java");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(4000);
		//杀死子进程：
		p.destroy();
	}
}
