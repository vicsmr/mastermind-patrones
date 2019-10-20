package mastermind.distributed.dispatcher.gameinfo;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;

public class GetAttemptsDispatcher extends Dispatcher {

	public GetAttemptsDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).getAttempts());
	}
}
