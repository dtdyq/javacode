package system;
//System�ࣺ
import java.util.*;
public class systemTest {
	public static void main(String[] args){
		//Properties��HashTable������
		//�ü��������ַ�����û�з��Ͷ���
		
		//�����ϵͳ���Զ�����Ϣ��
		System.setProperty("Mykey","Myvalue");
		Properties pop=System.getProperties();
		for(Object o:pop.keySet()){
			String str=(String)pop.get(o);
			System.out.println(o+"-->"+str);
		}
		//��ȡָ��ϵͳ��Ϣ��
		String s=System.getProperty("os.name");
		System.out.println(s);
		//������ɲ�����������ʱ��̬�ؼ���������Ϣ��
		String v=System.getProperty("h");
		System.out.println(v);
		
	}
}
