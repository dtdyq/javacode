package thread;

public class JoinTest implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		JoinTest jt=new JoinTest();
		Thread t=new Thread(jt);
		t.start();
		for(int i=0;i<100;i++){
			if(i==40){
				t.join();   //mainÏß³Ì±»×èÈû
			}
			System.out.println("main--->"+i);
		}

	}

	@Override
	public void run() {
		
		for(int i=0;i<100;i++){
			System.out.println("join--->"+i);
		}
		
	}

}
