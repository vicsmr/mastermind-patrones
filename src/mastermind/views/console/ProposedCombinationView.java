package mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import mastermind.controllers.GameController;
import mastermind.types.Color;
import mastermind.views.console.ColorView;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposedCombinationView extends WithConsoleView {
	
	private GameController gameController;
	
	public ProposedCombinationView(GameController gameController) {
		this.gameController = gameController;
	}
	
	protected void write(int i) {
		for (Color color : this.gameController.getColors(i)) {
			new ColorView(color).write();
		}
	}

	public List<Color> read() {
		String characters = this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
