package Model;
import javax.swing.ImageIcon;

public class ShipModel {
	int longueur;
	boolean turn;
	private ImageIcon imgJ1Actifturn = new ImageIcon(this.getClass().getResource("/petit-bateau.png"));
	private ImageIcon imgJ1Actif = new ImageIcon(this.getClass().getResource("/sous-marin.png"));
	
	public ShipModel(int longueur){
		this.longueur = longueur;
		this.turn = false;
	}
	
	void verifShip(ShipModel ship) {
		
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
