package system;

import java.io.IOException;

/*
 * runtimeû�й��췽��
 * ����ģʽ
 * 
 * */
public class RuntimeTest {
	public static void main(String[] args) throws InterruptedException{
		//exec():ִ�б����ϵĳ���
		Runtime rt=Runtime.getRuntime();
		System.out.println(rt);
		Process p=null;
		try {
			p=rt.exec("E:\\360Downloads\\Sublime Text 3\\sublime_text.exe RuntimeTest.java");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(4000);
		//ɱ���ӽ��̣�
		p.destroy();
	}
}
