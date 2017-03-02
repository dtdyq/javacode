package io;

import java.io.File;

public class copyDir {
	public static void CopyDir(String s1,String s2){
		File src=new File(s1);
		File dest=new File(s2);
		CopyDir(src,dest);
	}
	public static void CopyDir(File src,File dest){
		if(src.isDirectory()){
			dest=new File("D:/CODE/JAVA/test/mkdir",src.getName());
		}
		DirCopy(src,dest);
	}
	public static void DirCopy(File c,File d){
		if(c.isFile()){
			FileCopy.copy(c.toString(), d.toString());
		}
		else if(c.isDirectory()){
			d.mkdirs();
			for(File sub:c.listFiles()){
				DirCopy(sub,new File(d,sub.getName()));
			}
		}
	}
	public static void main(String[] args) {
		String src="D:/CODE/JAVA/test/mkdirs";
		String dest="D:/CODE/JAVA/test/mkdir";
		CopyDir(src,dest);
	}

}
