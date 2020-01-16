package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoView extends JFrame {
	private int x = 1920;
	private int y = 1080;
	
	public DemoView(){
		JPanel menuPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(x, y);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		
	}
}
