package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class GameMemento {

	private List<ProposedCombination> proposedCombinations;

	private List<Result> results;

	private int attempts;

	protected GameMemento(int attempts) {
		this.attempts = attempts;
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
	}

	protected void set(ProposedCombination proposedCombination, Result result) {
		this.proposedCombinations.add(proposedCombination);
		this.results.add(result);
	}
	
	protected ProposedCombination getProposedCombination(int position){
		return this.proposedCombinations.get(position);
	}
	
	protected Result getResult(int position){
		return this.results.get(position);
	}
	
	protected int getSize() {
		return proposedCombinations.size();
	}
	
	protected int getAttempts(){
		return this.attempts;
	}
}
