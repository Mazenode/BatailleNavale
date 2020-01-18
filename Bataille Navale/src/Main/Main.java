package Main;
import Controller.MenuPrincipalController;
import Model.MenuPrincipalModel;
import Model.Navir;
import View.MenuPrincipalView;
import Model.GrilleModel;
import Model.JeuModel;

public class Main {

	public static void main(String[] args) {
		
		/*Le main du programme où on déclare le Modèle, la Vue et le contrôleur du menu principal,
		 les autres frames seront lancées à partir des différents contrôlleurs en fonction des 
		 choix de l'utilisateur */
		
		//MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
		
		//menuPrincipalModel = new MenuPrincipalModel();
		
		//MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipalView, menuPrincipalModel);
		
        GrilleModel grilleModel= new GrilleModel();
        JeuModel jeuModel = new JeuModel();
		
	}

}
