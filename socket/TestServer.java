package socket;
import java.io.*;
import java.net.*;
public class TestServer {

	public static void main(String[] args) {
		try{
			@SuppressWarnings("resource")
			ServerSocket ss=new ServerSocket(8888);
			while(true){
				Socket k=ss.accept();
				OutputStream os=k.getOutputStream();
				DataOutputStream dos=new DataOutputStream(os);
				dos.writeUTF("Hello,"+k.getInetAddress()+"port#"+k.getPort()+"bye-bye");
				dos.close();
				k.close();
			}
		}catch(Exception e){
				e.printStackTrace();
			}

	}

}
