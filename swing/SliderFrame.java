package swing;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class SliderFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;
	
	public SliderFrame(){
		sliderPanel=new JPanel();
		sliderPanel.setLayout(new GridBagLayout());
		
		listener =new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				
				JSlider source=(JSlider) e.getSource();
				textField.setText(""+source.getValue());
				
			}
			
		};
		//first:
		JSlider slider=new JSlider();
		addSlider(slider,"Plain");
		//second:
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"ticks");
		//third:
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"Snap to ticks");
		//fourth:
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(false);
		addSlider(slider,"no track");
		//fifth:
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider,"inverted");
		//sixth:
		slider=new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider,"labels");
		//seventh:
		slider=new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		Dictionary<Integer,Component> labelTable=new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		slider.setLabelTable(labelTable);
		addSlider(slider,"Custom labels");
		
		//eighth:
		slider=new JSlider(0,1000,50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(200);
		//slider.setMinorTickSpacing(10);
		slider.setSnapToTicks(true);
		addSlider(slider,"min-max");
		
		
		
		textField=new JTextField();
		this.add(textField,"South");
		this.add(sliderPanel);
		this.setLocation(100, 50);
		this.setSize(500, 600);
		this.setVisible(true);
	}
	public void addSlider(JSlider s,String desc){
		s.addChangeListener(listener);
		JPanel panel=new JPanel();
		panel.add(s);
		panel.add(new JLabel(desc));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridy=sliderPanel.getComponentCount();
		gbc.anchor=GridBagConstraints.WEST;
		sliderPanel.add(panel,gbc);
	}
	public static void main(String[] args) {
		
		new SliderFrame();
		
	}

}
