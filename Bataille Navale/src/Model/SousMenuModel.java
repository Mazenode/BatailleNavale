package Model;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class SousMenuModel {
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
	private ImageIcon imgMode1Active = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-mode-1-active.png")).getImage().getScaledInstance(2*width/9, height/12, Image.SCALE_DEFAULT));
	private ImageIcon imgMode2Active = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-mode-2-active.png")).getImage().getScaledInstance(2*width/9, height/12, Image.SCALE_DEFAULT));
	private ImageIcon imgMode3Active = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-mode-3-active.png")).getImage().getScaledInstance(2*width/9, height/12, Image.SCALE_DEFAULT));
	private ImageIcon imgMode4Active = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-mode-4-active.png")).getImage().getScaledInstance(2*width/9, height/12, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau1Active = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-1-active.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau2Active = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-2-active.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau3Active = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-3-active.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau4Active = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-4-active.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau5Active = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-5-active.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
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
	
	public ImageIcon getShip1Active() {
		return imgChoixBateau1Active;
	}
	
	public ImageIcon getShip2Active() {
		return imgChoixBateau2Active;
	}
	
	public ImageIcon getShip3Active() {
		return imgChoixBateau3Active;
	}
	
	public ImageIcon getShip4Active() {
		return imgChoixBateau4Active;
	}
	
	public ImageIcon getShip5Active() {
		return imgChoixBateau5Active;
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
