package Model;

import java.awt.Color;
import javax.swing.*;

import Controller.JeuController;
import View.Bot;

public class AnimCase {
	private ImageIcon explosion = new ImageIcon(this.getClass().getResource("/explosion.gif"));
	private ImageIcon splash = new ImageIcon(this.getClass().getResource("/splash.gif"));
	private int grid[][], testBateauCoule=7;
	int [] tab = {-1,1,10,-10};
	private static int event;

	public AnimCase(Case caseCase, int grid[][]) {
		this.grid = grid;

		//System.out.println("Vous avez clique la case colonne="+caseCase.getX()+", ligne="+caseCase.getY());
        if (caseCase.getButton().getBackground().equals(Color.RED)){
        	caseCase.getButton().setBackground(new Color (23,26,63));
        }
        else{

            if(grid[caseCase.getX()][caseCase.getY()] >= 5) {
            	grid[caseCase.getX()][caseCase.getY()] = 2;
    			explosion.getImage().flush();
    			caseCase.getButton().setIcon(explosion);
    			event = 1;
    			//dés qu'il touche un bateau il passe en mode intelligent ou il ésseye de détruire le bateau qu'il a touché
    			if (!JeuController.getTurnPlayer()){
    				Bot.setFloped(false);
				}
    			// permet de repasser en mode "recherche de bateau" cad en full random sur la grille
				if(coule(grid, testBateauCoule)){
					Bot.setFloped(true);
					Bot.setFirsttry(true);
					Bot.dirlist(tab);
				}
    			Sound.playSound("/big-explosion-sound.wav");
    		}

    		else {
    			grid[caseCase.getX()][caseCase.getY()] = 3;
    			splash.getImage().flush();
    			caseCase.getButton().setIcon(splash);
    			event = 2;
    			//dés qu'il touche l'eau met la variable à true que si c'est au tour du bot
				if (!JeuController.getTurnPlayer()){
					Bot.setFloped(true);
				}
    			Sound.playSound("/splash-sound.wav");
				}

			}
        }
        // permet  de savoir si on a couler un bateau
	public static boolean coule(int [][]grid, int idBateau) {
		boolean coule = true;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(grid[i][j] == idBateau) {
					coule = false;
				}
			}
		}
		return coule;
	}
	
	public static int getEvent() {
		return event;
	}
}

