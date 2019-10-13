package mastermind.models.implementation;

import java.util.List;

import mastermind.models.Game;
import mastermind.models.Registry;
import mastermind.models.Session;
import mastermind.models.State;
import mastermind.models.StateValue;
import mastermind.types.Color;

public class SessionImplementation implements Session {
	
	private State state;
	
	private Game game;
	
	private Registry registry;
	
	private String name;
	
	public SessionImplementation() {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(this.game);
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public boolean hasName() {
		return this.name != null;
	}
	
	public void next() {
		this.state.next();		
	}

	public void addProposedCombination(List<Color> colors) {
		this.game.addProposedCombination(colors);
		this.registry.registry();
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
	}
	
	public void registry() {
		this.registry = new Registry(this.game);
	}
	
	public void resetRegistry() {
		this.registry.reset();
	}

	public void clearGame() {
		this.game.clear();
		this.state.reset();	
		this.registry.reset();
	}

	public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLoser() {
		return this.game.isLoser();
	}

	public int getAttempts() {
		return this.game.getAttempts();
	}

	public List<Color> getColors(int position) {
		return this.game.getColors(position);
	}

	public int getBlacks(int position) {
		return this.game.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.game.getWhites(position);
	}
	
	public void setStateValue(StateValue stateValue) {
		this.state.setStateValue(stateValue);
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getWidth() {
		return this.game.getWidth();
	}

	@Override
	public StateValue getStateValue() {
		return this.state.getStateValue();
	}

}
