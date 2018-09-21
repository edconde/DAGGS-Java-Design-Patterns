package converterapp;

import java.io.File;
import java.util.Scanner;

public class FilesUserInterface {
	public static File getFile(String dialog) {
		System.out.println(dialog);
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();

		return new File(name);
	}
}
