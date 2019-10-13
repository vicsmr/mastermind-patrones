package mastermind.views.console.commands;

import mastermind.controllers.StartController;

public class GameSelectCommand extends Command {

	public GameSelectCommand(String title, StartController startController) {
		super(title, startController);
	}

	@Override
	protected void execute() {
		this.console.writeln(this.title);
		((StartController) this.acceptorController).start(this.title);
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
