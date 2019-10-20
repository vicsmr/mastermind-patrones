package mastermind.distributed.dispatcher.saves;

import mastermind.controllers.implementation.SaveControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;

public class SaveDispatcher extends Dispatcher {

	public SaveDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		String name = this.tcpip.receiveLine();
		((SaveControllerImplementation) this.acceptorController).save(name);
	}

}
