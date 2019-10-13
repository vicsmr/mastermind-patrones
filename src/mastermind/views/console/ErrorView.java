package mastermind.views.console;

import mastermind.types.Error;
import santaTecla.utils.WithConsoleView;

class ErrorView extends WithConsoleView {

	protected static final String[] MESSAGES = { 
			"Repeated colors",
			"Wrong colors, they must be: " + ColorView.allInitials(), 
			"Wrong proposed combination length" };

	private Error error;

	protected ErrorView(Error error) {
		this.error = error;
	}
	
	protected void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}

}
