package Model;

import javax.swing.ImageIcon;

public class AnimCase {
	private ImageIcon explosion = new ImageIcon(this.getClass().getResource("/explosion.gif"));
	private ImageIcon splash = new ImageIcon(this.getClass().getResource("/splash.gif"));
	private int grid[][];

	public AnimCase(Case caseCase, int grid[][]) {
		this.grid = grid;

            if(grid[caseCase.getX()][caseCase.getY()] >= 5) {
            	grid[caseCase.getX()][caseCase.getY()] = 2;
    			explosion.getImage().flush();
    			caseCase.getButton().setIcon(explosion);
    			Sound.playSound("/big-explosion-sound.wav");
    		}
    		
    		if(grid[caseCase.getX()][caseCase.getY()] == 0) {		
    			grid[caseCase.getX()][caseCase.getY()] = 3;
    			splash.getImage().flush();
    			caseCase.getButton().setIcon(splash);
    			Sound.playSound("/splash-sound.wav");
    		}
        
	}
	
}