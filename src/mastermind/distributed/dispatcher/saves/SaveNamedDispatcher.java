package mastermind.distributed.dispatcher.saves;

import mastermind.controllers.implementation.SaveControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;

public class SaveNamedDispatcher extends Dispatcher {

	public SaveNamedDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		((SaveControllerImplementation) this.acceptorController).save();
	}

}
