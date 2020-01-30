package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.AnimCase;
import Model.AnimRadar;
import Model.Case;
import Model.JeuModel;
import Model.Sound;
import View.JeuView;
import View.PlateauView;

public class JeuController {
	private JeuView view;
	private JeuModel model;
	private boolean turnPlayer;
	
	public JeuController(JeuView view, JeuModel model) {
		this.view = view;
		this.model = model;
		turnPlayer = true;
		
		
		
		/*view.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				System.out.println("Mouse was clicked on my frame! x = " +e.getX()+" y = "+e.getY());
			}
		});*/
		
		view.plateauView1.getListeGauche().forEach((n) -> n.getButton().addMouseListener(new java.awt.event.MouseAdapter()
	    {
	        public void mouseReleased(java.awt.event.MouseEvent evt)
	        {
	           if(ShipController.placeShip==true) {
	        	   if(view.gridGauche[n.getX()][n.getY()] == 0) {
	        		   view.gridGauche[n.getX()][n.getY()] = 1;
	        		   ShipController.placeShip=false;
	        		   model.printGrille();
	        	   }
	           }
	        }
	    }));
		
		PlateauView.getListeDroite().forEach((n) -> n.getButton().addActionListener(event -> caseClick(n)));
	}
	
	public void setTab(Case caseCase) {
		view.gridGauche[caseCase.getX()][caseCase.getY()] = 1;
	}
	
	public boolean isBoardComplete(int [][] tab)
	{
		// sets complete to true
		boolean complete = true;
		
		//will change complete to false
		for (int i = 0; i < 10; i++)
		{
			for(int j =0; j < 10; j++)
			{
				if (tab[i][j] == 1 || tab[i][j] == 5 || tab[i][j] == 6 || tab[i][j] == 7)
				{
					complete = false;
				}
			}
		}
		return complete;
	}
	
	private void caseClick(Case caseCase) {
		
		
		if(turnPlayer  == true) {
			clickAnim(caseCase);
	        clickRadar(caseCase);
			
	        checkTurn();
	        
	        turnPlayer = false;
	        
	        setTimeout(() -> turnPlayer = true, 3000);
		}
		
    }
	public static void setTimeout(Runnable runnable, int delay){
	    new Thread(() -> {
	        try {
	            Thread.sleep(delay);
	            runnable.run();
	        }
	        catch (Exception e){
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
	
	public void checkTurn() {
		if(isBoardComplete(view.gridDroite)) {
			view.finish();
		}
		else {
			setTimeout(() -> view.bot.playMove(), 1500);
		}
	}
}
