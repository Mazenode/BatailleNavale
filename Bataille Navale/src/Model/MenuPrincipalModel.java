package Model;

import javax.swing.ImageIcon;

public class MenuPrincipalModel {
	
	/*
	 * Le modéle du menu principal, il a içi la fonction de renvoyer les nouvelles images
	 * quand le contrôlleur l'appele
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
