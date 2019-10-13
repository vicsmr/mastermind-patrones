package mastermind.distributed.dispatcher;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class LoserDispatcher extends Dispatcher {

	public LoserDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).isLoser());
	}
}
