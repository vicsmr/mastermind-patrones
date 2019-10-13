package mastermind.views.console.commands;

import mastermind.controllers.PlayController;
import mastermind.views.MessageView;

public class UndoCommand extends Command {
	
	public UndoCommand(PlayController playController) {
		super(MessageView.UNDO_COMMAND.getMessage(), playController);
	}

	@Override
	public void execute() {
		((PlayController) this.acceptorController).undo();
	}

	@Override
	public boolean isActive() {
		return ((PlayController) this.acceptorController).undoable();
	}

}
