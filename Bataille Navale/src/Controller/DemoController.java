package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.DemoModel;
import Model.MenuPrincipalModel;
import View.DemoView;
import View.MenuPrincipalView;

public class DemoController implements KeyListener{
	private DemoView view;
	private DemoModel model;
	
	/*Cette variable est imcrémentée à chaque étape de la démo.
	Par exemple : etape = 0 -> on affiche le texte 1, etape = 1 -> on affiche le texte 2, etc... */
	private int etape = 0;
	
	public DemoController(DemoView view, DemoModel model) {
		
		this.model = model;
		this.view = view;
		
		
		this.view.addKeyListener(this);
		view.setVisible(true);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			etape++;
			if(etape>9) {
				view.setVisible(false);
				
				MenuPrincipalView menuPrincipalView = new MenuPrincipalView();
				
				MenuPrincipalModel menuPrincipalModel = new MenuPrincipalModel();
				
				MenuPrincipalController menuPrincipalController = new MenuPrincipalController(menuPrincipalView, menuPrincipalModel);
			}
			else {
				view.getBackgroundLabel().setIcon(model.getImage(etape));
			}			
		}			
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
