package mastermind.views.console.commands;

import mastermind.controllers.PlayController;
import mastermind.views.MessageView;

public class ExitCommand extends Command {

	public ExitCommand(PlayController playController) {
		super(MessageView.EXIT_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).next();	
	}

	@Override
	public boolean isActive() {
		return true;
	}

}
