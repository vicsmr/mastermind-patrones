package mastermind.distributed.dispatcher.gameinfo;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;

public class IsWinnerDispatcher extends Dispatcher {
	
	public IsWinnerDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((PlayControllerImplementation)this.acceptorController).isWinner());
	}

}
