package View;
import java.awt.Color;
import java.util.ArrayList;

import Model.AnimCase;
import Model.Case;
import Model.JeuModel;

public class Bot {
	private ArrayList<Case> liste;
	private boolean toucher = false;
	private int[]tir;
	private Case toucheCase;
	private int nextCase;
	private int randomVal;
	private int nbEssais = 0;
	
	public Bot(){
		liste = PlateauView.getListeGauche();
		tir = new int[100];
		
	
	}
	
	public int random() {		
		return (int) (Math.random() * ( 0 + 99 ));
	}
	
	public void playMove() {
		System.out.println(nbEssais);
		if(nbEssais < 1) {
			randomVal = random();
			AnimCase anim = new AnimCase(liste.get(randomVal), JeuModel.getGridGauche());
		}
		else {
			AnimCase anim = new AnimCase(liste.get(nextCase), JeuModel.getGridGauche());
		}
		
		System.out.println("ligne 398 " + liste.get(5).getValue());
		
		if(liste.get(randomVal).getValue() == 1) {
			this.nbEssais++;
			System.out.println(liste.get(randomVal).getValue());
			System.out.println("test ?");
			touche();
		}
	}
	
	public void touche() {
		nextCase = randomVal + nbEssais();
	}
	
	public int nbEssais() {
		if(randomVal +1 != 10 || randomVal +1 != 20|| randomVal +1 != 30|| randomVal +1 != 40 || randomVal +1 != 50|| randomVal +1 != 60|| randomVal +1 != 70|| randomVal +1 != 80|| randomVal +1 != 90) {			
				return randomVal + 1;
		}
		if(randomVal -1 != 9 || randomVal -1 != 19|| randomVal -1 != 29|| randomVal -1 != 39 || randomVal -1 != 49|| randomVal -1 != 59|| randomVal -1 != 69|| randomVal -1 != 79|| randomVal -1 != 89) {
			
			return randomVal - 1;
			
		}
			
	
		else if (nbEssais == 3) {
			
		}
		else if (nbEssais == 4) {
	
		}
		return -1;
	}
}