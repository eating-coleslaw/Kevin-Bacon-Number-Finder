import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Parser {
	Scanner input;
	File f;
	
	public Parser(String file) throws FileNotFoundException {
		f = new File(file);
		input = new Scanner(f).useDelimiter("\n");
	}
		
	public personFilmPair next() {
		String line = input.next();
		return new personFilmPair(line);
	}
	
	public boolean hasNext() {
		return input.hasNext();
	}	
}