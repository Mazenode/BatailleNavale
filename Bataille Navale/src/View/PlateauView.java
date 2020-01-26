package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.*;

public class PlateauView extends JPanel {
    private static final int SIZE = 10;
    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
    public PlateauView(){

    }
    public PlateauView(int posx, int posy) {
        //this.setLayout(null);
        this.setVisible(true);
        JPanel p = new JPanel();
        
        p.setLayout(new GridLayout(SIZE, SIZE));
        p.setPreferredSize(new Dimension(700,700)); // taille de la grille 
        p.setBackground(Color.RED);
        for (int j = 0; j < SIZE * SIZE; j++) { // permet de mettre les 100 bouttons
            JButton button = new JButton();
            button.setBackground(new Color (23,26,63));
            int x = j / SIZE;
            int y = j % SIZE;
            button.addActionListener(event -> caseClick(button, x, y));
        
            p.add(button);
            add(p);
        }
    }

    private void caseClick(JButton button, int x, int y) {
        // l� tu mets le code � ex�cuter quand on clique sur la case
        System.out.println("Vous avez cliqué la case colonne="+x+", ligne="+y);
        if (button.getBackground().equals(Color.RED)){
            button.setBackground(new Color (23,26,63));
        }
        else{
            button.setBackground(Color.RED);
        }
        
    }
	
}