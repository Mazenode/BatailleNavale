package View;
import java.awt.Color;
import java.util.ArrayList;

import Model.AnimCase;
import Model.Case;
import Model.JeuModel;

public class Bot {
	private ArrayList<Case> liste;
	private boolean toucher = false;
	public Bot(){
		liste = PlateauView.getListeGauche();
		int [] tir = new int[100];
	
	}
	
	public int random() {
		int x;
		if(toucher) {
			x = (int) (Math.random() * ( 0 + 3 ));
		}
		else {
			x = (int) (Math.random() * ( 0 + 99 ));
		}
		return x;
	}
	
	public void playMove() {
		AnimCase anim = new AnimCase(liste.get(random()), JeuModel.getGridGauche());
	}
}
