package string;

import java.io.PrintStream;

public class Immutable {
	static String upcase(String s){
		return s.toUpperCase();
	}
	public static void main(String[] args){
		String s1="howday";
		String s2=s1.toUpperCase();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(Immutable.upcase(s1));
		
		
		String s="abcdefg";
		String ss=s;
		ss+="---";
		System.out.println("s==>"+s);
		System.out.println("ss==>"+ss);
		
		
		StringBuilder sb=new StringBuilder();
		sb.append(s);
		sb.append("---");
		System.out.println("s==>"+s);
		System.out.println("sb==>"+sb.toString());
		
		concatenation();
		
		StringBuilderTest();
		
		recursionTest();
		
		StringTest();
		
		formaterTest();
	}
	static void concatenation(){
		long t1=System.currentTimeMillis();
		String s1="";
		for(int i=0;i<10000;i++){
			//s1+="abcdefg";
			s1+=1;
		}
		System.out.println(System.currentTimeMillis()-t1);
		
		long t2=System.currentTimeMillis();
		StringBuilder s2=new StringBuilder();
		for(int i=0;i<10000;i++){
			//s2.append("abcdefg");
			s2.append(i);
		}
		System.out.println(System.currentTimeMillis()-t2);
	}
	
	static void StringBuilderTest(){
		StringBuilder s=new StringBuilder();
		s.append("abcdefg");
		s.append("hijklmn");
		s.delete(0, 3);
		System.out.println(s.toString());
		s.reverse();
		System.out.println(s.toString());
	}
	static void recursionTest(){
		System.out.println(new InfiniteRecursion());
	}
	static void StringTest(){
		String s="abcdefg";
		byte[] b=s.getBytes();
		for(byte i:b)
			System.out.println(i);
		char[] c=new char[7];
		s.getChars(0, 7, c, 0);
		for(char r:c){
			System.out.println("char===>"+r);
		}
		
		String ss=s.concat(s);
		System.out.println(ss);
		
		String sss=String.valueOf(true);
		String s4=String.valueOf(99);
		System.out.println(sss);
		System.out.println(s4);
		
		String s5=s.intern();
		System.out.println(s5);
		System.out.println(s==s5);
	}
	static void formaterTest(){
		PrintStream f=System.out;
		f.format("%d %f %s", 23,23.45,"aaa");
	}
}
class InfiniteRecursion {
	//当打印类自身时应该用super.toString()如果使用this会造成递归最终异常：
//	public String toString(){
//		return "address: "+this+"\n";
//	}
	public String toString(){
		return "address: "+super.toString();
	}
}