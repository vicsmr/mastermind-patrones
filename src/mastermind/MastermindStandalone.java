package mastermind;

import mastermind.controllers.Logic;
import mastermind.controllers.implementation.LogicImplementation;
import mastermind.views.View;

public abstract class MastermindStandalone extends Mastermind {
	
	protected abstract View createView();

	@Override
	protected Logic createLogic() {
		return new LogicImplementation();
	}
	
}
