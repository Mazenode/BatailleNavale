package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.JeuModel;
import View.JeuView;

public class JeuController {
	private JeuView view;
	private JeuModel model;
	
	public JeuController(JeuView view, JeuModel model) {
		this.view = view;
		this.model = model;
		
		
		
		view.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				System.out.println("Mouse was clicked on my frame! x = " +e.getX()+" y = "+e.getY());
			}
		});
	}
}
