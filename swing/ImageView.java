package swing;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
public class ImageView {
	final int PRE_SIZE=100;
	JFrame jf=new JFrame("image looker!");
	JLabel label=new JLabel();
	JMenuBar menuBar=new JMenuBar();
	
	JFileChooser chooser = new JFileChooser(".");
	JLabel accessory=new JLabel();
	ExtensionFileFilter filter=new ExtensionFileFilter();
	public void init(){
		filter.addExtesion("jpg");
		filter.addExtesion("jpeg");
		filter.addExtesion("gif");
		filter.addExtesion("png");
		filter.setDescription("图片文件(*.jpg,*.jpeg,*.gif,*png)");
		
		chooser.addChoosableFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileView(new FileIconView(filter));
		chooser.setAccessory(accessory);
		accessory.setPreferredSize(new Dimension(PRE_SIZE,PRE_SIZE));
		accessory.setBorder(BorderFactory.createEtchedBorder());
		
		chooser.addPropertyChangeListener(event->{
			if(event.getPropertyName()==JFileChooser.SELECTED_FILE_CHANGED_PROPERTY){
				File f=(File)event.getNewValue();
				if(f==null){
					accessory.setIcon(null);
					return;
				}
				ImageIcon icon=new ImageIcon(f.getPath());
				if(icon.getIconWidth()>PRE_SIZE){
					icon=new ImageIcon(icon.getImage().getScaledInstance(PRE_SIZE, -1, Image.SCALE_DEFAULT));
				}
				accessory.setIcon(icon);
			}
		});
		JMenu menu=new JMenu("文件");
		menuBar.add(menu);
		JMenuItem openItem=new JMenuItem("打开");
		menu.add(openItem);
		openItem.addActionListener(event->{
			chooser.setCurrentDirectory(new File("."));
			int result=chooser.showDialog(jf, "打开");
			if(result==JFileChooser.APPROVE_OPTION){
				String name=chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		});
		JMenuItem exitItem =new JMenuItem("exit");
		menu.add(exitItem);
		exitItem.addActionListener(event->System.exit(0));
		jf.setJMenuBar(menuBar);
		jf.add(new JScrollPane(label));
		jf.setBounds(100,100,700,500);
		jf.setVisible(true);
	}
	class ExtensionFileFilter extends FileFilter{
		
		private String description;
		private ArrayList<String> extensions=new ArrayList<>();
		public void addExtesion(String extension){
			if(!extension.startsWith(".")){
				extension="."+extension;
				extensions.add(extension.toLowerCase());
			}
		}
		@Override
		public boolean accept(File f) {
			if(f.isDirectory())		return true;
			String name=f.getName().toLowerCase();
			for(String extension:extensions){
				if(name.endsWith(extension)){
					return true;
				}
			}
			return false;
		}
		public void setDescription(String adescription){
			this.description=adescription;
		}
		@Override
		public String getDescription() {

			return this.description;
		}
		
	}
	public static void main(String[] args) {
		
		new ImageView().init();

	}

}
class FileIconView extends FileView{
	private FileFilter filter;
	public FileIconView(FileFilter filter){
		this.filter=filter;
	}
	public Icon getIcon(File f){
		if(!f.isDirectory()&& filter.accept(f)){
			return new ImageIcon("ico/pict.png");
		}
		else if(f.isDirectory()){
			File[] flist=File.listRoots();
			for(File tmp:flist){
				if(tmp.equals(f)){
					return new ImageIcon("ico/dsk.png");
				}
			}
			return new ImageIcon("ico/folder.png");
		}
		else{
			return null;
		}
	}
}















