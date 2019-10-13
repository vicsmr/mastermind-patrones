package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.types.Color;

public class Game {

	private static final int MAX_LONG = 10;

	private SecretCombination secretCombination;

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	public Game() {
		this.clear();
	}

	public void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		this.attempts = 0;
	}
	
	public ProposedCombination getProposedCombination(int position) {
		return this.proposedCombinations.get(position);
	}

	public void addProposedCombination(List<Color> colors) {
		ProposedCombination proposedCombination = new ProposedCombination(colors);
		this.proposedCombinations.add(proposedCombination);
		this.results.add(this.secretCombination.getResult(proposedCombination));
		this.attempts++;
	}
	
	public void addProposedCombination(ProposedCombination proposedCombination) {
		this.proposedCombinations.add(proposedCombination);
	}

	public boolean isLooser() {
		return this.attempts == Game.MAX_LONG;
	}
	
	public boolean isWinner() {
		if (this.attempts == 0) {
			return false;
		}
		return this.results.get(this.attempts-1).isWinner();
	}

	public int getAttempts() {
		return this.attempts;
	}
	
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public List<Color> getColors(int position) {
		return this.proposedCombinations.get(position).colors;
	}

	public int getBlacks(int position) {
		return this.results.get(position).getBlacks();
	}

	public int getWhites(int position) {
		return this.results.get(position).getWhites();
	}

	public int getWidth() {
		return Combination.getWidth();
	}
	
	public GameMemento createMemento() {
		GameMemento gameMemento = new GameMemento(this.attempts);
		for (int i = 0; i < this.proposedCombinations.size(); i++) {
			gameMemento.set(this.proposedCombinations.get(i).copy(), this.results.get(i).copy());
		}
		return gameMemento;
	}
	
	public void restore(GameMemento gameMemento) {
		this.attempts = gameMemento.getAttempts();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
		for (int i = 0; i < gameMemento.getSize(); i++) {
			this.proposedCombinations.add(gameMemento.getProposedCombination(i).copy());
			this.results.add(gameMemento.getResult(i).copy());
		}
	}
	
	public SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

	public Result getResult(int position) {
		return this.results.get(position);
	}
	
	public void addResult(Result result) {
		this.results.add(result);
	}

}
