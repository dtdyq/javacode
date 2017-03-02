package socket;
import java.io.*;
import java.net.*;
public class TestClient {
	public static void mian(String[] args){
		try{
			Socket sk=new Socket("127.0.0.1",8888);
			InputStream in=sk.getInputStream();
			DataInputStream dis=new DataInputStream(in);
			System.out.println(dis.readUTF());
			dis.close();
			sk.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
