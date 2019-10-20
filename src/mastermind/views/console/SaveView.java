package mastermind.views.console;

import mastermind.controllers.SaveController;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;
import santaTecla.utils.YesNoDialog;

public class SaveView extends WithConsoleView {

	protected void interact(SaveController saveController) {
		boolean isSaved = new YesNoDialog().read(MessageView.SAVE.getMessage());
		String name = null;
		if (isSaved) {
			if (saveController.hasName()) {
				saveController.save();
			} else {
				boolean exists = false;
				do {
					name = this.console.readString(MessageView.NAME.getMessage());
					exists = saveController.exists(name);
					if (exists) {
						this.console.writeln("The proposed name already exists");
					}
				} while (exists);
				saveController.save(name);
			}
		}
		saveController.next();
	}
}
