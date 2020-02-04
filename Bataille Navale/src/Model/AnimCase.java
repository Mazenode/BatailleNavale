package Model;

import java.awt.Color;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import Controller.JeuController;
import Main.Main;
import View.Bot;

public class AnimCase {
	private ImageIcon explosion = new ImageIcon(this.getClass().getResource("/explosion.gif"));
	private ImageIcon splash = new ImageIcon(this.getClass().getResource("/splash.gif"));
	private int grid[][];

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
    			if (!JeuController.getTurnPlayer()){
    				Bot.setFloped(false);
				}
    			Sound.playSound("/big-explosion-sound.wav");
    		}
    		
    		else {
    			grid[caseCase.getX()][caseCase.getY()] = 3;
    			splash.getImage().flush();
    			caseCase.getButton().setIcon(splash);
				if (!JeuController.getTurnPlayer()){
					Bot.setFloped(true);
				}
    			Sound.playSound("/splash-sound.wav");
				}

    		}
        }
	}

