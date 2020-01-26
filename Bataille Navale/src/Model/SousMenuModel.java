package Model;

import javax.swing.ImageIcon;

public class SousMenuModel {
	private ImageIcon imgMode1Active = new ImageIcon(this.getClass().getResource("/bouton-mode-1-active.png"));
	private ImageIcon imgMode2Active = new ImageIcon(this.getClass().getResource("/bouton-mode-2-active.png"));
	private ImageIcon imgMode3Active = new ImageIcon(this.getClass().getResource("/bouton-mode-3-active.png"));
	private ImageIcon imgMode4Active = new ImageIcon(this.getClass().getResource("/bouton-mode-4-active.png"));
	private ImageIcon imgPopUp = new ImageIcon(this.getClass().getResource("/pop-up.png"));
	private String modeExplication1 = "<html>Chaque joueur essaye de deviner la position des navires ennemis et\r\n" + 
			" tenter <br/>de les couler.</html>";
	private String modeExplication2 = "<html>Similaire au mode Bataille Navale, mais après chaque tir manqué, une <br/>\r\n" + 
			"indication de la distance jusqu’à la cible la plus proche est donnée.</html>";
	private String modeExplication3 = "<html>Similaire au mode Bataille Navale à l’exception du mode de sélection des <br/>coordonnées. Le joueur sélectionne d’abord la coordonnée verticale de la <br/>cible.\r\n" + 
			"\r\n" + 
			"Les numéros de la coordonnée horizontale de la cible apparaissent <br/>alors l’un après l’autre\r\n" + 
			"(en boucle). Le joueur doit alors valider la deuxième <br/> coordonnée au bon moment.</html>";
	private String modeExplication4 = "<html>Mélange des 3 modes précédents. Les 2 coordonnées de la cibles sont<br/> \r\n" + 
			"sélectionnées en mode artillerie et à chaque tir manqué, une indication <br/> de la distance\r\n" + 
			"jusqu’à la cible la plus proche est donnée (mode radar).</html>";
	
	
	public ImageIcon getMode1Active() {
		return imgMode1Active;
	}
	
	public ImageIcon getMode2Active() {
		return imgMode2Active;
	}
	
	public ImageIcon getMode3Active() {
		return imgMode3Active;
	}
	
	public ImageIcon getMode4Active() {
		return imgMode4Active;
	}
	
	public ImageIcon getPopUp() {
		return imgPopUp;
	}
	
	public String getModeExplication1() {
		return modeExplication1;
	}
	
	public String getModeExplication2() {
		return modeExplication2;
	}
	
	public String getModeExplication3() {
		return modeExplication3;
	}
	
	public String getModeExplication4() {
		return modeExplication4;
	}
}
