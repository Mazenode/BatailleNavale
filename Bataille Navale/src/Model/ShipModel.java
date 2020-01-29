package Model;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShipModel {
	public int longueur;
	boolean turn;
	JPanel ship;
	private ImageIcon imgJ1Actifturn = new ImageIcon(this.getClass().getResource("/petit-bateau.png"));
	private ImageIcon imgJ1Actif = new ImageIcon(this.getClass().getResource("/sous-marin.png"));
	
	public ShipModel(JPanel ship,int longueur){
		this.ship = ship;
		this.longueur = longueur;
		this.turn = false;
	}
	
	void verifShip(ShipModel ship) {
		
	}
	
	public JPanel getJPanel() {
		return this.ship;
	}
	
	/* on modifie la variable (boolean) correspondant à la rotation */
	public void turnShip() {
		if(this.turn == false) {
			this.turn = true;
		}else {
			this.turn = false;
		}
	}
	
	/* permet de retourner l'image qui correspond */
	public final ImageIcon getShipTurn() {
		if(this.turn == false) {
			return imgJ1Actifturn;
		}else {
			return imgJ1Actif;
		}
	}
}