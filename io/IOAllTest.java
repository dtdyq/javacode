package io;
/*
 *IO �ܽ᣺
 *�ֽ�����   InputStream  OutputStream
 *      FileInputStream  FileOutputStream   �����ֽ����ļ����ж�ȡ
 *      BufferedInputStream  BufferedOutputStream   �����ڻ�����ֽ�������������ֽ�����Ч��
 *      DataInputStream   DataOutputStream    ���Ի����������ͽ��ж�д
 *      ObjectInputStream  ObjectInputStream    ���Զ���Ҫʵ�����л���transient���εĲ��ܱ�ʵ���������ж�д����
 *      ByteArrayInputStream  ByteArrayOutputStream   �����ֽ�������ж�д���൱�ڿɱ䳤���飬����Ҫ����close����
 *�ַ�����    Reader  Writer  
 *		FileReader  FileReader   �����ַ��ļ����ж�д
 *		BufferedReader  BufferedWriter  �����ڶ��ַ������л��壬������߶�дЧ��
 *		CharArrayReader CharArrayWriter    ���൱�ڿɱ䳤���ַ�������
 *		StringReader  StringWriter    ���ַ�����д
 *
 *�������������  System.in   System.out
 *
 *��ֵ����ʽ��IO��ȡ�ࣺProperties �������������ļ�
 *
 *�������͵������������
 *PipedInputStream��PipedOutputStream��  PipedOutputStream ��PipedInputStream��
 *			�ܵ��������ڽ�������������뵽�ܵ��������ڶ��߳̽��ж�д����ֹ����
 *
 *SequenceInputStream��Enumeration<? extends InputStream> e��   ��
 *			�ϲ���������ͬʱ˳���ȡ���������
 *
 *RandomAccessFile��
 *			�����ȡ�ļ����������ļ�������λ�ý��в���Ͷ�ȡ����
 *
 *PrintStream  PrintWriter ��
 *			��ӡ�������ڸ�Ч�Ľ��д�ӡ��������ָ������ı���
 *
 *LineNumberInputStream   LineNumberReader  
 *			���кŵĵĶ�ȡ�������������к�
 *
 ****ת������InputStreamReader   OutputStreamWriter  
 *			�����ַ������ֽ���֮���ת������ָ���ض��ı�������
 *			������ַ������EncodeTest�С�
 */
public class IOAllTest {
	public static void main(String[] args){
	
		System.out.println(Math.pow(2, 16));
		System.out.println(Character.BYTES);
	}
}
