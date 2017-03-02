package other;

public class DoubleArrayTest {
	 public static boolean Find(int target, int [][] array) {
		 boolean flag=false;
		 for(int i=0;i<array.length;i++){
			 for(int j=0;j<array[i].length;j++){
				 if(array[i][j]==target){
					 flag=true;
				 }
			 }
		 }
		 return flag;
	 }
	 public static void main(String[] args){
		 int a[][]={{1,2,3},{4,5,6},{7,8,9}};
		 System.out.println(DoubleArrayTest.Find(5, a));
	 }
}
