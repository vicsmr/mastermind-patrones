package mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.FileWriter;

public interface DAO {
	
	abstract void save(FileWriter fileWriter);
	
	abstract void load(BufferedReader bufferedReader);

}
