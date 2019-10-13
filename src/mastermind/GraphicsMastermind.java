package mastermind;

import mastermind.views.View;
import mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends MastermindStandalone{

	protected View createView() {
		return new GraphicsView();
	}
	
	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
