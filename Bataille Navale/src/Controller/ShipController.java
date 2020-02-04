package Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;

import Model.ShipModel;
import View.ShipView;
import Model.JeuModel;

public class ShipController extends MouseAdapter{
	public ShipView view;
	public ShipModel model;
	public ShipController control;
	public boolean moveShip;
	public boolean turnShip=true;
	public int defaultPosX, defaultPosY;
	public int longueurShip, oldLongueur, hauteurShip, idShip;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width = (int)screenSize.getWidth();
    public int height = (int)screenSize.getHeight();
	
	public ShipController(ShipView view, ShipModel model, int longueurShip, int hauteurShip, int idShip) {
		this.model = model;
		this.view = view;
		this.control=this;
		this.idShip = idShip;
		this.longueurShip=longueurShip;
		this.hauteurShip=hauteurShip;
		
		view.setVisible(true);
		/* boolean qui permet de bouger les bateaux */
		moveShip=false;
		
		/* création de fonction lorsqu'on appuie sur la souris */
		view.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				/* si clique Gauche sur un bateau : on permet (ou annule) le droit de le déplacer */
				if(e.getButton() == MouseEvent.BUTTON1) {
					moveShip = (moveShip==false)? true : false;
					/* si on le pose, on va le set dans la grille */
					if(moveShip==false) {
						/* on identifie la où placer le bateau */
						JeuModel.setBateaux((int)MouseInfo.getPointerInfo().getLocation().getX(), (int)MouseInfo.getPointerInfo().getLocation().getY(), control);
						/* on le place aux coordonnées définit */
						if(turnShip) {
							view.setBounds(defaultPosX,defaultPosY,longueurShip,hauteurShip);
						}else {
							view.setBounds(defaultPosX,defaultPosY,hauteurShip,longueurShip);
						}
					}
				}else{
					/* si clique Droit sur un bateau : on le rotate */
					if(e.getButton() == MouseEvent.BUTTON3) {
						if(moveShip==true) {
							turnShip = (turnShip==false)? true : false;
							/* on rotate le bateau */
							model.changeShip(turnShip, longueurShip, hauteurShip);
							/* on replace le nouveau bateau */
							if(turnShip) {
								view.setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-longueurShip/2,(int)MouseInfo.getPointerInfo().getLocation().getY()-hauteurShip*(1)/(2*model.longueur),longueurShip,hauteurShip);
							}else {
								view.setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-hauteurShip*(1)/(2*model.longueur),(int)MouseInfo.getPointerInfo().getLocation().getY()-longueurShip/2,hauteurShip,longueurShip);
							}
						}
					}
				}
			}
		});
		/* si on deplace la souris avec le droit de le déplacer : on modifie les coordonnées du bâteau */
		view.addMouseMotionListener(new MouseAdapter(){
			public void mouseMoved(MouseEvent e){
				if(moveShip==true){
					if(turnShip) {
						view.setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-longueurShip/2,(int)MouseInfo.getPointerInfo().getLocation().getY()-hauteurShip*(1)/(2*model.longueur),longueurShip,hauteurShip);
					}else {
						view.setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-hauteurShip*(1)/(2*model.longueur),(int)MouseInfo.getPointerInfo().getLocation().getY()-longueurShip/2,hauteurShip,longueurShip);
					}
				}
			}
			public void mouseExited(MouseEvent e){
				if(moveShip==true){
					if(turnShip) {
						view.setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-longueurShip/2,(int)MouseInfo.getPointerInfo().getLocation().getY()-hauteurShip*(1)/(2*model.longueur),longueurShip,hauteurShip);
					}else {
						view.setBounds((int)MouseInfo.getPointerInfo().getLocation().getX()-hauteurShip*(1)/(2*model.longueur),(int)MouseInfo.getPointerInfo().getLocation().getY()-longueurShip/2,hauteurShip,longueurShip);
					}
				}
			}
		});	
	}
}