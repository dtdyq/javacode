package thread;

public class YieldTest implements Runnable{

	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("yield--->"+i);
		}
	}
	
	public static void main(String[] args) {
		YieldTest yt=new YieldTest();
		Thread t=new Thread(yt);
		t.start();
		for(int i=0;i<1000;i++){
			if(i%50==0){
				Thread.yield();
			}
			System.out.println("main--->"+i);
		}

	}

}
