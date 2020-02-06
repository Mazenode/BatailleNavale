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
	private static boolean turnPlayer1;
	private static boolean turnPlayer2;
	private JButton bouton;

	public JeuController(JeuView view, JeuModel model) {
		this.view = view;
		this.model = model;
		turnPlayer1 = true;
		turnPlayer2 = false;

		if(view.mode == 1 || view.mode== 2) {
			this.view.addKeyListener(this);
			PlateauView.getListeDroite().forEach((n) -> n.getButton().addActionListener(event -> caseClick(n,"a clic sur j2")));//j'ai changer ça pour savoir su quelle grille on clic
			if (view.getNbJoueur() == 2){
				PlateauView.getListeGauche().forEach((n) -> n.getButton().addActionListener(event -> caseClick(n,"a clic sur j1")));
			}
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

	public static boolean isBoardComplete(int[][] tab) {
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

	private void caseClick(Case caseCase,String g) {
		// mode 1 joueur contre le bot
		System.out.println(turnPlayer1);
		if (turnPlayer1 && view.getNbJoueur() == 1) {
			if (view.mode == 1) {
				clickAnim(caseCase);
			}
			else if (view.mode == 2) {
				clickRadar(caseCase);
			}

			checkTurnPlay1wBot();

			turnPlayer1 = false;

			setTimeout(() -> turnPlayer1 = true, 3000);
		}
		// mode 2 joueur (plutôt tour par tour)
		//System.out.println("turnplayer1 : " +turnPlayer1 +" turnplayer2: " + turnPlayer2);
		else if (turnPlayer1 && view.getNbJoueur() == 2 && g.equals("a clic sur j2")){
			if (view.mode == 1) {
				clickAnim(caseCase);
			}
			else if (view.mode == 2) {
				clickRadar(caseCase);
				
			}
			checkTurnPlay();
			turnPlayer1 = false;
			turnPlayer2 = true;

		}

		else if (turnPlayer2 && view.getNbJoueur() == 2 && g.equals("a clic sur j1")){
			if (view.mode == 1) {
				clickAnim(caseCase);
			}
			else if (view.mode == 2) {
				clickRadar(caseCase);
			}
			checkTurnPlay();
			turnPlayer1 = true;
			turnPlayer2 = false;
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
		if (turnPlayer1){
			AnimCase anim = new AnimCase(caseCase, view.gridDroite);
		}
		else {
			AnimCase anim = new AnimCase(caseCase, view.gridGauche);
		}
	}


	public void clickRadar(Case caseCase) {
		AnimRadar radar = new AnimRadar(caseCase, PlateauView.getListeDroite(), view.gridDroite);
	}
	
	public void clickArtillerie(int mode) {
		AnimArtillerie anim = new AnimArtillerie(PlateauView.getListeDroite(), mode);
		view.add(anim.getButton());
	}

	public void checkTurnPlay1wBot() {
		if (isBoardComplete(view.gridDroite)) {
			view.finish();
			
		} else {
			setTimeout(() -> view.bot.playMove(), 1500);
		}
	}
	public void checkTurnPlay() {
		if (isBoardComplete(view.gridDroite) || isBoardComplete(view.gridGauche)) {
			view.finish();

		} if(turnPlayer1) {
			turnPlayer1 = false;
			turnPlayer2 = true;
		}
		else {
			turnPlayer1 = true;
			turnPlayer2 = false;
		}
	}

	
	public static boolean getTurnPlayer(){
        return turnPlayer1;
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