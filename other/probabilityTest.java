package other;

import java.util.HashMap;
import java.util.TreeMap;

public class probabilityTest {
	static boolean rand(double d){
		return Math.random()<d;
	}
	public static void test(){
		int[] a={1,2,3,4,5,6,7,8,9,10};
		HashMap<Integer,Integer> hl=new HashMap<>();
		TreeMap<Integer,Integer> tm=new TreeMap<>();
		int[] k=new int[10];
		for(int i=0;i<10;i++){
			k[i]=0;
		}
		for(int i=1;i<=10;i++){
			hl.put(i, 0);
			tm.put(i, 0);
		}
//		hl.forEach((key,val)->System.out.println(key+" -->"+val));
		long t1=System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			int j=selectNum(a);
			hl.put(j, hl.get(j)+1);
		}
		System.out.println(System.currentTimeMillis()-t1);
		hl.forEach((key,val)->System.out.println(key+" -->"+val));
		long t2=System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			int j=selectNum(a);
			tm.put(j, hl.get(j)+1);
		}
		System.out.println(System.currentTimeMillis()-t2);
		tm.forEach((key,val)->System.out.println(key+" -->"+val));
		long t3=System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			int j=selectNum(a);
			k[j-1]++;
		}
		System.out.println(System.currentTimeMillis()-t3);
		for(int i=0;i<10;i++){
			System.out.println(i+"--> "+k[i]);
		}
	}
	static int selectNum(int[] a){
		int k=a[0];
		for(int i=1;i<a.length;i++){
			if((double)1/(i+1)>Math.random()){
				k=a[i];
			}
			
		}
		return k;
	}
	public static void main(String[] args){
		test();
	}
}
