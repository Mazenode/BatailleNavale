package Controller;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import Model.AnimArtillerie;
import Model.AnimCase;
import Model.AnimRadar;
import Model.Case;
import Model.JeuModel;
import Model.Sound;
import View.JeuView;
import View.PlateauView;

public class JeuController implements KeyListener {
	private JeuView view;
	private JeuModel model;
	private static boolean turnPlayer;
	private JButton bouton;

	public JeuController(JeuView view, JeuModel model) {
		this.view = view;
		this.model = model;
		turnPlayer = true;

		/*
		 * view.addMouseListener(new MouseAdapter() { public void
		 * mouseClicked(MouseEvent e){
		 * System.out.println("Mouse was clicked on my frame! x = "
		 * +e.getX()+" y = "+e.getY()); } });
		 */

		/*
		 * view.plateauView1.getListeGauche().forEach((n) ->
		 * n.getButton().addMouseListener(new java.awt.event.MouseAdapter() { public
		 * void mouseReleased(java.awt.event.MouseEvent evt) {
		 * if(ShipController.placeShip==true) { if(view.gridGauche[n.getX()][n.getY()]
		 * == 0) { view.gridGauche[n.getX()][n.getY()] = 1;
		 * ShipController.placeShip=false; model.printGrille(); } } } }));
		 */
		
		if(view.mode == 1 || view.mode== 2) {
			this.view.addKeyListener(this);
			PlateauView.getListeDroite().forEach((n) -> n.getButton().addActionListener(event -> caseClick(n)));
		}
		else if (view.mode == 3) {
			view.add(view.getBouton());
			view.getBouton().addActionListener(event -> view.getBouton().setVisible(false) );
			clickArtillerie(3);
		}
		
		else if (view.mode == 4) {
			view.add(view.getBouton());
			view.getBouton().addActionListener(event -> view.getBouton().setVisible(false) );
			clickArtillerie(4);
		}
 
	}

	public void setTab(Case caseCase) {
		view.gridGauche[caseCase.getX()][caseCase.getY()] = 1;
	}

	public boolean isBoardComplete(int[][] tab) {
		// sets complete to true
		boolean complete = true;

		// will change complete to false
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (tab[i][j] > 2) {
					complete = false;
				}
			}
		}
		return complete;
	}

	private void caseClick(Case caseCase) {
		
		if (turnPlayer == true) {
			if (view.mode == 1) {
				clickAnim(caseCase);
			} 
			else if (view.mode == 2) {
				clickRadar(caseCase);
			}
			
			

			checkTurn();

			turnPlayer = false;

			setTimeout(() -> turnPlayer = true, 3000);
		}

	}

	public static void setTimeout(Runnable runnable, int delay) {
		new Thread(() -> {
			try {
				Thread.sleep(delay);
				runnable.run();
			} catch (Exception e) {
				System.err.println(e);
			}
		}).start();
	}

	public void clickAnim(Case caseCase) {
		AnimCase anim = new AnimCase(caseCase, view.gridDroite);
	}

	public void clickRadar(Case caseCase) {
		AnimRadar radar = new AnimRadar(caseCase, PlateauView.getListeDroite(), view.gridDroite);
	}
	
	public void clickArtillerie(int mode) {
		AnimArtillerie anim = new AnimArtillerie(PlateauView.getListeDroite(), mode);
		view.add(anim.getButton());
	}

	public void checkTurn() {
		if (isBoardComplete(view.gridDroite)) {
			view.finish();
			
		} else {
			setTimeout(() -> view.bot.playMove(), 1500);
		}
	}
	
	public static boolean getTurnPlayer(){
        return turnPlayer;
    }

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			this.view.setVisible(false);
			System.exit(0);
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}