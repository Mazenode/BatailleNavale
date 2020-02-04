package Main;

import Controller.JeuController;
import Controller.MenuPrincipalController;
import Model.JeuModel;
import Model.MenuPrincipalModel;
import Model.Sound;
import View.JeuView;
import View.MenuPrincipalView;
import View.PlateauView;

public class Main {

	public static void main(String[] args) {
		
		/*Le main du programme o� on d�clare le Mod�le, la Vue et le contr�leur du menu principal,
		 les autres frames seront lanc�es � partir des diff�rents contr�lleurs en fonction des 
		 choix de l'utilisateur */
		

		/*MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
		
		MenuPrincipalModel menuPrincipalModel = new MenuPrincipalModel();
	
		MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipalView, menuPrincipalModel);*/
		
		//Sound.playSound("/battlefield-1942-theme.wav");

		JeuView jeuView = new JeuView(1, 3);
		
		/*JeuModel jeuModel = new JeuModel();
		
		JeuController jeuController = new JeuController(jeuView, jeuModel);*/
		
	}

}
