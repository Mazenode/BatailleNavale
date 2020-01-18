package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DemoView extends JFrame {
	private int x = 1920;
	private int y = 1080;
	private ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/demo_background1.png"));
	private ImageIcon imgText = new ImageIcon(this.getClass().getResource("/text1.png"));
	private JLabel background, text;
	
	public DemoView(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x, y);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);
		text = new JLabel(imgText);
		text.setBounds(0,350,x,y);
		add(text);
		
		background = new JLabel(imgBackground, JLabel.CENTER);
		background.setBounds(0,0,x,y);
		add(background);
		
		//menu.setContentPane(this.getPanel());
        this.revalidate();
	

	}
	
	public final JLabel getBackgroundLabel(){
        return background;
    }
	
	public final JLabel getTextLabel(){
        return text;
    }
	
}