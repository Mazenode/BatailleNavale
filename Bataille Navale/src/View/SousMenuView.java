package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	private ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("/sous-menu-basique.png"));
	private ImageIcon imgMode1 = new ImageIcon(this.getClass().getResource("/bouton-mode-1.png"));
	private ImageIcon imgMode2 = new ImageIcon(this.getClass().getResource("/bouton-mode-2.png"));
	private ImageIcon imgMode3 = new ImageIcon(this.getClass().getResource("/bouton-mode-3.png"));
	private ImageIcon imgMode4 = new ImageIcon(this.getClass().getResource("/bouton-mode-4.png"));
	private JLabel bg, mode1, mode2, mode3, mode4, popUp, text;
	
	public SousMenuView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setSize(width, height);
		this.setUndecorated(true);
		
		mode1 = new JLabel(imgMode1);
		mode1.setBounds(posX, posY,370,85);
		add(mode1);
		
		mode2 = new JLabel(imgMode2);
		mode2.setBounds(posX, posY + 90,370,85);
		add(mode2);
		
		mode3 = new JLabel(imgMode3);
		mode3.setBounds(posX, posY + 180,370,85);
		add(mode3);
		
		mode4 = new JLabel(imgMode4);
		mode4.setBounds(posX, posY + 270,370,85);
		add(mode4);
		
		text = new JLabel();
		text.setForeground(Color.white);
		text.setFont(new Font("Arial", Font.BOLD, 25));
		text.setBounds(posX - posX/3, posY*2 + posY/2 - posY/9, 1100,500);
		add(text);
		
		popUp = new JLabel();
		popUp.setBounds(posX - posX/2 + posX/60, posY*2 + posY/6, 1100,500);
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
