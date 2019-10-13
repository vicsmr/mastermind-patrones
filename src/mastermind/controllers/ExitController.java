package mastermind.controllers;

import mastermind.models.Session;
import mastermind.models.implementation.SessionImplementation;

public class ExitController extends Controller {

	public ExitController(Session session) {
		super(session);
	}

	public void next() {
		((SessionImplementation) this.session).next();
	}

}
