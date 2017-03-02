package swing;

import javax.swing.Icon;

import java.awt.Dimension;

import javax.swing.*;

public class SplitPaneTest {
	Book[] books = new Book[]{
			new Book("���Java����" , new ImageIcon("ico/java.png")
				, "���ڹ���Java�����ȫ���ͼ��\n���ö���ѧ�û�")
			, new Book("������Java EE��ҵӦ��ʵս" , new ImageIcon("ico/ee.png")
				, "SSH���Ͽ����ľ���ͼ�飬ֵ��ӵ��")
			, new Book("���Android����" , new ImageIcon("ico/android.png")
				, "ȫ�����Androidƽ̨Ӧ�ó���\n�����ĸ�����֪ʶ")
		};
	JFrame jf=new JFrame("test");
	JList<Book> booklist=new JList<Book>(books);
	JLabel bookCover=new JLabel();
	JTextArea bookDesc=new JTextArea();
	public void init(){
		booklist.setPreferredSize(new Dimension(150,300));
		bookCover.setPreferredSize(new Dimension(300,150));
		bookDesc.setPreferredSize(new Dimension(300,150));
		booklist.addListSelectionListener(event->{
			Book book=(Book)booklist.getSelectedValue();
			bookCover.setIcon(book.getIco());
			bookDesc.setText(book.getDesc());
		});
		
		JSplitPane left=new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,bookCover,bookDesc);
		left.setOneTouchExpandable(true);
		left.setDividerSize(10);
		left.resetToPreferredSizes();
		JSplitPane content=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,booklist);
		
		jf.add(content);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		
		new SplitPaneTest().init();

	}

}
class Book
{
	private String name;
	private Icon ico;
	private String desc;

	public Book(){}

	public Book(String name , Icon ico , String desc)
	{
		this.name = name;
		this.ico = ico;
		this.desc = desc;
	}
	// name��setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	// ico��setter��getter����
	public void setIco(Icon ico)
	{
		this.ico = ico;
	}
	public Icon getIco()
	{
		 return this.ico;
	}

	// desc��setter��getter����
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		 return this.desc;
	}
	public String toString()
	{
		return name;
	}
}