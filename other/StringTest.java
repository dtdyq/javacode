package other;
//∏Ò ΩªØ£∫
//Formatter   String.format()
import java.util.*;
public class StringTest{
	private String name;
	private Formatter f;
	public StringTest(String name,Formatter f){
		this.name=name;
		this.f=f;
	}
	public void move(int x,int y){
		f.format("%s is at(%d,%d)\n",name,x,y);
	}
	public static void charTest(){
		String str="abcdefg";
		 char[] ch=str.toCharArray();
		 for(int i=0;i<ch.length;i++){
		 	System.out.print(ch[i]+"°°");
		 }
	}
	public static void FormatterTest(){
		@SuppressWarnings("resource")
		Formatter ff=new Formatter(System.out);
		System.out.println(ff.locale());
		
		ff.format("%h\n",0x7837);
		ff.format("%x\n",0x7837);
		ff.format("%b\n",0);
	}
	public static void main(String[] args){
		FormatterTest();
		
		StringTest st=new StringTest("String",new Formatter(System.out));
		st.move(2,3);

		System.out.println(String.format("%20s\n", "ncfiweug"));
		
		byte[] b=new byte[1024];
		for(int i=0;i<1024;i++){
				b[i]=(byte)(Math.random()*127);
		}
		System.out.println(Hex.format(b));
	}
}
class Hex{
	public static String format(byte[] data){
		StringBuilder result=new StringBuilder();
		int n=0;
		for(byte b:data){
			if(n%16==0){
				result.append(String.format("\n%05x: ", n));
			}
			result.append(String.format("%02x ", b));
			n++;
		}
		result.append("\n");
		return result.toString();
	}
}

