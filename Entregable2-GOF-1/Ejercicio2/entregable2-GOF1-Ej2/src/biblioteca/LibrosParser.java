package biblioteca;

import java.io.File;

public class LibrosParser {
	
	private File file;
	private BibliotecaBuilder bb;
	
	public LibrosParser(File f, BibliotecaBuilder bb) {
		this.file = f;
		this.bb = bb;
	}
	
	public void parse() {
		
		FileReader reader = new FileReader(this.file);
		while(true) {
			String line = reader.getLine();
			if(line != null) {
				String[] tokens = line.split("\t");
				if (tokens.length != 3) {
					throw new IllegalArgumentException(
							"the line does not contain 3 tokens");
				}
				this.bb.addLibro(tokens[0], tokens[1], tokens[2]); // titulo, autor, isbn
			} else {
				break;
			}
		}
	}

}
