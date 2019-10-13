package mastermind;

import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public class ConsoleMastermind extends MastermindStandalone{

	protected View createView() {
		return new ConsoleView();
	}
	
	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}
}
