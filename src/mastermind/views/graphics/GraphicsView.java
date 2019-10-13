package mastermind.views.graphics;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.PlayController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.SaveController;
import mastermind.controllers.StartController;
import mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView() {
		this.gameView = new GameView();
	}
	
	@Override
    public void interact(AcceptorController acceptorController) {
        acceptorController.accept(this);
    }

	@Override
	public void visit(StartController startController) {
		this.gameView.interact(startController);
	}

	@Override
	public void visit(PlayController playController) {
		this.gameView.interact(playController);
	}
	
	@Override
	public void visit(SaveController saveController) {
		this.gameView.interact(saveController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		ResumeDialog resumeDialog = new ResumeDialog();
		resumeController.resume(resumeDialog.isNewGame());
		if (resumeDialog.isNewGame()) {
			this.gameView = new GameView();
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
		}
	}

}
