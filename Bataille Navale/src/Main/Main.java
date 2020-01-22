package Main;
import Controller.MenuPrincipalController;
import Model.MenuPrincipalModel;
import View.MenuPrincipalView;
import Controller.ShipController;
import Model.ShipModel;
import View.ShipView;;

public class Main {

	public static void main(String[] args) {
		
		/*Le main du programme o� on d�clare le Mod�le, la Vue et le contr�leur du menu principal,
		 les autres frames seront lanc�es � partir des diff�rents contr�lleurs en fonction des 
		 choix de l'utilisateur */
		

		/*MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
		
		MenuPrincipalModel menuPrincipalModel = new MenuPrincipalModel();
	
		MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipalView, menuPrincipalModel);
        */
		
		ShipView shipView = new ShipView();
		ShipModel shipModel = new ShipModel(5);
		
		ShipController shipController = new ShipController(shipView, shipModel);
		
		/*Initialisation de la grille dans la console :
		 * GrilleModel grilleModel= new GrilleModel();
        JeuModel jeuModel = new JeuModel();*/
		

	}

}
