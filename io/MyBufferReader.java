package io;
import java.io.*;
public class MyBufferReader {
	private InputStream in;
	private byte[] b=new byte[1024*4];
	private int pos=0,count=0;
	MyBufferReader(InputStream in){
		this.in=in;
	}
	public int myRead() throws IOException{
		if(count==0){
			count=in.read(b);
			if(count==-1){
				return -1;
			}
			pos=0;
		}
		count--;
		return (int)b[pos++]&0xff;
	}
	public void myClose()throws Exception{
		in.close();
	}
	public static void main(String[] args) throws IOException{
		MyBufferReader mb=new MyBufferReader(new FileInputStream("D:/CODE/JAVA/DEFAULT/test.avi"));
		int k=0;
		while((k=mb.myRead())!=-1){
			System.out.println(k);
		}
	}
}
