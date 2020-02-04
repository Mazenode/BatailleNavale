package Model;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class DemoModel {
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)screenSize.getWidth();
	int height = (int)screenSize.getHeight();
	
	/*Idem que pour Menu Principal, on commence � initialiser � partir de la deuxi�me image.*/
	private ImageIcon blank = new ImageIcon();
	private ImageIcon imgBackground2 = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_background2.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgBackground3 = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_background3.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgBackground4 = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_background4.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgBackground5 = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_background5.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgBackground6 = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_background6.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgBackground7 = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_background7.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgBackground8 = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_background8.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgBackground9 = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_background9.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgBackground10 = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_background10.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	
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