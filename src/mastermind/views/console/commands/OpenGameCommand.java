package mastermind.views.console.commands;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import mastermind.views.console.menu.GameSelectMenu;

public class OpenGameCommand extends Command{

	public OpenGameCommand(StartController startController) {
		super(MessageView.OPENGAME_COMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		new GameSelectMenu((StartController) this.acceptorController).execute();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
