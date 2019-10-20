package mastermind.distributed.dispatcher.gameinfo;

import java.util.ArrayList;
import java.util.List;

import mastermind.controllers.implementation.PlayControllerImplementation;
import mastermind.distributed.dispatcher.Dispatcher;
import mastermind.types.Color;

public class ProposedCombinationDispatcher extends Dispatcher {

	public ProposedCombinationDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		int length = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<length; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		this.tcpip.send(((PlayControllerImplementation) this.acceptorController).addProposedCombination(colors));
	}
}
