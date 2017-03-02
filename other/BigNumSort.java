package other;

import java.util.Arrays;
import java.util.Comparator;

public class BigNumSort {
	public static void bigSort(String[] array){
		int[] arr=new int[array.length];
		for(int i=0;i<array.length;i++){
			arr[i]=array[i].length();
		}
		Arrays.sort(array,new myCom());
		
	}
	public static void main(String[] args){
		String[] test={"fgeri","fhieru","furya","figu","bire"};
		BigNumSort.bigSort(test);
		for(int i=0;i<5;i++){
			System.out.print(test[i]+" ");
		}
	}
}
class myCom implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		return o1.length()>o2.length()?1:-1;
	}
	
}