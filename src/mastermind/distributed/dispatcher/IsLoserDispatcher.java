package mastermind.distributed.dispatcher;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class IsLoserDispatcher extends Dispatcher {

	public IsLoserDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).isLoser());
	}
}
