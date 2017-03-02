package swing;

import javax.swing.Icon;

import java.awt.Dimension;

import javax.swing.*;

public class SplitPaneTest {
	Book[] books = new Book[]{
			new Book("疯狂Java讲义" , new ImageIcon("ico/java.png")
				, "国内关于Java编程最全面的图书\n看得懂，学得会")
			, new Book("轻量级Java EE企业应用实战" , new ImageIcon("ico/ee.png")
				, "SSH整合开发的经典图书，值得拥有")
			, new Book("疯狂Android讲义" , new ImageIcon("ico/android.png")
				, "全面介绍Android平台应用程序\n开发的各方面知识")
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
	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	// ico的setter和getter方法
	public void setIco(Icon ico)
	{
		this.ico = ico;
	}
	public Icon getIco()
	{
		 return this.ico;
	}

	// desc的setter和getter方法
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