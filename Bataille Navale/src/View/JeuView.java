package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints; 
import java.awt.event.*;
import javax.swing.Action;
 
public class JeuView extends JFrame {
	private ImageIcon imgBackground1Joueur = new ImageIcon(this.getClass().getResource("/1Joueur.png"));
	private ImageIcon imgBackground2Joueur = new ImageIcon(this.getClass().getResource("/2Joueur.png"));
	public int x = 1920;
	public int y = 1080;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
	private JLabel background;
	
	public JeuView(int nbJoueur) {
		this.setSize(1920, 1080);
		this.setLayout(null);
		
		if(nbJoueur == 1) {
			background = new JLabel("", imgBackground1Joueur, JLabel.CENTER);
			background.setBounds(0,0, x, y);

			
			GridBagConstraints gbc = new GridBagConstraints();
		
			GridBagConstraints c = new GridBagConstraints();	
			
			PlateauView plateauView1 = new PlateauView(20,20);
			PlateauView plateauView2 = new PlateauView(width*3/5,height*1/3);

			add(plateauView1);
			
			add(plateauView2);

			plateauView1.setBounds(385, 280, 700, 700); //modifie la taille du comteneur de la grille doit etre egale a la taille de la grille
			plateauView1.setBackground(new Color (217,217,216));
			plateauView2.setBounds(1110, 280, 700, 700);
			plateauView2.setBackground(new Color (217,217,216));
			add(background);
		}
		
		else {
			background = new JLabel("", imgBackground2Joueur, JLabel.CENTER);
			background.setBounds(0,0, x, y);
		}
		

		this.setUndecorated(true);
		this.setVisible(true);
		
	
	}
	
	
}
