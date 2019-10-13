package mastermind.controllers;

import mastermind.models.Session;
import mastermind.models.StateValue;

public abstract class Controller {

	protected Session session;

	Controller(Session session) {
		this.session = session;
	}
	
	public int getWidth() {
		return this.session.getWidth();
	}
	
	public StateValue getStateValue() {
		return this.session.getStateValue();
	}
	
	public String getName() {
		return this.session.getName();
	}
	
	public void setName(String name) {
		this.session.setName(name);
	}

}
