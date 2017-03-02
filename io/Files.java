package io;
/**
 * 
 * @author dtdyq
 *File
 *  用来将文件和文件夹封装成类
 *  方便对文件和文件属性进行操作和使用
 *  是文件和文件名的抽象表示形式
 *File类常用方法：
 *  创建    boolean createNewFile
 *  删除
 *  判断
 *  获取信息
 */
import java.io.*;
public class Files {
	static void fileType(){
		//file的不同表示形式：
		File f1=new File("././test.txt");
		
		File f2=new File("././","test.txt");
		
		File f=new File("././");
		File f3=new File(f,"test.txt");
		
		File f4=new File("."+File.separator+"."+File.separator+"test.txt");
		
		pr(f1);
		pr(f2);
		pr(f3);
		pr(f4);
	}
	static void fileCreate(){
		File f=new File("././file.txt");
		try {
			pr(f.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			pr(File.createTempFile("viue", ".temp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void fileDelete(){
		File f=new File("././file.txt");
		pr(f.delete());
		f.deleteOnExit();
	}
	static void  fileTest(){
		File f=new File("././dddd.txt");
		pr("canExecute； "+f.canExecute());
		pr("canRead: "+f.canRead());
		pr("canWrite: "+f.canWrite());
		pr("exists: "+f.exists());
		
		File ff=new File("././test.txt");
		pr("canExecute； "+ff.canExecute());
		pr("canRead； "+ff.canRead());
		pr("canWrite: "+ff.canWrite());
		pr("exists: "+ff.exists());
	}
	static void fileMessage(){
		//创建一级文件夹：
		File f=new File("././newDirectory");
		f.mkdir();
		//创建多级文件夹：
		File  fff=new File("././newd/newdd");
		fff.mkdirs();
		//注意：对一个文件是否是文件或目录判断之前，首先要判断该文件或目录是否存在
		pr(f.isDirectory());
		pr(f.isFile());
		
		File ff=new File("././ttttt.txt");
		pr(ff.getAbsolutePath());
		pr(ff.getAbsoluteFile());
	}
	static void fileName(){
		File f=new File("././2.txt");
		pr(f.length());
		f.renameTo(new File("././3.txt"));
	}
	static void fileList(){
		File f=new File("D:/");
		//f必须是一个目录，而且必须存在
		String[] str=f.list(new FileFilter());
		
		for(String s:str){
			pr(s);
		}
	}
	static void pr(Object o){
		System.out.println(o);
	}
	
	public static void main(String[] args){
//		fileType();
//	    fileCreate();
//	    fileDelete();
//	    fileTest();
//	    fileMessage();
//	    fileName();
//	    File[] f=File.listRoots();
//	    for(File i:f){
//	    	pr(i);
//	    	pr(i.length());
//	    }
		fileList();
	}
}
class FileFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		if(name.endsWith(".java")){
			return true;
		}
		return false;
	}

}










