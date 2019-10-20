package mastermind.distributed.dispatcher;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class GetBlacksDispatcher extends Dispatcher {

	public GetBlacksDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).getBlacks(position));
	}
}
