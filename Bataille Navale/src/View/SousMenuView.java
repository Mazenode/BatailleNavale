package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SousMenuView extends JFrame{
	public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();
    private int posX = width/2 - width/10;
    private int posY = height/4;
	private ImageIcon imgBackground = new ImageIcon(new ImageIcon(this.getClass().getResource("/sous-menu-basique.png")).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	private ImageIcon imgMode1 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-mode-1.png")).getImage().getScaledInstance(2*width/9, height/12, Image.SCALE_DEFAULT));
	private ImageIcon imgMode2 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-mode-2.png")).getImage().getScaledInstance(2*width/9,height/12, Image.SCALE_DEFAULT));
	private ImageIcon imgMode3 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-mode-3.png")).getImage().getScaledInstance(2*width/9,height/12, Image.SCALE_DEFAULT));
	private ImageIcon imgMode4 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-mode-4.png")).getImage().getScaledInstance(2*width/9,height/12, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau1 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-1.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau2 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-2.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau3 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-3.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau4 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-4.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private ImageIcon imgChoixBateau5 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-5.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private ImageIcon imgDefaultChoixBateau5 = new ImageIcon(new ImageIcon(this.getClass().getResource("/bouton-bateau-5-active.png")).getImage().getScaledInstance(width/28, width/28, Image.SCALE_DEFAULT));
	private JLabel bg, mode1, mode2, mode3, mode4, popUp, text, bateau1, bateau2, bateau3, bateau4, bateau5, textBateau;
	
	public SousMenuView(int nbJoueur) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setSize(width, height);
		this.setUndecorated(true);
		
		mode1 = new JLabel(imgMode1);
		mode1.setBounds(posX, posY,2*width/9, height/12);
		add(mode1);
		
		mode2 = new JLabel(imgMode2);
		mode2.setBounds(posX, posY +5+ height/12,2*width/9,height/12);
		add(mode2);
		
		mode3 = new JLabel(imgMode3);
		mode3.setBounds(posX, posY +10+ 2*height/12,2*width/9,height/12);
		add(mode3);
		
		mode4 = new JLabel(imgMode4);
		mode4.setBounds(posX, posY +15+ 3*height/12,2*width/9,height/12);
		add(mode4);
		
		if(nbJoueur == 2) {
			mode2.setVisible(false);
			mode3.setVisible(false);
			mode4.setVisible(false);
		}
		
		bateau1 = new JLabel(imgChoixBateau1);
		bateau1.setBounds((width/2)-(width/56)-4*width/28, posY-width/28,width/28, width/28);
		add(bateau1);
		
		bateau2 = new JLabel(imgChoixBateau2);
		bateau2.setBounds((width/2)-(width/56)-2*width/28, posY-width/28,width/28, width/28);
		add(bateau2);
		
		bateau3 = new JLabel(imgChoixBateau3);
		bateau3.setBounds((width/2)-(width/56), posY-width/28,width/28, width/28);
		add(bateau3);
		
		bateau4 = new JLabel(imgChoixBateau4);
		bateau4.setBounds((width/2)-(width/56)+2*width/28, posY-width/28,width/28, width/28);
		add(bateau4);
		
		bateau5 = new JLabel(imgDefaultChoixBateau5);
		bateau5.setBounds((width/2)-(width/56)+4*width/28, posY-width/28,width/28, width/28);
		add(bateau5);

		textBateau = new JLabel("<html>Nombre de bateau (5 par défaut)</html>");
		textBateau.setForeground(Color.white);
		textBateau.setFont(new Font("Arial", Font.BOLD, width/40));
		textBateau.setBounds(posX - posX/3, posY-3*width/28, 16*width/11,2*width/28);
		add(textBateau);
		
		text = new JLabel();
		text.setForeground(Color.white);
		text.setFont(new Font("Arial", Font.BOLD, width/80));
		text.setBounds(posX - posX/3, posY*2 + posY/2 - posY/9, 16*width/11,height/2);
		add(text);
		
		popUp = new JLabel();
		popUp.setBounds(posX - posX/2 + posX/60, posY*2 + posY/6, 16*width/11,height/2);
		add(popUp);
		
		bg = new JLabel(imgBackground);
		bg.setBounds(0,0,width,height);
		add(bg);
	}
	
	public final JLabel getBg() {
		return bg;
	}
	
	public final JLabel getMode1() {
		return mode1;
	}
	
	public final JLabel getMode2() {
		return mode2;
	}
	
	public final JLabel getMode3() {
		return mode3;
	}
	
	public final JLabel getMode4() {
		return mode4;
	}
	
	public final JLabel getShip1() {
		return bateau1;
	}
	
	public final JLabel getShip2() {
		return bateau2;
	}
	
	public final JLabel getShip3() {
		return bateau3;
	}
	
	public final JLabel getShip4() {
		return bateau4;
	}
	
	public final JLabel getShip5() {
		return bateau5;
	}
	
	public ImageIcon getShip1Img() {
		return imgChoixBateau1;
	}
	
	public ImageIcon getShip2Img() {
		return imgChoixBateau2;
	}
	
	public ImageIcon getShip3Img() {
		return imgChoixBateau3;
	}
	
	public ImageIcon getShip4Img() {
		return imgChoixBateau4;
	}
	
	public ImageIcon getShip5Img() {
		return imgChoixBateau5;
	}
	
	public final JLabel getPopUp() {
		return popUp;
	}
	
	public final JLabel getTextPopUp() {
		return text;
	}
	
	public final ImageIcon getMode1Image() {
		return imgMode1;
	}
	
	public final ImageIcon getMode2Image() {
		return imgMode2;
	}
	
	public final ImageIcon getMode3Image() {
		return imgMode3;
	}
	
	public final ImageIcon getMode4Image() {
		return imgMode4;
	}
}
