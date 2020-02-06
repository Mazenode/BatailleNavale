package Model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Controller.JeuController;
import View.Bot;
import View.JeuView;
import View.PlateauView;

public class AnimArtillerie {
	private JButton bouton;
	private int tempo = 0;
	private boolean firstClick = false;
	private tt t1;
	private Thread thread;
	private int y, x = 0;
	private ArrayList<Case> listeCase;
	private ImageIcon cible = new ImageIcon(this.getClass().getResource("/cible.png"));
	private ImageIcon splash = new ImageIcon(this.getClass().getResource("/splash-finale.png"));
	private ImageIcon explosion = new ImageIcon(this.getClass().getResource("/explosion-finale.png"));
	private ImageIcon fond = new ImageIcon(this.getClass().getResource("/artillerie.png"));
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int width = (int)screenSize.getWidth();
	public int height = (int)screenSize.getHeight();
	private int mode;
	private Bot bot;
	private boolean turnPlayer = true;
	
	public AnimArtillerie(ArrayList<Case> listeCase, int mode) {
		this.listeCase = listeCase;
		this.mode = mode;
		
		bot = new Bot();
		
		bouton = new JButton();
		bouton.setBounds(500 , 100, 200, 50);

		t1 = new tt();
		
		bouton.addActionListener((event) -> cible());
		
		/*if(turnPlayer == true) {
			
			checkTurn();
		}*/
		
		}
	
	public JButton getButton() {
		return bouton;
	}
	
	public void cible() {
		
		if(tempo == 0) {
			tempo = 1;
			thread = new Thread(t1);
			thread.start();
			

		}
		else if(tempo == 1) {
			tempo = 2;
		}
		else {
			tempo = 0;
			thread.stop();
			if(mode == 3) {
				AnimCase anim = new AnimCase(listeCase.get((y) * 10 + x), JeuModel.getGridDroite());
				if(AnimCase.getEvent() == 1) {
					listeCase.get((y) * 10 + x).setValue(2);
				}
				else {
					listeCase.get((y) * 10 + x).setValue(3);
				}
				checkTurn();
				
			}
			else if(mode == 4) {
                AnimCase anim = new AnimCase(listeCase.get((y) * 10 + x), JeuModel.getGridDroite());
                if(AnimCase.getEvent() == 1) {
                    listeCase.get((y) * 10 + x).setValue(2);
                    JeuView.gridDroite[listeCase.get((y) * 10 + x).getX()][listeCase.get((y) * 10 + x).getY()] = 2; 
                }
                else if(AnimCase.getEvent() == 2){
                    listeCase.get((y) * 10 + x).setValue(3);
                    JeuView.gridDroite[listeCase.get((y) * 10 + x).getX()][listeCase.get((y) * 10 + x).getY()] = 3; 
                    AnimRadar radar = new AnimRadar(listeCase.get((y) * 10 + x), listeCase, JeuView.gridDroite);
                }
                checkTurn();
            }
			
		}	
	
	}
	
	public class tt implements Runnable{

		@Override
		public void run() {
			
			  while(tempo == 1) {
				  try {
					  y = (y + 1) % 10;
						for(int j = 0; j < 100; j++) {
							
							if(listeCase.get(j).getButton().getIcon() != null) {
								if(listeCase.get(j).getButton().getIcon().equals(fond)){
									listeCase.get(j).getButton().setIcon(null);
								}
								
							}
							
						}
					  
					for(int i = 0; i < 10; i++) {
						if (listeCase.get(y * 10 + i).getValue() == 3) {
					  		listeCase.get((y)*10 + i).getButton().setIcon(splash);
					  	}
						else if (listeCase.get(y * 10 + i).getValue() == 2) {
					  		listeCase.get((y)*10 + i).getButton().setIcon(explosion);
					  	}
						else {
							listeCase.get(y * 10 + i).getButton().setIcon(fond);
						}			
					}
					
					
					
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }	
			  
			  while(tempo == 2) {
				  
				  try {
					  
					  for(int i = 0; i < 10; i++) {
									
						  	x = i;
						  	
						  	listeCase.get((y)*10 + i).getButton().setIcon(cible);
						  	if(listeCase.get((y)*10 + i).getValue() == 3) {
						  		listeCase.get((y)*10 + i).getButton().setIcon(splash);
						  	}
						  	else if(listeCase.get((y)*10 + i).getValue() == 2) {
						  		listeCase.get((y)*10 + i).getButton().setIcon(explosion);
						  	}

							Thread.sleep(300);
							listeCase.get((y)*10 + i).getButton().setBackground(new Color(22, 26, 63));
							listeCase.get((y)*10 + i).getButton().setIcon(fond);
							if(listeCase.get((y)*10 + i).getValue() == 3) {
						  		listeCase.get((y)*10 + i).getButton().setIcon(splash);
						  	}
							else if(listeCase.get((y)*10 + i).getValue() == 2) {
						  		listeCase.get((y)*10 + i).getButton().setIcon(explosion);
						  	}
						}
					 		
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }	
		}
	}
	public void checkTurn() {
		/*if (JeuController.isBoardComplete(JeuView.gridDroite)) {
			
			
		} else {*/
			//JeuView.setTextPrompteur("Au tour de l'ordinateur");

			JeuController.setTimeout(() -> bot.playMove(), 1500);
		//}
	}
}
