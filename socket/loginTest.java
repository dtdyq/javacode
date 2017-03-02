package socket;
import java.util.*;
import java.net.*;
import java.io.*;

public class loginTest {

}

class LoginClient{
	public static void main(String[] args){
		try{
			@SuppressWarnings("resource")
			Socket s=new Socket("127.0.0.1",10013);
			OutputStream os=s.getOutputStream();
			@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
			InputStream is=s.getInputStream();
			for(int i=0;i<3;i++){
				String name=sc.nextLine();
				os.write(name.getBytes());
				byte[] buf=new byte[1024];
				int len=is.read(buf);
				String rece=new String(buf,0,len);
				if(rece.contains("welcome")){
					System.out.println("login successfully");
					break;
				}
				else{
					System.out.println("username wrong,please try again");
				}

			}
		}catch(Exception e){
			throw new RuntimeException("error!");
		}
	}
}
class LoginServer{
	public static void main(String[] agrs)throws Exception{

		@SuppressWarnings("resource")
		ServerSocket ss=new ServerSocket(10013);
		while(true){
			Socket s=ss.accept();
			new Thread(new loginThread(s)).start();
		}
	} 

}
class loginThread implements Runnable{
	private Socket s;
	public loginThread(Socket s){
		this.s=s;
	}
	public void run(){
		try{
			BufferedReader br=null;
			String ip=s.getInetAddress().getHostAddress();
			System.out.println(ip+"..connected");
			for(int i=0;i<3;i++){
				br=new BufferedReader(
					new FileReader(new File("user.txt")));
				InputStream is=s.getInputStream();
				OutputStream os=s.getOutputStream();
				byte[] buf=new byte[1024];
				int len=is.read(buf);
				String name=new String(buf,0,len); 
				boolean flag=false;
				String line=null;
				while((line=br.readLine())!=null){
					if(line.equals(name)){
						flag=true;
						break;
					}
				}
				if(flag){
					System.out.println(ip+name+"...logined");
					os.write(("welcome!"+ip+name).getBytes());
					break;
				}
				else{
					System.out.println(ip+name+"...try to login");
					os.write("username is error".getBytes());
				}

			}
			s.close();
			br.close();
		}catch(Exception e){
			throw new RuntimeException("error");
		}
	}
}