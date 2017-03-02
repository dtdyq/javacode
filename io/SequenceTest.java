package io;
/**
 * SequenceInputStream:
 * 合并流：将多个输入流依次读入
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceTest {
	public static void main(String[] args) throws IOException{
		Vector<FileInputStream> v=new Vector<>();
		v.add(new FileInputStream("D:/CODE/JAVA/DEFAULT/1.txt"));
		v.add(new FileInputStream("D:/CODE/JAVA/DEFAULT/2.txt"));
		v.add(new FileInputStream("D:/CODE/JAVA/DEFAULT/3.txt"));
		Enumeration<FileInputStream> e=v.elements();
		SequenceInputStream si=new SequenceInputStream(e);
		byte[] b=new byte[1024];
		int k=0;
		while((k=si.read(b))!=-1){
			System.out.println(new String(b,0,k));
		}
		si.close();
	}
}
