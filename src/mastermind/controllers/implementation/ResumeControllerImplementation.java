package mastermind.controllers.implementation;

import mastermind.controllers.ResumeController;
import mastermind.models.Session;
import mastermind.models.implementation.SessionImplementation;

public class ResumeControllerImplementation extends ResumeController {
	
	public ResumeControllerImplementation(Session session) {
		super(session);
	}
	
	public void resume(boolean newGame) {
		SessionImplementation sessionImplementation = (SessionImplementation) this.session;
		if (newGame) {
			sessionImplementation.clearGame();
		} else {
			sessionImplementation.next();
		}
	}

}
