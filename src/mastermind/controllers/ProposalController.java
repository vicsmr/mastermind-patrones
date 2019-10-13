package mastermind.controllers;

import java.util.List;

import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.models.implementation.SessionImplementation;
import mastermind.types.Color;
import mastermind.types.Error;

public class ProposalController extends Controller {

	public ProposalController(Session session) {
		super(session);
	}

	public Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i+1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}				
			}
		}
		SessionImplementation sessionImplementation = (SessionImplementation) this.session;
		if (error == null){
			sessionImplementation.addProposedCombination(colors);
			if (sessionImplementation.isWinner() || sessionImplementation.isLoser()) {
				sessionImplementation.next();
			}
		}
		return error;	
	}

	public boolean isWinner() {
		return ((SessionImplementation) this.session).isWinner();
	}

	public boolean isLooser() {
		return ((SessionImplementation) this.session).isLoser();
	}
	
	public int getAttempts() {
		return ((SessionImplementation) this.session).getAttempts();
	}

	public List<Color> getColors(int position) {
		return ((SessionImplementation) this.session).getColors(position);
	}

	public int getBlacks(int position) {
		return ((SessionImplementation) this.session).getBlacks(position);
	}

	public int getWhites(int position) {
		return ((SessionImplementation) this.session).getWhites(position);
	}

}
