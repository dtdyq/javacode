package other;

import java.util.*;
public class SortTest{
	public static void main(String[] args){
		sortTest();
		maxT();
		SearchTest();
	}
	public static void SearchTest(){
		List<String> list=new ArrayList<>();
		list.add("uewru");
		list.add("deuer");
		list.add("s");
		list.add("feiu");

		int index=Collections.binarySearch(list,"s");
		sop("index= "+index);
	}
	public static void maxT(){
		List<String> list=new ArrayList<>();
		list.add("dywud");
		list.add("wre");
		list.add("fff");
		list.add("ewet");
		list.add("aaa");

		sop(Collections.max(list));
		sop(Collections.max(list,new strLenCmp()));
	}
	public static void sortTest(){
		List<String> list=new ArrayList<>();
		list.add("dywud");
		list.add("wre");
		list.add("fff");
		list.add("ewet");
		list.add("aaa");

		sop(list);
		Collections.sort(list,new strLenCmp());
		sop(list);
	}
	public static void sop(Object obj){
		System.out.println(obj);
	}
}
class strLenCmp implements Comparator<String>{
	public int compare(String str1,String str2){
		if(str1.length()<str2.length()){
			return -1;
		}
		else
			if(str1.length()>str2.length()){
			return 1;
		}
		else{
			return str1.compareTo(str2);
		}
	}
}