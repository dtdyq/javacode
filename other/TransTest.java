package other;

import java.util.Random;

public class TransTest{
	
	public static void main(String[] args){
		
		long t2=System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			if(true)
			new stufAll().run();
		}
		System.out.println(System.currentTimeMillis()-t2);
		
		long t1=System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			if(Math.random()>0.55)
				new stufRed().run();
			else{
				new stufBlue().run();
			}
		}
		System.out.println(System.currentTimeMillis()-t1);
		
	}
}
class stufRed{
	int count=0;
	int max=4000;
    int min=3500;
    Random random = new Random();
	int r=random.nextInt(max)%(max-min+1) + min;
	public void run() {
		while(count<r){
			count++;
		}
	}
	
}
class stufBlue{
	int count=0;
	int max=5000;
    int min=4500;
    Random random = new Random();
	int r=random.nextInt(max)%(max-min+1) + min;
	public void run() {
		while(count<5000){
			count++;
		}
	}
	
}
class stufAll{
	int count=0;
	int max=4500;
    int min=4500;
    Random random = new Random();
	int r=random.nextInt(max)%(max-min+1) + min;
	public void run() {
		while(count<4500){
			count++;
		}
	}
	
}