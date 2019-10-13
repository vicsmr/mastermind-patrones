package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import mastermind.views.console.menu.StartMenu;
import santaTecla.utils.WithConsoleView;

class StartView extends WithConsoleView {
	
	public void interact(StartController startController) {
		MessageView.TITLE.writeln();
		new StartMenu(startController).execute();
		new GameView(startController).writeln();
	}

}
