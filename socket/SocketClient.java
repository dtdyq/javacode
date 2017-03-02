package socket;
import java.io.*;
import java.net.*;
public class SocketClient {

	public static void main(String[] args) {
		
		InputStream in=null;
		OutputStream out=null;
		try{
			Socket socket=new Socket("localhost",9999);
			in=socket.getInputStream();
			out=socket.getOutputStream();
			DataInputStream dis=new DataInputStream(in);
			DataOutputStream dos=new DataOutputStream(out);
			dos.writeUTF("hello");
			String s=null;
			if((s=dis.readUTF())!=null){
				System.out.println(s);
				
			}
			dos.close();
			dis.close();
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
