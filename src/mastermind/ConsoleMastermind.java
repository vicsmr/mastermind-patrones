package mastermind;

import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public abstract class ConsoleMastermind extends Mastermind {
	
	@Override
	protected View createView() {
		return new ConsoleView();
	}

}
