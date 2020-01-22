package Main;
import Controller.MenuPrincipalController;
import Model.MenuPrincipalModel;
import View.MenuPrincipalView;
import Controller.ShipController;
import Model.ShipModel;
import View.ShipView;;

public class Main {

	public static void main(String[] args) {
		
		/*Le main du programme où on déclare le Modèle, la Vue et le contrôleur du menu principal,
		 les autres frames seront lancées à partir des différents contrôlleurs en fonction des 
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
