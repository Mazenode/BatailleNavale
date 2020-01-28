package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.JeuModel;
import Model.MenuPrincipalModel;
import Model.Sound;
import Model.SousMenuModel;
import View.JeuView;
import View.MenuPrincipalView;
import View.SousMenuView;

public class SousMenuController {
	private SousMenuView view;
	private SousMenuModel model;
	
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
				
				JeuView jeuView = new JeuView(nbJoueur);
				
				JeuModel jeuModel = new JeuModel();
				
				JeuController jeuController = new JeuController(jeuView, jeuModel);
				view.setVisible(false);
			}
		});
		
		view.getMode2().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				/*JeuView jeuView = new JeuView();
				
				view.setVisible(false);*/
			}
		});
		
		view.getMode3().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				/*JeuView jeuView = new JeuView();
				
				view.setVisible(false);*/
			}
		});
		
		view.getMode4().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				/*JeuView jeuView = new JeuView();
				
				view.setVisible(false);*/
			}
		});
	}
}
