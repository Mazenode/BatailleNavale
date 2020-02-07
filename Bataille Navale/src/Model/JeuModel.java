package Model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import Controller.ShipController;
import Controller.JeuController;
import View.JeuView;

public class JeuModel {
	static int[][] gridGauche;
	static int[][] gridDroite;
	static int[][] caseInGrille;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = (int)screenSize.getWidth();
    public static int height = (int)screenSize.getHeight();
    static int posXPremiereGrille, posXDeuxiemeGrille;
    static JeuView viewjeu;
    public static int compteurShip;
	
	public JeuModel(JeuView view, int posXPremiereGrille, int posXDeuxiemeGrille) {
		this.viewjeu = view;
		this.gridGauche = view.gridGauche;
		this.gridDroite = view.gridDroite;
		this.posXPremiereGrille = posXPremiereGrille;
		this.posXDeuxiemeGrille = posXDeuxiemeGrille;

	}	
	
	/* test affiche grille */
	public static void printGrilleGauche() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(gridGauche[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
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
	
	/* efface les bateaux de la view */
	public static void clearAllShipLabel(JeuController control, int [][] grid) {
		printGrilleGauche();
		printGrilleDroite();
		int compteur=0;
		if (viewjeu.nbBateau>=1) {
			compteur += 5;
			if (viewjeu.nbBateau>=2) {
				compteur += 4;
				if (viewjeu.nbBateau>=3) {
					compteur += 3;
					if (viewjeu.nbBateau>=4) {
						compteur += 3;
						if (viewjeu.nbBateau>=5) {
							compteur += 2;
						}
					}
				}
			}
		}
		compteurShip = compteur;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(grid == gridGauche) {
					if(gridGauche[i][j]!=0) {
						compteur-=1;
						System.out.println(compteur);
					}
				}else if (grid == gridDroite) {
					if(gridDroite[i][j]!=0) {
						compteur-=1;
						System.out.println(compteur);
					}
				}
			}
		}
		if(compteur==0 && grid == gridGauche) {
			if (viewjeu.nbBateau>=1) {
				viewjeu.ship5.setBounds(0,0,0,0);
				viewjeu.remove(viewjeu.ship5);
				if (viewjeu.nbBateau>=2) {
					viewjeu.ship4.setBounds(0,0,0,0);
					viewjeu.remove(viewjeu.ship4);
					if (viewjeu.nbBateau>=3) {
						viewjeu.ship3.setBounds(0,0,0,0);
						viewjeu.remove(viewjeu.ship3);
						if (viewjeu.nbBateau>=4) {
							viewjeu.ship2.setBounds(0,0,0,0);
							viewjeu.remove(viewjeu.ship2);
							if (viewjeu.nbBateau>=5) {
								viewjeu.ship.setBounds(0,0,0,0);
								viewjeu.remove(viewjeu.ship);
							}
						}
					}
				}
			}
			control.shipGClear=true;
			control.startGame();
		}else if(compteur==0 && grid == gridDroite) {
			if (viewjeu.nbBateau>=1) {
				viewjeu.ship10.setBounds(0,0,0,0);
				viewjeu.remove(viewjeu.ship10);
				if (viewjeu.nbBateau>=2) {
					viewjeu.ship9.setBounds(0,0,0,0);
					viewjeu.remove(viewjeu.ship9);
					if (viewjeu.nbBateau>=3) {
						viewjeu.ship8.setBounds(0,0,0,0);
						viewjeu.remove(viewjeu.ship8);
						if (viewjeu.nbBateau>=4) {
							viewjeu.ship7.setBounds(0,0,0,0);
							viewjeu.remove(viewjeu.ship7);
							if (viewjeu.nbBateau>=5) {
								viewjeu.ship6.setBounds(0,0,0,0);
								viewjeu.remove(viewjeu.ship6);
							}
						}
					}
				}
			}
			control.shipDClear=true;
			control.startGame();
		}
	}
	
	/* permet de mettre le bateau qu'on deplace en avant */
	public static void shipInFirstPos(ShipController ship) {
		viewjeu.add(ship.view, 1);
	}
	
	/* enlève le bateau dans la grille */
	public static void clearBateaux(int[][] grid, int idShip) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(grid == gridGauche) {
					if(gridGauche[i][j]==idShip) {
						gridGauche[i][j]=0;
					}
				}else if (grid == gridDroite) {
					if(gridDroite[i][j]==idShip) {
						gridDroite[i][j]=0;
					}
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
			}else {
				if(ship.turnShip==true && (grid[i+k][j]!=0 && grid[i+k][j]!=ship.idShip)) {
					dispo = false;
				}
			}
		}
		return dispo;
	}
	
	/* on place le bateau */
	public static void setBateaux(int posX, int posY, ShipController ship, int [][] grid){
		int posGrille=0;
		if(grid==gridGauche) {
			posGrille=posXPremiereGrille;
		}else if(grid==gridDroite) {
			posGrille=posXDeuxiemeGrille;
		}
		for (int i=0;i<10;i++) {
			/* on cherche la première case de la grille par rapport à l'axe x (donc la ligne où veut être placé le bateau) */
			if(posY>i*(width/28)+(height/4) && posY<(i+1)*(width/28)+(height/4)) {
				for(int j=0;j<10;j++) {
					/* on cherche la première case de la grille par rapport à l'axe y (donc la colonne où veut être placé le bateau) */
					if (posX>j*(width/28)+posGrille && posX<(j+1)*(width/28)+posGrille) {
						/* si le bateau peut être placé */
						if(((ship.turnShip==false && j+ship.model.getLongueur()<=10)||(ship.turnShip==true && i+ship.model.getLongueur()<=10)) && caseDispo(grid, i, j, ship)) {
							clearBateaux(grid,ship.idShip);
							for(int k=0;k<ship.model.getLongueur(); k++) {
								if(ship.turnShip==false) {
									if(grid==gridGauche) {
										gridGauche[i][j+k]=ship.idShip;
									}else if(grid==gridDroite) {
										gridDroite[i][j+k]=ship.idShip;
									}
								}else if(ship.turnShip==true){
									if(grid==gridGauche) {
										gridGauche[i+k][j]=ship.idShip;
									}else if(grid==gridDroite) {
										gridDroite[i+k][j]=ship.idShip;
									}
								}
							}
							ship.defaultPosX=j*(width/28)+posGrille;
							ship.defaultPosY=i*(width/28)+(height/4);
							ship.defaultTurn=ship.turnShip;
						}
					}
				}
			}
		}
		
	}
	
	public static boolean setBateauxBot(int posX, int posY, int turnShip, int idShip ,int longueur){
		boolean bool = false;
			/* si le bateau peut être placé */
		    if((turnShip==1 && posY+longueur<=10)||(turnShip==0 && posX+longueur<=10)) {
		    	if(caseDispoBot(posX, posY, longueur, idShip,turnShip)) {
		    		for(int k=0;k<longueur; k++) {
		    			if(turnShip == 1) {
		    				gridDroite[posX][posY+k]=idShip;
		                }else if(turnShip == 0){
		                	gridDroite[posX+k][posY]=idShip;
		                }
		            }
		            bool = true;
		            return bool;
		    	}
		    }
		return bool;
	}
	
	public static boolean caseDispoBot(int i, int j, int longueur, int idShip, int turnShip) {
		boolean dispo = true;
		for(int k=0;k<longueur; k++) {
			if(turnShip == 1 && (gridDroite[i][j+k]!=0 && gridDroite[i][j+k]!=idShip)) {
				dispo = false;
			}else {
				if(turnShip == 0 && (gridDroite[i+k][j]!=0 && gridDroite[i+k][j]!=idShip)) {
					dispo = false;
				}
			}
		}
		return dispo;
	}
	
	
	
	public static void AlgoBateau() {
		int longueurBateauBot[] = {5,4,3,3,2};
		int IdShip[] = {10,9,8,7,6};
		Random r = new Random();
		int turnShip = 0;
		for(int i = 0; i < JeuView.nbBateau; i++) {
			int x = (int) (r.nextInt(10 - 0));
			int y = (int) (r.nextInt(10 - 0));
			boolean bool = setBateauxBot(x,y,turnShip,IdShip[i],longueurBateauBot[i]);
			if(!bool){
				i--;
			}
			
			
			
		}
		
			
		
	}
}