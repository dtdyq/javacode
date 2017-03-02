package regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularTest {
	public static void main(String[] args){
		System.out.println("32746^&$".matches("[1-9]*\\W*"));
		Pattern p=Pattern.compile("\\s*(\"[^\"]*\"|[^\\s>]*)\\s*",Pattern.CASE_INSENSITIVE);
		String str="3984http://www.baidu.com2347687";
		Matcher matcher=p.matcher(str);
		
		if(matcher.find()){
			System.out.println(matcher.group());
		}
		System.out.println("3984http://www.baidu.comxv76877687".replaceAll("[a-zA-Z]{1,5}://\\w*\\.\\w*\\.[a-z]{2,3}","---"));
		 
	}
}
