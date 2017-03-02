package io;
/**
 * 
 * @author dtdyq
 *File
 *  �������ļ����ļ��з�װ����
 *  ������ļ����ļ����Խ��в�����ʹ��
 *  ���ļ����ļ����ĳ����ʾ��ʽ
 *File�ೣ�÷�����
 *  ����    boolean createNewFile
 *  ɾ��
 *  �ж�
 *  ��ȡ��Ϣ
 */
import java.io.*;
public class Files {
	static void fileType(){
		//file�Ĳ�ͬ��ʾ��ʽ��
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
		pr("canExecute�� "+f.canExecute());
		pr("canRead: "+f.canRead());
		pr("canWrite: "+f.canWrite());
		pr("exists: "+f.exists());
		
		File ff=new File("././test.txt");
		pr("canExecute�� "+ff.canExecute());
		pr("canRead�� "+ff.canRead());
		pr("canWrite: "+ff.canWrite());
		pr("exists: "+ff.exists());
	}
	static void fileMessage(){
		//����һ���ļ��У�
		File f=new File("././newDirectory");
		f.mkdir();
		//�����༶�ļ��У�
		File  fff=new File("././newd/newdd");
		fff.mkdirs();
		//ע�⣺��һ���ļ��Ƿ����ļ���Ŀ¼�ж�֮ǰ������Ҫ�жϸ��ļ���Ŀ¼�Ƿ����
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
		//f������һ��Ŀ¼�����ұ������
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










