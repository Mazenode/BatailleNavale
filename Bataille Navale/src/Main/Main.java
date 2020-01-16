package Main;
import Controller.MenuPrincipalController;
import Model.MenuPrincipalModel;
import View.MenuPrincipalView;;

public class Main {

	public static void main(String[] args) {
		
		/*Le main du programme où on déclare le Modèle, la Vue et le contrôleur du menu principal,
		 les autres frames seront lancées à partir des différents contrôlleurs en fonction des 
		 choix de l'utilisateur */
		
		MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
		
		MenuPrincipalModel menuPrincipalModel = new MenuPrincipalModel();
		
		MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipalView, menuPrincipalModel);
        
		
		
		/* A mettre dans grille
		 * for(i=0;i < grille[0].length;i++){
        System.out.println(grille[i][j]);
        for(j=0;j<grille[1].length;j++){
                
        }
    }*/
	}

}
