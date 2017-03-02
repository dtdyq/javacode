package thread;

public class ThreadT {
	public static void main(String[] args){
//		new Thread(){
//			public void run(){
//				for(int i=0;i<100;i++){
//					System.out.println(Thread.currentThread().getName()+"-->"+i);
//				}
//			}
//		}.start();
//		new Thread(new Runnable(){
//			public void run(){
//				for(int i=0;i<100;i++){
//					System.out.println(Thread.currentThread().getName()+"-->"+i);
//				}
//			}
//		}){
//			
//		}.start();
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("java-->"+i);
				}
			}
		}){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("hello-->"+i);
				}
			}
		}.start();
	}
}
