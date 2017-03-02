package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class DirectoryTest {

	public static void main(String[] args) {
		
		String path="D:/CODE/JAVA/test/mkdir";
		File src=new File(path);
		src.mkdir();
		File file=new File("D:/CODE/JAVA/test/mkdirs/newmk");
		file.mkdirs();//连同上级不存在的文件路径一同创建
		System.out.println("=========list=========");
		File f=new File("D:/CODE/JAVA/test");
		if(f.isDirectory()){
			String[] str=f.list();
			for(String s:str){
				System.out.println(s);
			}
		}
		System.out.println("=========listFiles=========");
		if(f.isDirectory()){
			File[] str=f.listFiles();
			for(File s:str){
				System.out.println(s);
			}
		}
		System.out.println("=========fileFilter======");
		File[] temp=f.listFiles(new FilenameFilter(){

			@Override
			public boolean accept(File dir, String name) {
				return new File(dir,name).isFile() && name.endsWith(".java");
			}
			
		});
		for(File fi:temp){
			System.out.println(fi);
		}
		System.out.println("=========allfile==========");
		String strl="D:/CODE/JAVA/test";
		File lib=new File(strl);
		printName(lib);
		System.out.println("===========listRoots=======");
		File[] roots=File.listRoots();
		System.out.println(Arrays.toString(roots));
	}
	public static void printName(File file){
		if(file==null || !file.exists()){
			return;
		}
	
		System.out.println(file.getAbsolutePath());
		
		if(file.isDirectory()){
			for(File f:file.listFiles())
			printName(f);
		}
		
	}

}
