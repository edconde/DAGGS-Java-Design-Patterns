package converterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Reader {
	private Scanner scan;
	public FileReader(File input) {
		try {
			this.scan = new Scanner(input);
		} catch (FileNotFoundException e) {
			System.err.println("the file " + input.getAbsolutePath()
			+ " does not exists: " + e.getMessage());
			System.exit(1);
		}
	}
	@Override
	public String getLine() {
		if(scan.hasNextLine()) {
			return scan.nextLine();
		}else {
			scan.close();
			return null;
		}
	}
	
}
