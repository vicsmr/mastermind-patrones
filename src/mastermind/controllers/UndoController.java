package mastermind.controllers;

import mastermind.models.Session;
import mastermind.models.implementation.SessionImplementation;

public class UndoController extends Controller {
	
	public UndoController(Session session) {
		super(session);
	}

	public void undo() {
		((SessionImplementation) this.session).undo();
	}

	public boolean undoable() {
		return ((SessionImplementation) this.session).undoable();
	}

}
