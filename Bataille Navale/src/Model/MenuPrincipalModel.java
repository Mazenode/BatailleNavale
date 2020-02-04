package Model;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class MenuPrincipalModel {
	
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)screenSize.getWidth();
	int height = (int)screenSize.getHeight();
	
	/*
	 * Le modéle du menu principal, il a içi la fonction de renvoyer les nouvelles images
	 * quand le contrôlleur l'appele
	 */
	
	private ImageIcon imgDemoActif = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_active.png")).getImage().getScaledInstance(2*width/8, height/10, Image.SCALE_DEFAULT));
	private ImageIcon imgJ1Actif = new ImageIcon(new ImageIcon(this.getClass().getResource("/joueur1_active.png")).getImage().getScaledInstance(2*width/8, height/10, Image.SCALE_DEFAULT));
	private ImageIcon imgJ2Actif = new ImageIcon(new ImageIcon(this.getClass().getResource("/joueur2_active.png")).getImage().getScaledInstance(2*width/8, height/10, Image.SCALE_DEFAULT));

	
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
