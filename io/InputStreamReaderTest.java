package io;
/*
 * BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 * InputStreamReader ���ֽ�ת�����ַ��������System.in�����ֽ���
 * Writer out=new BufferedWriter(new OutputStreamWriter(System.out));
 * OutputStreamWriter ���ַ���ת�����ֽ��������System.out���ڱ�׼�ֽ������
 * 
 * ���������ڴӴ��������ֽ���ת��Ϊ�ַ��������ַ�ת��Ϊ�ֽ������������
 * 
 * �������Ļ������ɣ�
 * 1����ȷ����Դ��Ŀ�ģ����������������
 * 		|--Դ��Reader InputStream
 * 		|--Ŀ�ģ�Writer OutputStream
 * 2���������������ַ������ַ���
 * 		|--�ֽ�����InputStream  OutputStream
 * 		|--�ַ�����Reader  Writer
 * 3����ȷҪʹ�õľ������Ķ���
 * 		|Ӳ�̡�����̨������
 * 4���Ƿ���Ҫ���Ч��
 * 		|С���ļ�������ٵĶ�д������Ҫ����Ч������
 * 
 * ���������ʣ�
 * System.in��System.outΪʲô���ֽ����������
 * 
 * 
 * ���������뷽ʽֻ��ת��������ָ��
 * ת�������ֽ������ַ���֮��ת��������
 * �漰���ַ������ת��������
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class InputStreamReaderTest {
	public static void main(String[] args) throws IOException{
		InputStream in=System.in;
		InputStreamReader ir=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(ir);
		OutputStream os=System.out;
		OutputStreamWriter ow=new OutputStreamWriter(os);
		BufferedWriter bw=new BufferedWriter(ow);
		try{
			while(true){
				String str=br.readLine();
				if(str.equals("over")){
					break;
				}
				bw.write(str+"\r\n");
				bw.flush();
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}
		in.close();
		ir.close();
		br.close();
		os.close();
		ow.close();
		bw.close();
	}
}
