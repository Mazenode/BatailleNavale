package Model;

public class GrilleModel {
    private static int nbL = 10;
    private static int nbC = 10;
    //private static int [] [] gridComp = new int [nbL] [nbC]; // Grille pour l'ordi
    private static int [] [] gridPlay = new int [nbL] [nbC];  // Grille pour le joueur

    /*public static boolean PosIsOK(int [][] grille, int l, int c, int d, int t){// demande en paramettre une grille une ligne l une colonne c une  direction d et un type de bateau t et renvoie si il est possible de placer le bateau
        if (l<=10 && c<= 10){
            
        }
        
        return false;
    } je sais pas si c'est utile*/
    
    public GrilleModel() {
       for(int i = 0; i<gridPlay.length; i++){
    	   for(int j=0; j<gridPlay[0].length; j++) {
    		   
    	   }
       }
    }
    
	public void AfficherGrille() {
    	System.out.println();
    	for(int i = 0; i<gridPlay.length; i++){
     	   for(int j=0; j<gridPlay[0].length; j++) {
     		   System.out.print(" | " + gridPlay[i][j]);
     	   }
     	   System.out.println(" | ");
        }
        System.out.println();
    }


}
