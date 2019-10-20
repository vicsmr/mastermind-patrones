package mastermind.distributed.dispatcher.gameinfo;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;

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
