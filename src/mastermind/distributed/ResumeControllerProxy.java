package mastermind.distributed;

import mastermind.distributed.dispatcher.FrameType;
import mastermind.distributed.dispatcher.TCPIP;
import mastermind.controllers.ResumeController;
import mastermind.models.Session;

public class ResumeControllerProxy extends ResumeController {
	
	private TCPIP tcpip;

	protected ResumeControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void resume(boolean newGame) {
		this.tcpip.send(FrameType.NEW_GAME.name());
		this.tcpip.send(newGame);	
	}

}
