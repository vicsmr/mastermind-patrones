package mastermind.views;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.ControllersVisitor;

public abstract class View implements ControllersVisitor {
	
	public abstract void interact(AcceptorController acceptorController);

}
