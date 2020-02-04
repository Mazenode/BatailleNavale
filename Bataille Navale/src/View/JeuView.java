package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Sound;
import Controller.JeuController;
import Model.JeuModel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Action;

public class JeuView extends JFrame {
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width = (int)screenSize.getWidth();
    public int height = (int)screenSize.getHeight();
    private ImageIcon gifVictoire= new ImageIcon(new ImageIcon(this.getClass().getResource("/victoire.gif")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    private ImageIcon imgBackground1Joueur = new ImageIcon(new ImageIcon(this.getClass().getResource("/1Joueur.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgBackground2Joueur = new ImageIcon(new ImageIcon(this.getClass().getResource("/2Joueur.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon clic0 = new ImageIcon(new ImageIcon(this.getClass().getResource("/clic.png")).getImage());
	public JLabel background;
	public JLabel victoire;
	public int gridGauche[][];
	public static int gridDroite[][];
	public Bot bot;
	public PlateauView plateauView1,plateauView2;
	public ShipView ship,ship2,ship3,ship4,ship5,ship6,ship7,ship8,ship9,ship10;
	private JLabel prompteur;
	private String textPrompteur;
	private int nbJoueur;
	public static int mode;
	private static JButton bouton;
	private int posXPremiereGrille;
	
	public JeuView(int nbJoueur, int mode) {
		this.setSize(width, height);
		this.setLayout(null);

		this.nbJoueur = nbJoueur;
		this.mode = mode;

		gridGauche = new int[10][10];
		gridDroite = new int[10][10];
		gridDroite[0][0] = 7;
		gridDroite[0][1] = 7;
		/*gridDroite[0][1] = 1;
		gridDroite[0][2] = 1;
		gridDroite[5][5] = 1;*/
		
		prompteur = new JLabel(textPrompteur);
		prompteur.setBounds(width / 2 - width / 4, height / 30, width / 2 + width / 16, height / 10);
		prompteur.setForeground(Color.white);
		prompteur.setFont(new Font(textPrompteur, Font.BOLD, width / 40));

		add(prompteur);
		
		bouton = new JButton(clic0);
		bouton.setBounds(500 , 100, 200, 45);
		
		if (nbJoueur==1) {
			background = new JLabel("", imgBackground1Joueur, JLabel.CENTER);
			ship = new ShipView("/petit-bateau-debout.png", "/petit-bateau-couche.png",2,-10+3*width/28,(height/4));
	        add(ship);
	        ship2 = new ShipView("/cuirasee-debout.png", "/cuirasee-couche.png",3,-10+3*width/28,3*(width/28)+(height/4));
	        add(ship2);
	        ship3 = new ShipView("/cuirasee-debout.png", "/cuirasee-couche.png",3,-10+3*width/28,7*(width/28)+(height/4));
	        add(ship3);
	        ship4 = new ShipView("/sous-marin-debout.png", "/sous-marin-couche.png",4,10+width/28,(height/4));
	        add(ship4);
	        ship5 = new ShipView("/porte-avion-debout.png", "/porte-avion-couche.png",5,10+width/28,5*(width/28)+(height/4));
	        add(ship5);
		}else {
			background = new JLabel("", imgBackground2Joueur, JLabel.CENTER);
			ship = new ShipView("/petit-bateau-debout.png", "/petit-bateau-couche.png",2,-20+2*width/28,(height/4));
	        add(ship);
	        ship2 = new ShipView("/cuirasee-debout.png", "/cuirasee-couche.png",3,-20+2*width/28,3*(width/28)+(height/4));
	        add(ship2);
	        ship3 = new ShipView("/cuirasee-debout.png", "/cuirasee-couche.png",3,-20+2*width/28,7*(width/28)+(height/4));
	        add(ship3);
	        ship4 = new ShipView("/sous-marin-debout.png", "/sous-marin-couche.png",4,20,(height/4));
	        add(ship4);
	        ship5 = new ShipView("/porte-avion-debout.png", "/porte-avion-couche.png",5,20,5*(width/28)+(height/4));
	        add(ship5);
			ship6 = new ShipView("/petit-bateau-debout.png", "/petit-bateau-couche.png",2,width-(width/28)-(-20+2*width/28),(height/4));
	        add(ship6);
	        ship7 = new ShipView("/cuirasee-debout.png", "/cuirasee-couche.png",3,width-(width/28)-(-20+2*width/28),3*(width/28)+(height/4));
	        add(ship7);
	        ship8 = new ShipView("/cuirasee-debout.png", "/cuirasee-couche.png",3,width-(width/28)-(-20+2*width/28),7*(width/28)+(height/4));
	        add(ship8);
	        ship8 = new ShipView("/sous-marin-debout.png", "/sous-marin-couche.png",4,width-(width/28)-(20),(height/4));
	        add(ship8);
	        ship9 = new ShipView("/porte-avion-debout.png", "/porte-avion-couche.png",5,width-(width/28)-(20),5*(width/28)+(height/4));
	        add(ship9);
		}
		background.setBounds(0,0, width, height);
        
        plateauView1 = new PlateauView(20,20, gridGauche, true);
		add(plateauView1);
		plateauView2 = new PlateauView(width*3/5,height*1/3, gridDroite, false);
		add(plateauView2);
		if(nbJoueur==1) {
			plateauView1.setBounds(width/5, height/4, 10*width/28, 10*width/28); //modifie la taille du comteneur de la grille doit etre egale a la taille de la grille
			plateauView2.setBounds((width/5)+(11*width/28), height/4, 10*width/28, 10*width/28);
			posXPremiereGrille=width/5;
		}else {
			plateauView1.setBounds(width/8, height/4, 10*width/28, 10*width/28); //modifie la taille du comteneur de la grille doit etre egale a la taille de la grille
			plateauView2.setBounds((width/8)+(11*width/28), height/4, 10*width/28, 10*width/28);
			posXPremiereGrille=width/8;
		}
		
		bot = new Bot();	
		
		victoire = new JLabel(gifVictoire);
		victoire.setBounds(0, 0, width, height);

		add(background);

		this.setUndecorated(true);
		this.setVisible(true);
		JeuModel jeu = new JeuModel(gridGauche, gridDroite, posXPremiereGrille);
		JeuController controlJeu = new JeuController(this, jeu);

	}

	public JLabel getPrompteur() {
		return prompteur;
	}
	
	public static JButton getBouton() {
		return bouton;
	}

	public void setPrompteur(String text) {
		prompteur.setText(text);
	}

	public void finish() {
		background.setVisible(false);
		plateauView1.setVisible(false);
		plateauView2.setVisible(false);
		ship.setVisible(false);
		ship2.setVisible(false);
		ship3.setVisible(false);
		ship4.setVisible(false);
		ship5.setVisible(false);
		add(victoire);
		Sound.playSound("/crab-rave.wav");
	}

	public int getNbJoueur() {
		return this.nbJoueur;
	}
}
