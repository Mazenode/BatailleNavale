package View;

import java.awt.*;
import java.util.*;
import java.util.List;

import Model.AnimCase;
import Model.Case;
import Model.JeuModel;

public class Bot {
	private static int valeur,d=0,x=0,i=0;
	private ArrayList<Case> liste;
	private static boolean floped = true;
	private static boolean firsttry = true;
	private static int randElement = 0;
	private ArrayList<Integer> tir = new ArrayList<Integer>();
	private static List<Integer> dirlist = new LinkedList<Integer>(Arrays.asList(-1,1,10,-10));

	public Bot() {
		liste = PlateauView.getListeGauche();
	}

	public int random() {
		int x;
		Random r = new Random();
		//z = 0;//(int) (r.nextInt(y - 0));
		d = getValeur();
		x = (int) (r.nextInt(99 - 0));
		this.x = x;
		System.out.println("Case : " + x);

		return x;

	}

	public void playMove() {
		if (firsttry){
			if (floped){
				valeur = random();
				tirisok(valeur);
				System.out.println(dirlist);
			}
			else {//si on touche on passe dans smartplay()
				valeur = smartplay();
				tirisok(valeur);
			}
		}
		else{
			valeur = smartplay();
			tirisok(valeur);
		}
	}

	public int smartplay(){
		Random rand = new Random();
		
		if (!floped && !firsttry){//tant que l'on touche on continue dans cette direction
			System.out.println("1er randElement :" + randElement + " d :" + d);
			d+= randElement;
			tirisok(d);
			return d;
			}
		if (floped && !firsttry){//on atteint l'extremiter d'un bateau sans l'avoir detruit
			System.out.println("2er randElement :" + randElement + "d :" + d);
			randElement = dirlist.get(rand.nextInt(dirlist.size()));
			d = this.x;
			if(d == 0 || d == 1 || d == 2 || d == 3 || d == 4 || d == 5 || d == 6 || d == 7 || d == 8 || d == 9 && randElement == -10) {
				dirlist.remove(dirlist.indexOf(randElement));
				randElement = dirlist.get(rand.nextInt(dirlist.size()));
				d+=randElement;
				tirisok(d);
				return d;
			}
			if(d == 99 && randElement == 1 || d == 99 && randElement == 10 ) {
				dirlist.remove(dirlist.indexOf(randElement));
				randElement = dirlist.get(rand.nextInt(dirlist.size()));
				d+=randElement;
				tirisok(d);
				return d;
			}
			d+=randElement;
			dirlist.remove(dirlist.indexOf(randElement));
			System.out.println(dirlist);
			tirisok(d);
			return d;
		}
		randElement = dirlist.get(rand.nextInt(dirlist.size()));//premiere fois que l'on touche un bateau et on choisit une direction
		System.out.println("element : "+randElement);
		d = this.x;
		d += randElement;
		dirlist.remove(dirlist.indexOf(randElement));
		System.out.println(dirlist);
		tirisok(d);
		if (firsttry){
			firsttry = false;
		}
		return d;

	}

	public void tirisok(int v){
		System.out.println("tirisok");
		if (!tir.contains(v)) {
			System.out.println("valeur : " + v);
			tir.add(v);
			AnimCase anim = new AnimCase(liste.get(v), JeuModel.getGridGauche());
		}
		else if (floped && firsttry){
			playMove();
		}
		
	}


	public static void setFloped(boolean t){
		floped = t;
	}

	public static void setFirsttry(boolean t){
		firsttry = t;
	}

	public static boolean getFloped(){
		return floped;
	}

	public static int getValeur(){
		return valeur;
	}

	public static void dirlist(int [] tab){
		for (int i = 0 ; i < tab.length; i++){
			if (!dirlist.contains(tab[i])){
				dirlist.add(tab[i]);
			}
		}
	}


}