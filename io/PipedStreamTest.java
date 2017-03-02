package io;
/*
 * PipedInputStream 
 * PipedOutputStream
 * 
 * 
 */
import java.io.*;
public class PipedStreamTest {
	public static void main(String[] args) throws IOException, InterruptedException{
		PipedInputStream pis=new PipedInputStream();
		PipedOutputStream pos=new PipedOutputStream();
		pis.connect(pos);
		Read r=new Read(pis);
		Write w=new Write(pos);
		Thread t=new Thread(r);
		t.start();
		new Thread(w).start();
	}
}
class Read implements Runnable{
	private PipedInputStream in;
	public Read(PipedInputStream in){
		this.in=in;
	}
	@Override
	public void run() {
		try{
			Thread.sleep(8000);
			byte[] b=new byte[1024];
			int len=0;
			len=in.read(b);
			System.out.println(new String(b,0,len));
			in.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
class Write implements Runnable{
	private PipedOutputStream out;
	public Write(PipedOutputStream out){
		this.out=out;
	}
	@Override
	public void run(){
		try{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			out.write("fugweufywe".getBytes());
			out.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}
}







