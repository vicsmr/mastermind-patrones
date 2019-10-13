package mastermind.views.console.commands;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;

public class NewGameCommand extends Command {

	public NewGameCommand(StartController startController) {
		super(MessageView.NEWGAME_COMMAND.getMessage(), startController);
	}

	@Override
	public void execute() {
		((StartController) this.acceptorController).start();
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
