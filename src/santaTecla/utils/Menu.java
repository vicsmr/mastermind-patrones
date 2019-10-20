package santaTecla.utils;

import java.util.ArrayList;

public class Menu extends WithConsoleView {

private static final String OPTION = "----- Choose one option -----";
	
	private ArrayList<Command> commandList;

	public Menu() {
		this.commandList = new ArrayList<Command>();
	}

	public void execute() {
		ArrayList<Command> commands = new ArrayList<Command>();
		for (Command command : this.commandList) {
			if (command.isActive()) {
				commands.add(command);
			}
		}
		boolean error;
		int selectedOption;
		do {
			error = false;
			this.console.writeln();
			this.console.writeln(Menu.OPTION);
			for (int i = 0; i < commands.size(); i++) {
				this.console.writeln((i + 1) + ") " + commands.get(i).getTitle());
			}
			selectedOption = this.console.readInt("") - 1;
			if (!new ClosedInterval(0, commands.size()-1).includes(selectedOption)) {
				error = true;
			} 				
		} while (error);
		commands.get(selectedOption).execute();
	}

	protected void addCommand(Command command) {
		this.commandList.add(command);
	}
}
