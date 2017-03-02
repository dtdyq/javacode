package other;

import java.util.HashMap;
import java.util.Scanner;

public class trigleTest {
	public static void main(String[] agrs){
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		System.out.println("input:\n");
		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		
		String frist=sc.nextLine();
		String[] fristedge=frist.split(" ");
		int flen=0;
		int len1=fristedge.length;
		for(int i=len1-1;i>0;i--){
			flen+=Math.pow(10, len1-i-1)*map.get(fristedge[i]);
		}
		System.out.println(flen);
		
		String second=sc.nextLine();
		String[] secondedge=frist.split(" ");
		int slen=0;
		int len2=secondedge.length;
		for(int i=len2-1;i>0;i--){
			slen+=Math.pow(10, len2-i-1)*map.get(secondedge[i]);
		}
		System.out.println(slen);
		
		String third=sc.nextLine();
		String[] thirdedge=frist.split(" ");
		int tlen=0;
		int len3=fristedge.length;
		for(int i=len3-1;i>0;i--){
			tlen+=Math.pow(10, len3-i-1)*map.get(thirdedge[i]);
		}
		System.out.println(tlen);
		
		if(flen+slen>tlen&&flen+tlen>slen&&slen+tlen>flen){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}
