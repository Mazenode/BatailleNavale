package Model;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controller.JeuController;
import View.PlateauView;

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

	public AnimRadar(Case caseCase, ArrayList<Case> listeCase, int[][] grid) {
		this.caseCase = caseCase;
		this.listeCase = listeCase;
		this.grid = grid;

		// Permet d'eviter de repeindre les cases déja touchées
		
		System.out.println("x = " + caseCase.getX());
		System.out.println("y = " + caseCase.getY());
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(grid[i][j] > 5) {
					listeCase.get(i * 10 + j).setValue(1);
				}
			}
		}	
		
		System.out.println("valeur de la case = " + caseCase.getValue());
		
		/*for (int j = 0; j < 100; j++) {
			if (j % 10 == 0) {
				System.out.println("");
			}
			System.out.print(" " + PlateauView.getListeDroite().get(j).getValue());

		}*/

		// setCase();

		if(caseCase.getValue() == 1) {
			AnimCase anim = new AnimCase(caseCase, grid);
		} else {
			propa();
		}
	}

	public void propa() {
		int posX = caseCase.getY() - k;
		int posY = caseCase.getX() * 10 - k * 10;

		for (int i = 0; i < 2 * k + 1; i++) {
			for (int j = 0; j < 2 * k + 1; j++) {
				int caseTraitee = posX + posY + (10 * i) + j;
				if (posY + 10 * i >= 0 && posY + 10 * i <= 90) {
					if (posX + j >= 0 && posX + j <= 9) {
						System.out.print(listeCase.get(caseTraitee).getValue());
						if (listeCase.get(caseTraitee).getValue() == 1) {
							
							detected = true;
						}
					}
				}
			}
		}

		if (k < 10) {
			if (!detected) {
				for (int i = 0; i < 2 * k + 1; i++) {
					for (int j = 0; j < 2 * k + 1; j++) {
						int caseTraitee = posX + posY + (10 * i) + j;
						if (posY + 10 * i >= 0 && posY + 10 * i <= 90) {
							if (posX + j >= 0 && posX + j <= 9) {
								radarIcon.getImage().flush();
								listeCase.get(caseTraitee).getButton().setIcon(radarIcon);

							}
						}
					}
				}
				JeuController.setTimeout(() -> propa(), 1800);
			}
		}

		else {
			repaint();
		}
		this.k++;
	}

	public void setCase() {
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				if (grid[j][i] == 2) {
					listeCase.get(j + 10 * i).setValue(2);
				} else if (grid[j][i] == 3) {
					listeCase.get(j + 10 * i).setValue(3);
				}
			}
		}
	}

	public void repaint() {
		for (int i = 0; i < 100; i++) {
			if (listeCase.get(i).getValue() == 1) {
				listeCase.get(i).getButton().setIcon(explosion);
			}

			else {
				listeCase.get(i).getButton().setBackground(new Color(23, 26, 63));
			}
		}
	}
}
