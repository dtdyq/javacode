package other;

import java.util.*;
public class BSTTest{
	public static void main(String[] args){
		test();
	}
	public static void test(){
		List<String> list=new ArrayList<>();
		list.add("ewui");
		list.add("yuwdg");
		list.add("de");
		list.add("dueuf");
		list.add("iouru");

		Collections.sort(list);
		print(list);
		print(bst(list,"ea"));

	}
	public static void print(Object obj){
		System.out.println(obj);
	}
	public static int bst(List<String> list,String str){
		int min,max,mid;
		max=list.size()-1;
		min=0;
		while(min<=max){
			mid=(min+max)/2;
			int temp=str.compareTo(list.get(mid));
			if(temp<0){
				max=mid-1;
			}
			else if(temp>0){
				min=mid+1;
			}
			else{
				return mid;
			}
		}
		print(min);
		return -(min+1);
	}
}