package thread;


public class ThreadS {
	public static void main(String[] args){
		myThread myt=new myThread(0);
		myThread myi=new myThread(0);
		new Thread(myt).start();
		new Thread(myi).start();
	}
}
class myThread implements Runnable{
	int i;
	public myThread(int i){
		this.i=i;
	}
	public void run(){
		for(;i<10;i++){
			System.out.println(i+"...");
		}
	}
}