package biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class XMLBibliotecaBuilder implements BibliotecaBuilder {
	
	private File xmlfile;
	private int numLibros = 0;
	
	public XMLBibliotecaBuilder(File f) {
		this.xmlfile = f;
	}

	@Override
	public void addLibro(String titulo, String autor, String isbn) {
		
		PrintStream out = null;
		String libro = "<libro>\n"
				+ "<titulo>" + titulo + "</titulo>\n"
				+ "<autor>" + autor + "</autor>\n"
				+ "<isbn>" + isbn + "</isbn>\n"
				+ "</libro>";
		
		if(this.numLibros == 0) { // Si es el primer libro
			try {
				out = new PrintStream(new FileOutputStream(this.xmlfile));
			} catch (FileNotFoundException e1) {
				System.err.println("the file " + xmlfile.getAbsolutePath()
						+ " does cannot be created: " + e1.getMessage());
				System.exit(1);
			}
			out.println("<libros>");
			out.println(libro);
			out.println("</libros>");
			this.numLibros++;
			
		} else { // Si ya existía el fichero xml con al menos un libro
			Scanner scan = null;
			try {
				scan = new Scanner(this.xmlfile);
			} catch (FileNotFoundException e) {
				System.out.println("No existe el fichero xml.");
			}
			String header = scan.nextLine();
			String librosParseados = "";
			String linea ="";
			while(true) {
				linea = scan.nextLine();
				if(scan.hasNextLine()) {
					librosParseados += linea + "\n";
				}else { break; }
			}
			String footer = linea;
			scan.close();
			
			try {
				out = new PrintStream(new FileOutputStream(this.xmlfile));
			} catch (FileNotFoundException e1) {
				System.err.println("the file " + xmlfile.getAbsolutePath()
						+ " does cannot be created: " + e1.getMessage());
				System.exit(1);
			}
			out.println(header);
			out.print(librosParseados);
			out.println(libro);
			out.println(footer);
		}
		
	}
	
	public File getXMLFile() {
		return this.xmlfile;
	}

}