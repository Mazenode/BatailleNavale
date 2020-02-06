package Main;

import View.JeuView;

public class Main {

	public static void main(String[] args) {
		
		/*Le main du programme o� on d�clare le Mod�le, la Vue et le contr�leur du menu principal,
		 les autres frames seront lanc�es � partir des diff�rents contr�lleurs en fonction des 
		 choix de l'utilisateur */
		

		/*MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
		
		MenuPrincipalModel menuPrincipalModel = new MenuPrincipalModel();
	
		MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipalView, menuPrincipalModel);*/
		
		//Sound.playSound("/battlefield-1942-theme.wav");

		JeuView jeuView = new JeuView(1,4 );
		
		/*JeuModel jeuModel = new JeuModel();
		
		JeuController jeuController = new JeuController(jeuView, jeuModel);*/
		
	}

}
