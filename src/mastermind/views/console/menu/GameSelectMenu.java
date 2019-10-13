package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.views.console.commands.GameSelectCommand;
import santaTecla.utils.Menu;

public class GameSelectMenu extends Menu {

	public GameSelectMenu(StartController startController) {
		String[] gamesNames = startController.getGamesNames();
		for (String title : gamesNames) {
			this.addCommand(new GameSelectCommand(title, startController));
		}
	}

}
