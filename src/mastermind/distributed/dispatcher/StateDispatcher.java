package mastermind.distributed.dispatcher;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class StateDispatcher extends Dispatcher {
	
	public StateDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(this.acceptorController.getStateValue().ordinal());
	}

}
