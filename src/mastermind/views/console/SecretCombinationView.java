package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class SecretCombinationView extends WithConsoleView {
	
	private Controller controller;
	
	protected SecretCombinationView(Controller controller) {
		super();
		this.controller = controller;
	}
	
	protected void writeln() {
		for (int i = 0; i < this.controller.getWidth(); i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}
	
}
