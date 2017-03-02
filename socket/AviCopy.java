package socket;
import java.io.*;
import java.net.*;
public class AviCopy {
	public static void main(String[] args)throws Exception{
		copy("","127.0.0.1","",10005);		
	}
	public static void copy(String src,String ip,String dest,int port) throws Exception{
		new Server(port,dest);
		new Client(ip,src,port);
		
	}
}
class Client
{
	private Socket s=null;
	private String src;
	public Client(String ip,String src,int port)throws Exception{
		s=new Socket(ip,port);
		this.src=src;
		send();
	}
	private void send() throws Exception{
		@SuppressWarnings("resource")
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos=new BufferedOutputStream(s.getOutputStream());
		byte[] b=new byte[1024];
		int len=0;
		while((len=bis.read(b))!=-1){
			bos.write(b,0,len);
		}
	}
}
class Server{
	private ServerSocket ss=null;
	private String dest=null;
	public Server(int port,String dest) throws Exception{
		ss=new ServerSocket(port);
		this.dest=dest;
		rece();
	}
	private void rece() throws Exception{
		Socket s=ss.accept();
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(dest)));
		BufferedReader br=new BufferedReader(
				new InputStreamReader(s.getInputStream())
				);
		String rec=null;
		while((rec=br.readLine())!=null){
			bw.write(rec);
		}
		bw.close();
		br.close();
	}
}

