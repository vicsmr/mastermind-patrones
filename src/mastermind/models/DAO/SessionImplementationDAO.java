package mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.StateValue;
import mastermind.models.implementation.SessionImplementation;

public class SessionImplementationDAO {
	
	private static final String EXTENSION = ".mm";

	private static final String DIRECTORY = "/EclipseWorkbench/MastermindPatrones/partidas";

	private static File directory;

	static {
		SessionImplementationDAO.directory = new File(SessionImplementationDAO.DIRECTORY);
	}
	
	private SessionImplementation sessionImplementation;
	
	private GameDAO gameDAO;
	
	public SessionImplementationDAO(SessionImplementation sessionImplementation) {
        this.sessionImplementation = sessionImplementation;
        this.gameDAO = new GameDAO(sessionImplementation.getGame());
    }

	public void associate(SessionImplementation sessionImplementation) {
		this.sessionImplementation = sessionImplementation;
		this.gameDAO = new GameDAO(this.sessionImplementation.getGame());
	}

	public void load(String fileName) {
		this.sessionImplementation.setName(fileName);
		File file = new File(SessionImplementationDAO.directory, fileName);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.gameDAO.load(bufferedReader);
			this.sessionImplementation.resetRegistry();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.sessionImplementation.setStateValue(StateValue.IN_GAME);
		if (this.sessionImplementation.isLoser() || this.sessionImplementation.isWinner()) {
			this.sessionImplementation.setStateValue(StateValue.FINAL);
		}
	}

	public void save() {
		this.save(this.sessionImplementation.getName());
	}

	public void save(String fileName) {
		if (fileName.endsWith(SessionImplementationDAO.EXTENSION)) {
			fileName = fileName.replace(SessionImplementationDAO.EXTENSION, "");
		}
		File file = new File(SessionImplementationDAO.directory, fileName + SessionImplementationDAO.EXTENSION);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.gameDAO.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getGamesNames() {
		return SessionImplementationDAO.directory.list();
	}

	public boolean exists(String fileName) {
		for (String gamesName : this.getGamesNames()) {
			if (gamesName.equals(fileName + SessionImplementationDAO.EXTENSION)) {
				return true;
			}
		}
		return false;
	}


}
