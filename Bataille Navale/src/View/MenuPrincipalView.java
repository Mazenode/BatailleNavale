package View;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class MenuPrincipalView extends JFrame {
	
	/*Içi on déclare et initialise touts les composants du menu principal, le fond d'écran 
	 * ainsi que les boutons (sous forme de JLabel).
	 * On choisit içi de de déclarer les images dans la vue et non dans le modèle pour éviter de trop solliciter
	 * le contrôleur, surtout lorsque l'utilisateur est inactif
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int)screenSize.getWidth();
	int height = (int)screenSize.getHeight();
	
	private ImageIcon imgBackground = new ImageIcon(new ImageIcon(this.getClass().getResource("/menu.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgDemoPasActif = new ImageIcon(new ImageIcon(this.getClass().getResource("/demo_pas_active.png")).getImage().getScaledInstance(2*width/8, height/10, Image.SCALE_DEFAULT));
	private ImageIcon imgJ1pasActif = new ImageIcon(new ImageIcon(this.getClass().getResource("/joueur1_pas_active.png")).getImage().getScaledInstance(2*width/8, height/10, Image.SCALE_DEFAULT));
	private ImageIcon imgJ2pasActif = new ImageIcon(new ImageIcon(this.getClass().getResource("/joueur2_pas_active.png")).getImage().getScaledInstance(2*width/8, height/10, Image.SCALE_DEFAULT));
	
	private JLabel background, boutonDemo, boutonJ1, boutonJ2;

	public MenuPrincipalView(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width,height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
	
		
		boutonDemo = new JLabel(imgDemoPasActif);
		boutonDemo.setBounds(3*width/8,6*height/12,2*width/8,height/10);
		add(boutonDemo);
		
		boutonJ1 = new JLabel(imgJ1pasActif);
		boutonJ1.setBounds(3*width/8,8*height/12,2*width/8,height/10);
		add(boutonJ1);
		
		boutonJ2 = new JLabel(imgJ2pasActif);
		boutonJ2.setBounds(3*width/8,10*height/12,2*width/8,height/10);
		add(boutonJ2);
		

		background = new JLabel("", imgBackground, JLabel.CENTER);
		background.setBounds(0,0,width,height);
		add(background);
		
		
	}
	
	public final JLabel getDemoLabel(){
        return boutonDemo;
    }
	
	public final JLabel getJ1Label(){
        return boutonJ1;
    }
	
	public final JLabel getJ2Label(){
        return boutonJ2;
    }
	
	public final JLabel getBackgroundLabel(){
        return background;
    }
	
	public final ImageIcon getDemoPasActive(){
        return imgDemoPasActif;
    }
	
	public final ImageIcon getJ1PasActive(){
        return imgJ1pasActif;
    }
	
	public final ImageIcon getJ2PasActive(){
        return imgJ2pasActif;
    }
}
