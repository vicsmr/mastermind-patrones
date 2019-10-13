package mastermind.views.console;

import mastermind.controllers.GameController;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	private GameController gameController;

	AttemptsView(GameController gameController) {
		this.gameController = gameController;
	}

	void writeln() {
		MessageView.ATTEMPTS.writeln(this.gameController.getAttempts());
	}

}
