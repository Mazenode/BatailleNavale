package Model;

import javax.swing.ImageIcon;

public class MenuPrincipalModel {
	
	/*
	 * Le mod�le du menu principal, il a i�i la fonction de renvoyer les nouvelles images
	 * quand le contr�lleur l'appele
	 */
	
	private ImageIcon imgDemoActif = new ImageIcon(this.getClass().getResource("/demo_active.png"));
	private ImageIcon imgJ1Actif = new ImageIcon(this.getClass().getResource("/joueur1_active.png"));
	private ImageIcon imgJ2Actif = new ImageIcon(this.getClass().getResource("/joueur2_active.png"));
	
	public ImageIcon getDemoActive() {
		return imgDemoActif;
	}
	
	public ImageIcon getJ1Active() {
		return imgJ1Actif;
	}
	
	public ImageIcon getJ2Active() {
		return imgJ2Actif;
	}
}
