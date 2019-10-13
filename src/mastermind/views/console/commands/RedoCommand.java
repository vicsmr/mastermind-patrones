package mastermind.views.console.commands;

import mastermind.controllers.PlayController;
import mastermind.views.MessageView;

public class RedoCommand extends Command {
	
	public RedoCommand(PlayController playController) {
		super(MessageView.REDO_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		((PlayController) this.acceptorController).redo();
	}

	@Override
	protected boolean isActive() {
		return ((PlayController) this.acceptorController).redoable();
	}

}
