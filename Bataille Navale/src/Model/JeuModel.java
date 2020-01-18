package Model;

import java.util.Arrays;
import java.util.HashMap;

public class JeuModel {
	
	
	public JeuModel() {
		HashMap <String, Navire> mapNavire = new HashMap<String, Navire>();//test des hashmap
		mapNavire.put("PorteAvionP1",new Navire("PorteAvionP1",5));
		Navire nom = mapNavire.get("PorteAvionP1");
		int type = nom.getType();
		nom.setCoord(1, 2);
		int[] Coord = nom.getCoord();
		System.out.println(type);
		System.out.println(Arrays.toString(Coord));
	}
}