package Model;

import java.awt.Dimension;
import java.awt.Toolkit;

import Controller.ShipController;

public class JeuModel {
	static int[][] gridGauche;
	static int[][] gridDroite;
	static int[][] caseInGrille;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = (int)screenSize.getWidth();
    public static int height = (int)screenSize.getHeight();	
	
	public JeuModel(int[][] gridGauche,int[][] gridDroite) {
		this.gridGauche = gridGauche;
		this.gridDroite = gridDroite;

	}	
	/* test affiche grille */
	public static void printGrilleGauche() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(gridGauche[i][j]);
				System.out.print(" ");
			}
		}
		System.out.println("");
	}
	public static void printGrilleDroite() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(gridDroite[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static int[][] getGridGauche() {
		return gridGauche;
	}
	public static int [][] getGridDroite(){
		return gridDroite;
	}
	
	/* enlève le bateau dans la grille */
	public static void clearBateaux(int[][] grid, int idShip) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(grid[i][j]==idShip) {
					grid[i][j]=0;
				}
			}
		}
	}
	
	/* vérifie que le bateau ne veut pas être posé sur un autre */
	public static boolean caseDispo(int[][] grid, int i, int j, ShipController ship) {
		boolean dispo = true;
		for(int k=0;k<ship.model.getLongueur(); k++) {
			if(ship.turnShip==false && (grid[i][j+k]!=0 && grid[i][j+k]!=ship.idShip)) {
				dispo = false;
				System.out.println("nop");
			}else {
				if(ship.turnShip==true && (grid[i+k][j]!=0 && grid[i+k][j]!=ship.idShip)) {
					dispo = false;
					System.out.println("nop");
				}
			}
		}
		return dispo;
	}
	
	/* on place le bateau */
	public static void setBateaux(int posX, int posY, ShipController ship){
		for (int i=0;i<10;i++) {
			/* on cherche la première case de la grille par rapport à l'axe x (donc la ligne où veut être placé le bateau) */
			if(posY>i*(width/28)+(height/4) && posY<(i+1)*(width/28)+(height/4)) {
				for(int j=0;j<10;j++) {
					/* on cherche la première case de la grille par rapport à l'axe y (donc la colonne où veut être placé le bateau) */
					if (posX>j*(width/28)+width/5 && posX<(j+1)*(width/28)+width/5) {
						/* si le bateau peut être placé */
						if(((ship.turnShip==false && j+ship.model.getLongueur()<=10)||(ship.turnShip==true && i+ship.model.getLongueur()<=10)) && caseDispo(gridGauche, i, j, ship)) {
							clearBateaux(gridGauche,ship.idShip);
							for(int k=0;k<ship.model.getLongueur(); k++) {
								if(ship.turnShip==false) {
									gridGauche[i][j+k]=ship.idShip;
								}else {
									gridGauche[i+k][j]=ship.idShip;
								}
							}
							ship.defaultPosX=j*(width/28)+(width/5);
							ship.defaultPosY=i*(width/28)+(height/4);
						}
					}
				}
			}
		}
		printGrilleGauche();
	}
}