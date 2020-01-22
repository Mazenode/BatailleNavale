package Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import Model.ShipModel;
import View.ShipView;
//import javax.swing.ImageIcon;

public class ShipController extends MouseAdapter{
	//private ImageIcon imgShip = new ImageIcon(this.getClass().getResource("/demo_background2.png"));
	private ShipView view;
	private ShipModel model;
	private boolean moveShip, turnShip;
	
	public ShipController(ShipView view, ShipModel model) {
		this.model = model;
		this.view = view;
		
		view.setVisible(true);
		/* boolean qui permet de bouger les bateaux */
		moveShip=false;
		
		/* création de fonction lorsqu'on appuie sur la souris */
		view.getShipLabel().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				/* si clique Gauche sur un bateau : on permet (ou annule) le droit de le déplacer */
				if(e.getButton() == MouseEvent.BUTTON1) {
					moveShip = (moveShip==false)? true : false;
				}else{
					/* si clique Droit sur un bateau : on le rotate */
					if(e.getButton() == MouseEvent.BUTTON3) {
						if(moveShip==true) {
							model.turnShip();
							view.getShipLabel().setIcon(model.getShipTurn());
						}
					}
				}
			}
		});
		/* si on deplace la souris avec le droit de le déplacer : on modifie les coordonnées du bâteau */
		view.getShipLabel().addMouseMotionListener(new MouseAdapter(){
			public void mouseMoved(MouseEvent e){
				if(moveShip==true){
					view.getShipLabel().setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-220,(int)MouseInfo.getPointerInfo().getLocation().getY()-45,441,90);
				}
			}
		});	
		
		/* code qui marche pas : (keyListener) */
		
		/*view.getShipLabel().addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				System.out.println(e.getKeyCode());
				if (e.getKeyCode() == KeyEvent.VK_R) {
					System.out.println("nullllos");
					view.getShipLabel().setIcon(model.getShipTurn());
				}
			}
		});*/
	}
}
