package other;

import java.util.*;
public class SetReverse {

	public static void main(String[] args) {
		TreeSet<String> set=new TreeSet<>();
		
		set.add("erefer");
		set.add("hdufefg");
		set.add("furgiru");
		set.add("rjhyjhy");
		set.add("frotet");
		set.add("qeiwf");
		
		Iterator<String> i=set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		System.out.println("-----------------------------");
		TreeSet<String> newset=new TreeSet<>(Collections.reverseOrder());
// 		TreeSet<String> newset=new TreeSet<>(new Comparator<String>(){
//			public int compare(String str1,String str2){
//				return -str1.compareTo(str2);
//			}
//		});
		
		newset.add("erefer");
		newset.add("hdufefg");
		newset.add("furgiru");
		newset.add("rjhyjhy");
		newset.add("frotet");
		newset.add("qeiwf");
		
		Iterator<String> newi=newset.iterator();
		while(newi.hasNext()){
			System.out.println(newi.next());
		}
	}

}
class StrCmp implements Comparator<String>{
//	public int compare(String str1,String str2){
//		return str2.compareTo(str1);
//	}
	public int compare(String str1,String  str2){
		return -str1.compareTo(str2);
	}
}





