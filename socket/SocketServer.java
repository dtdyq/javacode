package socket;

import java.io.*;
import java.net.*;
public class SocketServer {

	public static void main(String[] args) {
		
		InputStream is=null;
		OutputStream os=null;
		try{
			ServerSocket ss=new ServerSocket(9999);
			Socket s=ss.accept();
			is=s.getInputStream();
			os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			DataInputStream dis=new DataInputStream(is);
			String str=null;
			if((str=dis.readUTF())!=null){
				System.out.println(str);
				System.out.println("from:"+s.getInetAddress());
				System.out.println("port:"+s.getPort());
			}
			dos.writeUTF("hi,everyone");
			dis.close();
			dos.close();
			s.close();
			ss.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
