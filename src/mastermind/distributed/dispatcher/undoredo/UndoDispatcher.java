package mastermind.distributed.dispatcher.undoredo;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;

public class UndoDispatcher extends Dispatcher {
	
	public UndoDispatcher( PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		((PlayControllerImplementation)this.acceptorController).undo();
	}

}
