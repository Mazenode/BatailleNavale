package Model;

public class GrilleModel {
    public static int nbL = 10;
    public static int nbC = 8;
    public static int [] [] gridComp = new int [nbL] [nbC]; // Grille pour l'ordi
    public static int [] [] gridPlay = new int [nbL] [nbC];  // Grille pour le joueur

    /*public static boolean PosIsOK(int [][] grille, int l, int c, int d, int t){// demande en paramettre une grille une ligne l une colonne c une  direction d et un type de bateau t et renvoie si il est possible de placer le bateau
        if (l<=10 && c<= 10){
            
        }
        
        return false;
    } je sais pas si c'est utile*/
    
    public void Grille(int [][]grille){
        for(int i = 0;i<grille.length;i++){
            System.out.println(i);
            for(int j = 0;i<grille[0].length;j++){
                System.out.println(j);
            }
        }
    }
    


}
