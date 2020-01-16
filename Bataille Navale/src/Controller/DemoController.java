package Controller;

import Model.DemoModel;
import Model.MenuPrincipalModel;
import View.DemoView;

public class DemoController {
	private DemoView view;
	private DemoModel model;
	
	public DemoController(DemoView view, DemoModel model) {
		view.setVisible(true);
	}
}
