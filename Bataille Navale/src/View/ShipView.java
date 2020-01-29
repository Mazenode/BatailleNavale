package View;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import Model.ShipModel;
import Controller.ShipController;

/*screen size*/
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class ShipView extends JPanel{
	
	private static final int SIZE = 1;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)screenSize.getWidth();
	int height = (int)screenSize.getHeight();
	private ArrayList<ShipModel> listeShip = new ArrayList<>();
	
	private ImageIcon imgShip;
	private JLabel drawShip;
	
	public ShipView(String spriteShip, int longueur){
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(-3,-3,3+(longueur*width/28),3+(width/28));
		imgShip= new ImageIcon(new ImageIcon(this.getClass().getResource(spriteShip)).getImage().getScaledInstance(longueur*width/28,width/28, Image.SCALE_DEFAULT));
		drawShip = new JLabel(imgShip);
		drawShip.setBounds(0,0,longueur*width/28,width/28);
        this.add(drawShip);
        ShipModel ship = new ShipModel(this, 2);
        listeShip.add(ship);
        ShipController shipcontrol = new ShipController(this, ship,3+(longueur*width/28),3+(width/28));
	}
	
    public ArrayList<ShipModel> getListeShip(){
    	return listeShip;
    }
}