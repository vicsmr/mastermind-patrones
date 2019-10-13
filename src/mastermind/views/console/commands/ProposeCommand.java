package mastermind.views.console.commands;

import java.util.List;

import mastermind.controllers.PlayController;
import mastermind.types.Color;
import mastermind.views.ErrorView;
import mastermind.views.MessageView;
import mastermind.views.console.GameView;
import mastermind.views.console.ProposedCombinationView;
import mastermind.types.Error;

public class ProposeCommand extends Command {
	
	public ProposeCommand(PlayController playController) {
		super(MessageView.PROPOSE_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView((PlayController) this.acceptorController).read();
			error = ((PlayController)this.acceptorController).addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		new GameView((PlayController) this.acceptorController).writeln();
	}

	@Override
	protected boolean isActive() {
		return true;
	}

}
