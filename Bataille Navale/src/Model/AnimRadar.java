package Model;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controller.JeuController;

public class AnimRadar {
	private ArrayList<Case> listeCase;
	private Case caseCase;
	private int k = 0;
	private int[][] grid;
	private boolean dejaActive = false;
	private ImageIcon explosion = new ImageIcon(this.getClass().getResource("/explosion-finale.png"));
	private ImageIcon splash = new ImageIcon(this.getClass().getResource("/splash-finale.png"));
	private ImageIcon radarIcon = new ImageIcon(this.getClass().getResource("/radar.gif"));

	private boolean detected = false;
	
	public AnimRadar( Case caseCase, ArrayList<Case> listeCase, int[][] grid) {
		this.caseCase = caseCase;
		this.listeCase = listeCase;
		this.grid = grid;

		//Permet d'eviter de repeindre les cases déja touchées
		
		listeCase.get(1).setValue(1);
		listeCase.get(15).setValue(2);
		//setCase();
		
		propa();
		
		
	}
	
	public void propa() {
		int posX = caseCase.getY() - k;
		int posY = caseCase.getX() * 10 - k * 10;
		
			for (int i = 0; i < 2 * k + 1; i++) {	
				for (int j = 0; j < 2 * k + 1; j++) {
					int caseTraitee = posX + posY + (10 * i) + j;
						if (posY + 10 * i >= 0 && posY + 10 * i <= 90) {
							if(posX + j >= 0 && posX + j <= 9 ) {
								if(listeCase.get(caseTraitee).getValue() == 1) {
									detected = true;
								}											
							}
						}
				}
			}
			
			if(!detected) {
				for (int i = 0; i < 2 * k + 1; i++) {	
					for (int j = 0; j < 2 * k + 1; j++) {
						int caseTraitee = posX + posY + (10 * i) + j;
							if (posY + 10 * i >= 0 && posY + 10 * i <= 90) {
								if(posX + j >= 0 && posX + j <= 9 ) {

									radarIcon.getImage().flush();
									listeCase.get(caseTraitee).getButton().setIcon(radarIcon);

								}
							}
					}
				}
			}
			else {
				
			}
			
			this.k++;
			
			if(k < 10) {			
				if(!detected) {
					JeuController.setTimeout(() -> propa(), 1800);
					System.out.println("------------------------fin boucle k = " + k + "---------------------------------------");
				}
			}
			else {
				repaint();
			}
	}
	
	public void setCase() {
		for(int j = 0 ; j < 10; j++) {
			for(int i = 0; i < 10; i++) {
				if(grid[j][i] == 2) {
					listeCase.get(j + 10*i).setValue(2);	
				}
				else if(grid[j][i] == 3) {
					listeCase.get(j + 10*i).setValue(3);
				}
			}
		}
	}
	
	public void repaint() {
		for(int i = 0; i < 100; i++) {	
			if(listeCase.get(i).getValue() == 2) {
				listeCase.get(i).getButton().setIcon(explosion);
			}
			else if(listeCase.get(i).getValue() == 3) {
				listeCase.get(i).getButton().setIcon(splash);
			}
			else {
				listeCase.get(i).getButton().setBackground(new Color (23,26,63));
			}
		}
		
	}
}
