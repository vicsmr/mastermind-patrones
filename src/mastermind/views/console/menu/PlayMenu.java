package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.commands.ExitCommand;
import mastermind.views.console.commands.ProposeCommand;
import mastermind.views.console.commands.RedoCommand;
import mastermind.views.console.commands.UndoCommand;
import santaTecla.utils.Menu;

public class PlayMenu extends Menu {
	
	public PlayMenu(PlayController playController) {
		this.addCommand(new ProposeCommand(playController));
		this.addCommand(new UndoCommand(playController));
		this.addCommand(new RedoCommand(playController));
		this.addCommand(new ExitCommand(playController));
	}

}
