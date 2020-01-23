package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GrilleView extends JFrame {
	private ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/Grille.png"));
	public int x = 1920;
	public int y = 1080;
	
	private JLabel background;
	
	public GrilleView() {
		this.setSize(1920, 1080);
		//this.setUndecorated(true);
		this.setVisible(true);
		
		//background = new JLabel(/*"", imgBackground, JLabel.CENTER*/);
		/*background.setOpaque(false);
		background.setBounds(0,0,x,y);
		add(background);*/
		
		PlateauView plateauView = new PlateauView();
		add(plateauView);
	}
}
