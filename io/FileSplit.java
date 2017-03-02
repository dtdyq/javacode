package io;
import java.io.*;
public class FileSplit{
	private File src=null;
	private File dest=null;
	private RandomAccessFile raf=null;
	private int size=0;
	public FileSplit(){
		this.size=1024;
	}
	public FileSplit(String src,String dest){
		this();
		this.src=new File(src);
		this.dest=new File(dest);
	}
	public FileSplit(String src,String dest,int size){
		this(src,dest);
		this.size=size;
	}
	public FileSplit(File src,File dest){
		this();
		this.src=src;
		this.dest=dest;
	}
	public void Split(){
		if(src.isDirectory()||dest.isFile()){
			System.out.println("Ö¸¶¨Â·¾¶´íÎó");
		}
		else{
			try {
				raf=new	RandomAccessFile(src,"r");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			long fileNum;
			try {
				fileNum = raf.length()/size+1;
				SplitFile(raf,fileNum);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	private void SplitFile(RandomAccessFile source,long num){
		long kNum=0;
		for(int i=0;i<num;i++){
			if(i==size-1){
				try {
					kNum=source.length()-(num-1)*size;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				kNum=size*i;
			}
			
			try {
				source.seek(kNum);
			} catch (IOException e) {
				e.printStackTrace();
			}
			FileOutputStream d;
			try {
				d = new FileOutputStream(new File(dest.getPath()+"/"+src.getName().substring(0,2)+i+".txt"));
				WirteFile(source,d);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	}
	private void WirteFile(RandomAccessFile source,FileOutputStream destion){
		byte[] bt=new byte[size];
		int len=0;
		try {
			len=source.read(bt);
			destion.write(bt,0,len);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			destion.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		FileSplit fs=new FileSplit("D:/CODE/JAVA/DEFAULT/mk.txt","D:/CODE/JAVA/test/split",2048*2);
		fs.Split();
	}
}
