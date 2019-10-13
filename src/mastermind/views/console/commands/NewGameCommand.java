package mastermind.views.console.commands;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;

public class NewGameCommand extends Command {

	public NewGameCommand(StartController startController) {
		super(MessageView.NEWGAME_COMMAND.getMessage(), startController);
	}

	@Override
	protected void execute() {
		((StartController) this.acceptorController).start();
	}

	@Override
	protected boolean isActive() {
		return true;
	}
}
