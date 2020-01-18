package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DemoView extends JFrame {
	private int x = 1920;
	private int y = 1080;
	private ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/demo_background1.png"));
	private JLabel background;
	
	public DemoView(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x, y);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);

		
		background = new JLabel(imgBackground, JLabel.CENTER);
		background.setBounds(0,0,x,y);
		add(background);


	}
	
	public final JLabel getBackgroundLabel(){
        return background;
    }

	
}