package View;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
public class PlateauView extends JPanel{
    private ImageIcon imgButton = new ImageIcon(this.getClass().getResource("/Button.png"));
    private ImageIcon imgGrille = new ImageIcon(this.getClass().getResource("/Grille.png"));
    private static final int SIZE = 10;
    public PlateauView() {
    	this.setLayout(null);
        this.setVisible(true);
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(SIZE,SIZE));
        p.setBounds(500,500,1000,500);
        

        for (int j = 0; j < SIZE*SIZE; j++) { //permet de mettre les 100 bouttons
            JButton button = new JButton(imgButton);
            button.setBounds(0, 0, 50, 50);
            int x = j/SIZE;
            int y = j%SIZE;
            button.addActionListener(event->caseClick(button, x, y));
            p.add(button);
            add(p);
        }
        
        /*JButton button = new JButton();
        button.setBackground(Color.blue);
        button.setBounds(0, 0, 500, 500);
        */
        
        //add(Grille);
    }

	private void caseClick(JButton button, int x, int y) {
        // l� tu mets le code � ex�cuter quand on clique sur la case
        System.out.println("Vous avez cliqué la case colonne="+x+", ligne="+y);
 
    }
	
}