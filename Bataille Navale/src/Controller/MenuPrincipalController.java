package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.DemoModel;
import Model.MenuPrincipalModel;
import Model.SousMenuModel;
import View.DemoView;
import View.MenuPrincipalView;
import View.SousMenuView;

public class MenuPrincipalController{
	
	/*
	 * Le contrôleur se charge de détecter les mouvements de la souris et demande au modèle les nouvelles 
	 * images des boutons pour les mettres à jour
	 */
	
	private MenuPrincipalView view;
	private MenuPrincipalModel model;
	
	public MenuPrincipalController(MenuPrincipalView view, MenuPrincipalModel model) {
		this.model = model;
		this.view = view;
		
		view.setVisible(true);
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Effets de style sur les boutons quand on passe la souris dessus
		
		view.getDemoLabel().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getDemoLabel().setIcon(model.getDemoActive());
				}
			});		
	
		view.getJ1Label().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getJ1Label().setIcon(model.getJ1Active());
			}
		});
		
		view.getJ2Label().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getJ2Label().setIcon(model.getJ2Active());
			}
		});
		
		// Si la souris touche le fond d'écran, les boutons sont remis à jour
		
		view.getBackgroundLabel().addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				view.getDemoLabel().setIcon(view.getDemoPasActive());
				view.getJ1Label().setIcon(view.getJ1PasActive());
				view.getJ2Label().setIcon(view.getJ2PasActive());
			}
		});
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Ouverture d'une nouvelle View en fonction du bouton qui a été cliqué
		
		view.getDemoLabel().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				DemoView demoView = new DemoView();
				
				DemoModel demoModel = new DemoModel();
				
				DemoController demoController = new DemoController(demoView, demoModel); 
				
				view.setVisible(false);
			}
		});		
	
		view.getJ1Label().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				SousMenuView sousMenuView = new SousMenuView();
				
				SousMenuModel sousMenuModel = new SousMenuModel();
				
				SousMenuController sousMenuController = new SousMenuController(sousMenuView, sousMenuModel, "1 Joueur"); 
				
				view.setVisible(false);
			}
		});
		
		view.getJ2Label().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				
				SousMenuView sousMenuView = new SousMenuView();
				
				SousMenuModel sousMenuModel = new SousMenuModel();
				
				SousMenuController sousMenuController = new SousMenuController(sousMenuView, sousMenuModel, "2 Joueurs"); 
				view.setVisible(false);
			}
		});
	}
	
}
