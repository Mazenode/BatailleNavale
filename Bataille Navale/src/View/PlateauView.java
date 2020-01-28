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

import Model.Case;

import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

public class PlateauView extends JPanel {
	private ArrayList<Case> liste = new ArrayList<>();
    private static final int SIZE = 10;
    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
    private int tab[][];
    
    public PlateauView(){
    	
    }
    
    public PlateauView(int posx, int posy, int tab[][]) {
        //this.setLayout(null);
        this.setVisible(true);
        JPanel p = new JPanel();
        
       this.tab = tab;
        
        p.setLayout(new GridLayout(SIZE, SIZE));
        p.setPreferredSize(new Dimension(700,700)); // taille de la grille 
        p.setBackground(Color.RED);
        for (int j = 0; j < SIZE * SIZE; j++) { // permet de mettre les 100 bouttons
            JButton button = new JButton();
            button.setBackground(new Color (23,26,63));
            int x = j / SIZE;
            int y = j % SIZE;
            Case caseCase = new Case(button, x, y);
            liste.add(caseCase);
            p.add(button);
            add(p);
        }
    }
    
    
    ArrayList<Case> getListe(){
    	return liste;
    }
	
}