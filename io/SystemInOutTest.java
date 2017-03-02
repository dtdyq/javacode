package io;
/*
 * System.setIn(InputStream)  System.setOut(PrintStream)   :改变输入输出设备
 * 
 */
import java.io.*;
public class SystemInOutTest {
	public static void main(String[] args) throws FileNotFoundException{
		//输入重定向
		System.setIn(new FileInputStream("D:/CODE/JAVA/DEFAULT/2.txt"));
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		//不知道为什么会出现空指针异常
		System.setOut(new PrintStream("D:/CODE/JAVA/DEFAULT/test.txt"));
		try{
		String str=br.readLine();
		bw.write(str);
		}catch(IOException e){
			System.out.println(e.toString());
		}finally{
			try{
				br.close();
				bw.close();
			}catch(IOException e){
				System.out.println("close error");
			}
		}
		
	}
}
