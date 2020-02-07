package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.Sound;
import Model.SousMenuModel;
import View.JeuView;
import View.SousMenuView;

public class SousMenuController {
	private SousMenuView view;
	private SousMenuModel model;
	private static int nbBateau=5;
	
	public SousMenuController(SousMenuView view, SousMenuModel model, int nbJoueur){
		this.view = view;
		this.model = model;
		
		view.setVisible(true);
		
		view.getMode1().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getMode1().setIcon(model.getMode1Active());
				view.getPopUp().setIcon(model.getPopUp());
				view.getTextPopUp().setText(model.getModeExplication1());
				Sound.playSound("/metal-sound.wav");
				}
			});		
	
		view.getMode2().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getMode2().setIcon(model.getMode2Active());
				view.getPopUp().setIcon(model.getPopUp());
				view.getTextPopUp().setText(model.getModeExplication2());
				Sound.playSound("/metal-sound.wav");
				}
			});		
		
		view.getMode3().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getMode3().setIcon(model.getMode3Active());
				view.getPopUp().setIcon(model.getPopUp());
				view.getTextPopUp().setText(model.getModeExplication3());
				Sound.playSound("/metal-sound.wav");
				}
			});		
		
		view.getMode4().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getMode4().setIcon(model.getMode4Active());
				view.getPopUp().setIcon(model.getPopUp());
				view.getTextPopUp().setText(model.getModeExplication4());
				Sound.playSound("/metal-sound.wav");
				}
			});		
		
		// Si la souris touche le fond d'écran, les boutons sont remis à jour
		
		view.getBg().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getMode1().setIcon(view.getMode1Image());
				view.getMode2().setIcon(view.getMode2Image());
				view.getMode3().setIcon(view.getMode3Image());
				view.getMode4().setIcon(view.getMode4Image());
				
			}
		});
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		view.getMode1().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				JeuView jeuView = new JeuView(nbJoueur, 1, nbBateau);
				
				view.setVisible(false);
			}
		});
		
		view.getMode2().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				JeuView jeuView = new JeuView(nbJoueur, 2, nbBateau);
				
				view.setVisible(false);
			}
		});
		
		view.getMode3().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				JeuView jeuView = new JeuView(nbJoueur, 3, nbBateau);
				
				view.setVisible(false);
			}
		});
		
		view.getMode4().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				JeuView jeuView = new JeuView(nbJoueur, 4, nbBateau);
				
				view.setVisible(false);
			}
		});
		
		view.getShip1().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				view.getShip1().setIcon(model.getShip1Active());
				view.getShip2().setIcon(view.getShip2Img());
				view.getShip3().setIcon(view.getShip3Img());
				view.getShip4().setIcon(view.getShip4Img());
				view.getShip5().setIcon(view.getShip5Img());
				nbBateau=1;
			}
		});
		view.getShip2().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				view.getShip1().setIcon(view.getShip1Img());
				view.getShip2().setIcon(model.getShip2Active());
				view.getShip3().setIcon(view.getShip3Img());
				view.getShip4().setIcon(view.getShip4Img());
				view.getShip5().setIcon(view.getShip5Img());
				nbBateau=2;
			}
		});
		view.getShip3().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				view.getShip1().setIcon(view.getShip1Img());
				view.getShip2().setIcon(view.getShip2Img());
				view.getShip3().setIcon(model.getShip3Active());
				view.getShip4().setIcon(view.getShip4Img());
				view.getShip5().setIcon(view.getShip5Img());
				nbBateau=3;
			}
		});
		view.getShip4().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				view.getShip1().setIcon(view.getShip1Img());
				view.getShip2().setIcon(view.getShip2Img());
				view.getShip3().setIcon(view.getShip3Img());
				view.getShip4().setIcon(model.getShip4Active());
				view.getShip5().setIcon(view.getShip5Img());
				nbBateau=4;
			}
		});
		view.getShip5().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				view.getShip1().setIcon(view.getShip1Img());
				view.getShip2().setIcon(view.getShip2Img());
				view.getShip3().setIcon(view.getShip3Img());
				view.getShip4().setIcon(view.getShip4Img());
				view.getShip5().setIcon(model.getShip5Active());
				nbBateau=5;
			}
		});
	}
}
