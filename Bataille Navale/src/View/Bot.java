package View;

import java.util.*;

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
	List<Integer> dirlist = new LinkedList<Integer>(Arrays.asList(-1,1,10,-10));

	public Bot() {
		liste = PlateauView.getListeGauche();
	}

	public int random() {
		int x;
		Random r = new Random();
		//z = 0;//(int) (r.nextInt(y - 0));
		d = getValeur();
		x = (int) (50 + r.nextInt(80 - 50));
		this.x = x;
		System.out.println("Case : " + x);

		return x;

	}

	public void playMove() {
		if (firsttry){
			if (floped){
				valeur = random();
				tirisok(valeur);
			}
			else {//si on touche on passe dans smartplay()
				//System.out.println("smartplay()");
				//System.out.println(getFloped());
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
		//List<Integer> dirlist = Arrays.asList(-1,1,10,-10);
		System.out.println("floped: " + floped);
		System.out.println("firsttry: " + firsttry);

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

	public static boolean getFloped(){
		return floped;
	}

	public static int getValeur(){
		return valeur;
	}
}