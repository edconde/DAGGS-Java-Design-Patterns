package ds.miniframework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileLogger extends Logger {
	
	private PrintStream out;

	public FileLogger(Logger next) {
		super(next);
		File file = new File("log.txt");
		try {
			this.out = new PrintStream(new FileOutputStream(file));
		} catch (FileNotFoundException e1) {
			System.err.println("the log file " + file.getAbsolutePath()
					+ " does cannot be created: " + e1.getMessage());
			System.exit(1);
		}
	}

	public void _log(String msg) {
		this.out.println(msg);
	}
	
}
