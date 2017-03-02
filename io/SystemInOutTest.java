package io;
/*
 * System.setIn(InputStream)  System.setOut(PrintStream)   :�ı���������豸
 * 
 */
import java.io.*;
public class SystemInOutTest {
	public static void main(String[] args) throws FileNotFoundException{
		//�����ض���
		System.setIn(new FileInputStream("D:/CODE/JAVA/DEFAULT/2.txt"));
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		//��֪��Ϊʲô����ֿ�ָ���쳣
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
