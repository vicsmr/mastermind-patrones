package mastermind.distributed.dispatcher.saves;

import mastermind.controllers.implementation.SaveControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;

public class HasNameDispatcher extends Dispatcher {

	public HasNameDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(((SaveControllerImplementation) this.acceptorController).hasName());
	}

}
