package io;
/*
 * ��ӡ����
 * printStream
 *   ���캯����
 *   	file����
 *   	�ֽ������
 *   	�ַ���·��
 * printWriter
 *   ���캯����
 *   	file����
 *   	�ֽ������
 *   	�ַ���·��
 *      �ַ������
 * 
 */
import java.io.*;
public class PrintTest {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps=new PrintStream(System.out,true);
		String line=null;
		while((line=br.readLine())!=null){
			ps.println(line);
		}
		ps.write((char)14);
		br.close();
		ps.close();
	}
}






