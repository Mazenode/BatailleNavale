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
	private static ArrayList<Case> listeGauche = new ArrayList<>();
	private static ArrayList<Case> listeDroite = new ArrayList<>();
    private static final int SIZE = 10;
    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
    private int tab[][];
    
    public PlateauView(){
    	
    }
    
    public PlateauView(int posx, int posy, int tab[][], boolean botOrNot) {
        //this.setLayout(null);
        this.setVisible(true);
        JPanel p = new JPanel();
        
        
       this.tab = tab;
        
        p.setLayout(new GridLayout(SIZE, SIZE));
        p.setPreferredSize(new Dimension(10*width/28,10*width/28)); // taille de la grille 
        for (int j = 0; j < SIZE * SIZE; j++) { // permet de mettre les 100 bouttons
            JButton button = new JButton();
            button.setBackground(new Color (23,26,63));
            int x = j / SIZE;
            int y = j % SIZE;
            Case caseCase = new Case(button, x, y);
            if(botOrNot) {
                listeGauche.add(caseCase);
            }
            else {
            	listeDroite.add(caseCase);
            }
            p.add(button);
            add(p);
            this.setBackground(new Color (217,217,216));
        }
    }
    
    
    public static ArrayList<Case> getListeGauche(){
    	return listeGauche;
    }
    
    public static ArrayList<Case> getListeDroite(){
    	return listeDroite;
    }
	
}