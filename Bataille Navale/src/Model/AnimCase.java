package Model;

import javax.swing.ImageIcon;

public class AnimCase {
	private ImageIcon explosion = new ImageIcon(this.getClass().getResource("/explosion.gif"));
	private ImageIcon splash = new ImageIcon(this.getClass().getResource("/splash.gif"));
	private int grid[][];
	private static int event;

	public AnimCase(Case caseCase, int grid[][]) {
		this.grid = grid;

            if(grid[caseCase.getX()][caseCase.getY()] >= 5) {
            	grid[caseCase.getX()][caseCase.getY()] = 2;
    			explosion.getImage().flush();
    			caseCase.getButton().setIcon(explosion);
    			event = 1;
    			Sound.playSound("/big-explosion-sound.wav");
    		}
    		
    		if(grid[caseCase.getX()][caseCase.getY()] == 0) {		
    			grid[caseCase.getX()][caseCase.getY()] = 3;
    			splash.getImage().flush();
    			caseCase.getButton().setIcon(splash);
    			event = 2;
    			Sound.playSound("/splash-sound.wav");
    		}
	}
	
	public static int getEvent() {
		return event;
	}
}