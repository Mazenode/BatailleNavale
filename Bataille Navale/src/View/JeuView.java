package View;

import javax.swing.ImageIcon;
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
	private ImageIcon imgBackground1Joueur = new ImageIcon(this.getClass().getResource("/1Joueur.png"));
	private ImageIcon imgBackground2Joueur = new ImageIcon(this.getClass().getResource("/2Joueur.png"));
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	private ImageIcon gifVictoire = new ImageIcon(new ImageIcon(this.getClass().getResource("/victoire.gif")).getImage()
			.getScaledInstance(width, height, Image.SCALE_DEFAULT));;
	public JLabel background;
	public JLabel victoire;
	public int gridGauche[][];
	public static int gridDroite[][];
	public Bot bot;
	public PlateauView plateauView1, plateauView2;
	private JLabel prompteur;
	private String textPrompteur;
	private int nbJoueur;

	public JeuView(int nbJoueur) {
		this.setSize(width, height);
		this.setLayout(null);

		this.nbJoueur = nbJoueur;

		gridGauche = new int[10][10];
		gridDroite = new int[10][10];

		gridDroite[0][0] = 1;
		/*
		 * gridDroite[0][1] = 1; gridDroite[0][2] = 1; gridDroite[5][5] = 1;
		 */

		prompteur = new JLabel(textPrompteur);
		prompteur.setBounds(width / 2 - width / 4, height / 30, width / 2 + width / 16, height / 10);
		prompteur.setForeground(Color.white);
		prompteur.setFont(new Font(textPrompteur, Font.BOLD, width / 40));

		add(prompteur);

		background = new JLabel("", imgBackground1Joueur, JLabel.CENTER);
		background.setBounds(0, 0, width, height);

		ShipView ship = new ShipView("/petit-bateau-couche.png", 2);
		add(ship);
		ShipView ship2 = new ShipView("/porte-avion-couche.png", 4);
		add(ship2);

		this.plateauView1 = new PlateauView(20, 20, gridGauche, true);
		add(plateauView1);
		this.plateauView2 = new PlateauView(width * 3 / 5, height * 1 / 3, gridDroite, false);
		add(plateauView2);

		plateauView1.setBounds(385, 280, 700, 700); // modifie la taille du comteneur de la grille doit etre egale a la
													// taille de la grille
		plateauView1.setBackground(new Color(217, 217, 216));
		plateauView2.setBounds(1110, 280, 700, 700);
		plateauView2.setBackground(new Color(217, 217, 216));

		bot = new Bot();

		// Je récupère la liste de cases et je met un mouse listener sur tous les
		// boutons
		victoire = new JLabel(gifVictoire);
		victoire.setBounds(0, 0, width, height);

		add(background);

		this.setUndecorated(true);
		this.setVisible(true);
		JeuModel jeu = new JeuModel(gridGauche, gridDroite);
		JeuController controlJeu = new JeuController(this, jeu);

	}

	public JLabel getPrompteur() {
		return prompteur;
	}

	public void setPrompteur(String text) {
		prompteur.setText(text);
	}

	public void finish() {
		background.setVisible(false);
		plateauView1.setVisible(false);
		plateauView2.setVisible(false);
		add(victoire);
		Sound.playSound("/crab-rave.wav");
	}

	public int getNbJoueur() {
		return this.nbJoueur;
	}
	
	static public int [][] getListeDroite(){
		return gridDroite;
	}

}
