package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.views.console.menu.PlayMenu;

public class PlayView {
	
	void interact(PlayController playController) {
		new PlayMenu(playController).execute();	
	}

}
