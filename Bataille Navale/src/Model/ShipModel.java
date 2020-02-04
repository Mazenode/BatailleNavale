package Model;
import java.awt.Dimension;
import java.awt.Toolkit;

import View.ShipView;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShipModel {
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)screenSize.getWidth();
	int height = (int)screenSize.getHeight();
	public int idShip, longueur;
	boolean turn;
	JPanel ship;
	private ImageIcon imgShip, imgShipTurn;
	
	public ShipModel(ShipView ship, int idShip, int longueur, ImageIcon imgShip, ImageIcon imgShipTurn){
		this.ship = ship;
		this.idShip = idShip;
		this.longueur = longueur;
		this.imgShip= imgShip;	
		this.imgShipTurn = imgShipTurn;
		this.turn = false;
	}
	
	/* change le bateau */
	public void changeShip(boolean turn, int longueur, int hauteur) {
		/* modifie le view en fonction du sens du bateau voulu */
		if(turn) {
			ship.setBounds(0,0,longueur,hauteur);
			JLabel drawShip = new JLabel(imgShip);
			drawShip.setBounds(0,0,longueur,hauteur);
	        ship.add(drawShip);
		}
		else {
			ship.setBounds(0,0,hauteur,longueur);
			JLabel drawShip = new JLabel(imgShipTurn);
			drawShip.setBounds(0,0,hauteur,longueur);
	        ship.add(drawShip);
		}
		/* on enlève l'ancien sens du bateau */
		ship.remove(0);
	}
	
	public int getLongueur() {
		return this.longueur;
	}
}