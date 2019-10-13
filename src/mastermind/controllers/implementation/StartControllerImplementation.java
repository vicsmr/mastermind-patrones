package mastermind.controllers.implementation;

import java.util.List;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.DAO.SessionImplementationDAO;
import mastermind.models.implementation.SessionImplementation;
import mastermind.types.Color;

public class StartControllerImplementation extends StartController {
	
	private SessionImplementationDAO sessionImplementationDAO;
	
	public StartControllerImplementation(Session session, SessionImplementationDAO sessionImplementationDAO) {
		super(session);
		this.sessionImplementationDAO = sessionImplementationDAO;
	}
	
	@Override
	public void start() {
		((SessionImplementation) this.session).clearGame();
		((SessionImplementation) this.session).registry();
		this.sessionImplementationDAO.associate((SessionImplementation) this.session);
		((SessionImplementation) this.session).next();
	}

	@Override
	public void start(String name) {
		this.sessionImplementationDAO.load(name);
	}

	@Override
	public String[] getGamesNames() {
		return this.sessionImplementationDAO.getGamesNames();
	}

	@Override
	public int getAttempts() {
		return ((SessionImplementation) this.session).getAttempts();
	}

	@Override
	public List<Color> getColors(int position) {
		return ((SessionImplementation) this.session).getColors(position);
	}

	@Override
	public int getBlacks(int position) {
		return ((SessionImplementation) this.session).getBlacks(position);
	}

	@Override
	public int getWhites(int position) {
		return ((SessionImplementation) this.session).getWhites(position);
	}

	@Override
	public boolean isWinner() {
		return ((SessionImplementation) this.session).isWinner();
	}

	@Override
	public boolean isLoser() {
		return ((SessionImplementation) this.session).isLoser();
	}

}
