package Model;

public class Navire {
	public int []Coord = new int[2] ;
	public String NomNavire;
	public int type;
	public Navire(String Nom, int t) {
		NomNavire = Nom;
		type = t;
	}
	public String getNomNavire(){
		return NomNavire;
	}
	public int getType(){
		return type;
	}
	public int[] setCoord(int x,int y) {
		Coord[0]= x;
		Coord[1]= y;
		return Coord;
	}
	public int [] getCoord() {
		return Coord;
	}
}