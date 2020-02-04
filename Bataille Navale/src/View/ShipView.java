package View;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import Model.ShipModel;
import Controller.ShipController;

/*screen size*/
import java.awt.Toolkit;
import java.awt.Dimension;

public class ShipView extends JPanel{
	
	private static final int SIZE = 1;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)screenSize.getWidth();
	int height = (int)screenSize.getHeight();
	public static int idShip=5;
	
	private ImageIcon imgShip, imgShipTurn;
	public JLabel drawShip;
	
	public ShipView(String spriteShip, String spriteShipTurn, int longueur, int posX, int posY){
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(posX,posY,5+(width/28), 5+(longueur*width/28));
		/* on récupère les images qu'on mets dans des ImageIcon */
		imgShip = new ImageIcon(new ImageIcon(this.getClass().getResource(spriteShip)).getImage().getScaledInstance(width/28,longueur*width/28, Image.SCALE_DEFAULT));
		imgShipTurn = new ImageIcon(new ImageIcon(this.getClass().getResource(spriteShipTurn)).getImage().getScaledInstance(longueur*width/28,width/28, Image.SCALE_DEFAULT));
		/* on mets juste celle dans le sens voulu dans un JLabel */
		drawShip = new JLabel(imgShip);
		drawShip.setBounds(0,0,5+(width/28),5+(longueur*width/28));
		/* on mets le JLabel dans le JPanel */
        this.add(drawShip);
        ShipModel ship = new ShipModel(this, idShip, longueur, imgShip, imgShipTurn);
        ShipController shipcontrol = new ShipController(this, ship,5+(width/28), 5+(longueur*width/28),idShip);
        shipcontrol.defaultPosX=posX;
        shipcontrol.defaultPosY=posY;
        idShip+=1;
	}
}