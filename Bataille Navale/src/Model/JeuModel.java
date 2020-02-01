package Model;

import java.util.Arrays;
import java.util.HashMap;

public class JeuModel {
	static int[][] gridGauche;
	static int[][] gridDroite;

	public JeuModel(int[][] gridGauche, int[][] gridDroite) {
		this.gridGauche = gridGauche;
		this.gridDroite = gridDroite;

	}

	public void printGrille() {
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				this.gridGauche[j][i] = 1;
			}
		}
	}

	public static int[][] getGridGauche() {
		return gridGauche;

	}

}