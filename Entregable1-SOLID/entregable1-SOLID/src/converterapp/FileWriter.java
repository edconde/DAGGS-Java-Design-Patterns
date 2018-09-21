package converterapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileWriter implements Writer {

	private PrintStream out;
	public FileWriter(File output) {
		try {
			this.out = new PrintStream(new FileOutputStream(output));
		} catch (FileNotFoundException e1) {
			System.err.println("the file " + output.getAbsolutePath()
					+ " does cannot be created: " + e1.getMessage());
			System.exit(1);
		}
	}
	@Override
	public void write(String output) {
		this.out.println(output);
	}
	
	@Override
	public void close() {
		this.out.close();
	}
	
}
