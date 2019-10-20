package mastermind.distributed.dispatcher;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class GetWhitesDispatcher extends Dispatcher {

	public GetWhitesDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).getWhites(position));
	}
}
