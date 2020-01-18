package Model;

import java.util.Arrays;
import java.util.HashMap;

public class JeuModel {
	
	
	public JeuModel() {
		HashMap <String, Navir> mapNavir = new HashMap<String, Navir>();//test des hashmap
		mapNavir.put("PorteAvionP1",new Navir("PorteAvionP1",5));
		Navir nom = mapNavir.get("PorteAvionP1");
		int type = nom.getType();
		nom.SetCoord(1, 2);
		int[] Coord = nom.getCoord();
		System.out.println(type);
		System.out.println(Arrays.toString(Coord));
	}
}
