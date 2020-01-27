package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Case;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints; 
import java.awt.event.*;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.Action;
 
public class JeuView extends JFrame {
	private ImageIcon imgBackground1Joueur = new ImageIcon(this.getClass().getResource("/1Joueur.png"));
	private ImageIcon imgBackground2Joueur = new ImageIcon(this.getClass().getResource("/2Joueur.png"));
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
	private JLabel background;
	private int tab[][];
	
	public JeuView(int nbJoueur) {
		this.setSize(width, height);
		this.setLayout(null);
		
		tab = new int[10][10];
		
		background = new JLabel("", imgBackground1Joueur, JLabel.CENTER);
		background.setBounds(0,0, width, height);
		
		PlateauView plateauView1 = new PlateauView(20,20, tab);
		PlateauView plateauView2 = new PlateauView(width*3/5,height*1/3, tab);

		add(plateauView1);
		
		add(plateauView2);

		plateauView1.setBounds(385, 280, 700, 700); //modifie la taille du comteneur de la grille doit etre egale a la taille de la grille
		plateauView1.setBackground(new Color (217,217,216));
		plateauView2.setBounds(1110, 280, 700, 700);
		plateauView2.setBackground(new Color (217,217,216));
		
		
		//Je récupère la liste de cases et je met un mouse listener sur tous les boutons
		plateauView1.getListe().forEach((n) -> n.getButton().addActionListener(event -> caseClick(n)));
		
		
		add(background);	

		this.setUndecorated(true);
		this.setVisible(true);
		
	
	}


	public void setTab(Case caseCase) {
		tab[caseCase.getX()][caseCase.getY()] = 1;
		printGrille();
	}
	
	public void printGrille() {
		for(int j = 0; j < 10; j++) {
			for(int i = 0; i < 10; i++) {
				System.out.print(tab[j][i]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	//Fonction qui été dans plateauView que j'ai ré-adapté dans JeuView.
	 private void caseClick(Case caseCase) {
	        System.out.println("Vous avez cliqué la case colonne="+caseCase.getX()+", ligne="+caseCase.getY());
	        if (caseCase.getButton().getBackground().equals(Color.RED)){
	        	caseCase.getButton().setBackground(new Color (23,26,63));
	        }
	        else{
	        	caseCase.getButton().setBackground(Color.RED);
	            tab[caseCase.getX()][caseCase.getY()] = 1;
	            printGrille();
	        }
	        
	    }
}
