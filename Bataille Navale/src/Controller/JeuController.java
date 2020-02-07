package Controller;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
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
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int width = (int)screenSize.getWidth();
    public int height = (int)screenSize.getHeight();
	private JeuView view;
	private JeuModel model;
	private static boolean turnPlayer1;
	private static boolean turnPlayer2;
	private JButton bouton;
	private ImageIcon ready = new ImageIcon(new ImageIcon(this.getClass().getResource("/pret.png")).getImage());
	public static JButton boutonShipG, boutonShipD;
	public static boolean shipGClear,shipDClear;
	public static JeuController control;

	public JeuController(JeuView view, JeuModel model) {
		this.view = view;
		this.model = model;
		this.shipGClear = false;
		this.shipDClear = false;
		/* affiche les boutons de bateaux pret */
		view.panelShipG.setVisible(true);
		boutonShipG = new JButton(ready);
		boutonShipG.setBounds(0,0, 3*width/28, 50);
		view.panelShipG.add(boutonShipG);
		boutonShipG.addActionListener(event -> model.clearAllShipLabel(this, view.gridGauche));
		if (view.getNbJoueur()==2) {
			view.panelShipD.setVisible(true);
			boutonShipD = new JButton(ready);
			boutonShipD.setBounds(0,0, 3*width/28, 50);
			view.panelShipD.add(boutonShipD);
			boutonShipD.addActionListener(event -> model.clearAllShipLabel(this, view.gridDroite));
		}else {
			/* place les bateaux */
			model.AlgoBateau();
			model.printGrilleDroite();
			shipDClear = true;
		}
 
	}
	
	public void startGame() {
		if(shipGClear && shipDClear) {
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
				clickArtillerie(3);
			}
			
			else if (view.mode == 4) {
				clickArtillerie(4);
			}
		}
	}
	
	public boolean isBoardComplete(int[][] tab) {
		// sets complete to true
		boolean complete = true;

		// will change complete to false
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (tab[i][j] >= 5) {
					complete = false;
				}
			}
		}
		return complete;
	}

	private void caseClick(Case caseCase,String g) {
		// mode 1 joueur contre le bot
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
			JeuView.prompteur.setText("AU TOUR DU JOUEUR 2");
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
			JeuView.prompteur.setText("AU TOUR DU JOUEUR 1");
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
		AnimArtillerie anim = new AnimArtillerie(PlateauView.getListeDroite(), mode, control, view);
		view.panelTir.add(anim.getButton(), 0);
	}

	public void checkTurnPlay1wBot() {
		if (isBoardComplete(view.gridDroite)||isBoardComplete(view.gridGauche)) {
			view.finish();
			
		} else {
			setTimeout(() -> view.bot.playMove(), 1500);
		}
	}
	public void checkTurnPlay() {
		if (isBoardComplete(view.gridDroite) || isBoardComplete(view.gridGauche)) {
			view.finish();
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
		if(e.getSource()==view.Bquitter) {
			this.view.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}