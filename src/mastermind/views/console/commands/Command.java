package mastermind.views.console.commands;

import mastermind.controllers.AcceptorController;

public abstract class Command extends santaTecla.utils.Command {
	
	protected AcceptorController acceptorController;

	protected Command(String title, AcceptorController acceptorController) {
		super(title);
		this.acceptorController = acceptorController;
	}

}
