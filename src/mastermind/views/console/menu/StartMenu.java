package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.views.console.commands.NewGameCommand;
import mastermind.views.console.commands.OpenGameCommand;
import santaTecla.utils.Menu;

public class StartMenu extends Menu {

	public StartMenu(StartController startController) {
		this.addCommand(new NewGameCommand(startController));
		this.addCommand(new OpenGameCommand(startController));
	}
}
