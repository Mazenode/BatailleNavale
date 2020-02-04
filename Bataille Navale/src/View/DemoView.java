package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DemoView extends JFrame {
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)screenSize.getWidth();
	int height = (int)screenSize.getHeight();
	private ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/demo_background1.png"));
	private JLabel background;
	
	public DemoView(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);

		
		background = new JLabel(imgBackground, JLabel.CENTER);
		background.setBounds(0,0,width,height);
		add(background);


	}
	
	public final JLabel getBackgroundLabel(){
        return background;
    }

	
}