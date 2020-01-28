package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.AnimCase;
import Model.Case;
import Model.Sound;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints; 
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

import javax.swing.Action;
 
public class JeuView extends JFrame {
	private ImageIcon imgBackground1Joueur = new ImageIcon(this.getClass().getResource("/1Joueur.png"));
	private ImageIcon imgBackground2Joueur = new ImageIcon(this.getClass().getResource("/2Joueur.png"));
	private ImageIcon gifVictoire = new ImageIcon(this.getClass().getResource("/victoire.gif"));
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
	private JLabel background;
	private JLabel victoire;
	private static int gridGauche[][];
	private int gridDroite[][];
	private boolean turnPlayer;
	private Bot bot;
	PlateauView plateauView1 = new PlateauView(20,20, gridGauche, true);
	PlateauView plateauView2 = new PlateauView(width*3/5,height*1/3, gridDroite, false);
	
	public JeuView(int nbJoueur) {
		this.setSize(width, height);
		this.setLayout(null);
		turnPlayer = true;
		
		gridGauche = new int[10][10];
		gridDroite = new int[10][10];
		
		gridDroite[0][0] = 1;
		/*gridDroite[0][1] = 1;
		gridDroite[0][2] = 1;
		gridDroite[5][5] = 1;*/
		
		
		background = new JLabel("", imgBackground1Joueur, JLabel.CENTER);
		background.setBounds(0,0, width, height);
		

		add(plateauView1);
		add(plateauView2);

		plateauView1.setBounds(385, 280, 700, 700); //modifie la taille du comteneur de la grille doit etre egale a la taille de la grille
		plateauView1.setBackground(new Color (217,217,216));
		plateauView2.setBounds(1110, 280, 700, 700);
		plateauView2.setBackground(new Color (217,217,216));
		
		
		
		printGrille();
		
		bot = new Bot();		
		plateauView2.getListeDroite().forEach((n) -> n.getButton().addActionListener(event -> caseClick(n)));
				
		
		
		//Je récupère la liste de cases et je met un mouse listener sur tous les boutons
		//plateauView1.getListe().forEach((n) -> n.getButton().addActionListener(event -> caseClick(n)));
		Image scaleImage = gifVictoire.getImage().getScaledInstance(width, height,Image.SCALE_DEFAULT);
		ImageIcon test = new ImageIcon(scaleImage);
		victoire = new JLabel(test);
		victoire.setBounds(0,0,width,height);
		
		add(background);	
		
	

		this.setUndecorated(true);
		this.setVisible(true);
	}


	public static void setTab(Case caseCase) {
		gridGauche[caseCase.getX()][caseCase.getY()] = 1;
	}
	
	public void printGrille() {
		for(int j = 0; j < 10; j++) {
			for(int i = 0; i < 10; i++) {
				System.out.print(gridDroite[j][i]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public boolean isBoardComplete(int [][] tab)
	{
	    // sets complete to true
	    boolean complete = true;

	    //will change complete to false
	    for (int i = 0; i < 10; i++)
	    {
	        for(int j =0; j < 10; j++)
	        {
	            if (tab[i][j] == 1 || tab[i][j] == 5 || tab[i][j] == 6 || tab[i][j] == 7)
	            {
	                complete = false;
	            }
	        }
	    }
	    return complete;
	}
	
	//Fonction qui été dans plateauView que j'ai ré-adapté dans JeuView.
	private void caseClick(Case caseCase) {
		
		
		if(turnPlayer  == true) {
			clickAnim(caseCase);
	        
	        checkTurn();
	        
	        turnPlayer = false;
	        
	        setTimeout(() -> turnPlayer = true, 3000);
		}
		
    }
	
	public static void setTimeout(Runnable runnable, int delay){
	    new Thread(() -> {
	        try {
	            Thread.sleep(delay);
	            runnable.run();
	        }
	        catch (Exception e){
	            System.err.println(e);
	        }
	    }).start();
	}
	
	public void clickAnim(Case caseCase) {
		AnimCase anim = new AnimCase(caseCase, gridDroite);
	}
	
	public void checkTurn() {
		if(isBoardComplete(gridGauche) && isBoardComplete(gridDroite)) {
			
			background.setVisible(false);
			plateauView1.setVisible(false);
			plateauView2.setVisible(false);
			add(victoire);
			Sound.playSound("/crab-rave.wav");
		}
		else {
			setTimeout(() -> bot.playMove(), 1500);
		}
	}
	
	static int [][] getGridGauche(){
		return gridGauche;
		
	}
	
}
