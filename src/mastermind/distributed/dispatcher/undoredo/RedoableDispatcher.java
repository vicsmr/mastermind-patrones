package mastermind.distributed.dispatcher.undoredo;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;

public class RedoableDispatcher extends Dispatcher {

	public RedoableDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).redoable());
	}
}
