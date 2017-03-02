package regularExpression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class htmlSpider {

	public static void main(String[] args) {
		
		BufferedReader br=null;
		try{
			br=new BufferedReader(new FileReader("test.html"));
			String s="";
			while((s=br.readLine())!=null){
				paint(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void paint(String s){
		Pattern p=Pattern.compile("\\w*@[0-9a-zA-Z]*\\.[a-z]*");
		Matcher m=p.matcher(s);
		while(m.find()){
			System.out.println(m.group());
		}
	}

}
