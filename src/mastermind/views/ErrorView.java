package mastermind.views;

import mastermind.types.Error;
import santaTecla.utils.WithConsoleView;

public class ErrorView extends WithConsoleView {

	public static final String[] MESSAGES = { 
			"Repeated colors",
			"Wrong colors, they must be: " + ColorView.allInitials(), 
			"Wrong proposed combination length" };

	private Error error;

	public ErrorView(Error error) {
		this.error = error;
	}
	
	public void writeln() {
		this.console.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}
	
	public Error getMessage() {
		return this.error;
	}
	
}
