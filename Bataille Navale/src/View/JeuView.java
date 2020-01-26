package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints; 
import java.awt.event.*;
import javax.swing.Action;
 
public class JeuView extends JFrame {
	private ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/jeu.png"));
	public int x = 1920;
	public int y = 1080;
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
	private JLabel background;
	
	public JeuView() {
		this.setSize(1920, 1080);
		this.setLayout(null);
		
		background = new JLabel("", imgBackground, JLabel.CENTER);
		background.setBounds(0,0, x, y);

		
		GridBagConstraints gbc = new GridBagConstraints();
	
		GridBagConstraints c = new GridBagConstraints();
	
		
		
		PlateauView plateauView1 = new PlateauView(20,20);
		PlateauView plateauView2 = new PlateauView(width*3/5,height*1/3);

		add(plateauView1);
		
		add(plateauView2);

		plateauView1.setBounds(385, 280, 700, 700); //modifie la taille du comteneur de la grille doit etre egale a la taille de la grille
		plateauView1.setBackground(new Color (217,217,216));
		plateauView2.setBounds(1110, 280, 700, 700);
		plateauView2.setBackground(new Color (217,217,216));
		add(background);

		this.setUndecorated(true);
		this.setVisible(true);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				System.out.println("Mouse was clicked on my frame! x = " +e.getX()+" y = "+e.getY());
			}
		});
	
	}
	
	
}
