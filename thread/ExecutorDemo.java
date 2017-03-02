package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ExecutorDemo{
	public static void main(String[] args){
		ExecutorService pool=Executors.newFixedThreadPool(2);
		pool.submit(new myRun());
		pool.submit(new myRun());
		pool.shutdown();
	}
}
class myRun implements Runnable{
	public void run(){
		for(int x=0;x<100;x++){
			System.out.println(Thread.currentThread().getName()+":"+x);
			
		}
	}
}