package Model;

import javax.swing.ImageIcon;

public class DemoModel {
	
	/*Idem que pour Menu Principal, on commence à initialiser à partir du 2ème texte.*/
	private ImageIcon blank = new ImageIcon();
	private ImageIcon imgText2 = new ImageIcon(this.getClass().getResource("/text2.png"));
	
	public ImageIcon getImage(int i) {
		switch(i) {
			case 1:
				return imgText2;
				
			
		}
		return blank;
	}
}