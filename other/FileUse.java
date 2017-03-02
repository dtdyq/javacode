package other;

import java.io.File;
import java.io.IOException;

public class FileUse {
	public static void main(String[] args) throws IOException{
		File f=new File("d:de.txt");
		File newF=new File("d:","kk.txt");
		f.renameTo(newF);
		System.out.println(f);
		System.out.println(f.getName());
	//	reName();
	}
	public static void reName(){
		File f=new File("E:/众妙之门/毕向东/new");
		File[] fs=f.listFiles();
		String dest="E:/众妙之门/毕向东/kkk/";
		for(File ff:fs){
			String newr=ff.getName().substring(1);
			System.out.println(ff.renameTo(new File(dest,newr)));
		
		}
	}
}
