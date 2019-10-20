package mastermind.distributed.dispatcher.saves;

import mastermind.controllers.implementation.StartControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;

public class GamesNamesDispatcher extends Dispatcher {

	public GamesNamesDispatcher(StartControllerImplementation startControllerImplementation) {
		super(startControllerImplementation);
	}

	@Override
	public void dispatch() {
		String[] names = ((StartControllerImplementation) this.acceptorController).getGamesNames();
		this.tcpip.send(names.length);
		for (int i = 0; i < names.length; i++) {
			this.tcpip.send(names[i]);
		}
	}

}
