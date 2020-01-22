package View;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/*screen size*/
import java.awt.Toolkit;
import java.awt.Dimension;

public class ShipView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)screenSize.getWidth();
	int height = (int)screenSize.getHeight();
	/*private int x = 1920;
	private int y = 1080;*/
	
	/*test*/
	/*ImageIcon imageIcon = new ImageIcon("./img/imageName.png"); // load the image to a imageIcon
	Image image = imageIcon.getImage(); // transform it 
	Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	imageIcon = new ImageIcon(newimg);  // transform it back*/
	
	private ImageIcon imgShip = new ImageIcon(this.getClass().getResource("/petit-bateau.png"));
	//private ImageIcon imgShip = new ImageIcon(new ImageIcon(this.getClass().getResource("/petit-bateau.png")).getImage().getScaledInstance(441,90, Image.SCALE_DEFAULT));
	//private ImageIcon imgFond = new ImageIcon(this.getClass().getResource("/fond.png"));
	private ImageIcon imgFond = new ImageIcon(new ImageIcon(this.getClass().getResource("/fond.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private JLabel drawShip,background;
	
	public ShipView(){
		/* définit paramêtre d'affichage de la view */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(x, y);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setVisible(true);
		
		/* on place les bateaux */
		drawShip = new JLabel(imgShip);
		drawShip.setBounds(736,530,441,90);
		add(drawShip);
		//a enlever quand ce sera fini
		background = new JLabel("", imgFond, JLabel.CENTER);
		
		/* !!! Quentin !!! pas besoin, puisque l'image fait la taille de l'écran et est placé en 0,0 par défaut */
		//background.setBounds(0,0,x,y);
		add(background);
	}
	
	public final JLabel getShipLabel(){
        return drawShip;
    }
}