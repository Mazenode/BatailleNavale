package Model;

public class Navire {
	public int []Coord = new int[2] ;
	public String NomNavir;
	public int type;
	public Navire(String Nom, int t) {
		NomNavir = Nom;
		type = t;
	}
	public String getNomNavir(){
		return NomNavir;
	}
	public int getType(){
		return type;
	}
	public int[] SetCoord(int x,int y) {
		Coord[0]= x;
		Coord[1]= y;
		return Coord;
	}
	public int [] getCoord() {
		return Coord;
	}
}
