package Model;

import javax.swing.ImageIcon;

public class DemoModel {
	
	/*Idem que pour Menu Principal, on commence à initialiser à partir de la deuxième image.*/
	private ImageIcon blank = new ImageIcon();
	private ImageIcon imgBackground2 = new ImageIcon(this.getClass().getResource("/demo_background2.png"));
	private ImageIcon imgBackground3 = new ImageIcon(this.getClass().getResource("/demo_background3.png"));
	private ImageIcon imgBackground4 = new ImageIcon(this.getClass().getResource("/demo_background4.png"));
	private ImageIcon imgBackground5 = new ImageIcon(this.getClass().getResource("/demo_background5.png"));
	private ImageIcon imgBackground6 = new ImageIcon(this.getClass().getResource("/demo_background6.png"));
	private ImageIcon imgBackground7 = new ImageIcon(this.getClass().getResource("/demo_background7.png"));
	private ImageIcon imgBackground8 = new ImageIcon(this.getClass().getResource("/demo_background8.png"));
	private ImageIcon imgBackground9 = new ImageIcon(this.getClass().getResource("/demo_background9.png"));
	private ImageIcon imgBackground10 = new ImageIcon(this.getClass().getResource("/demo_background10.png"));
	
	public ImageIcon getImage(int i) {
		switch(i) {
			case 1:
				return imgBackground2;
			case 2:
				return imgBackground3;
			case 3:
				return imgBackground4;
			case 4:
				return imgBackground5;
			case 5:
				return imgBackground6;
			case 6:
				return imgBackground7;
			case 7:
				return imgBackground8;
			case 8:
				return imgBackground9;
			case 9:
				return imgBackground10;	
			
		}
		return blank;
	}
}