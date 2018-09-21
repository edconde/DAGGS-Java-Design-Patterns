package biblioteca;

import java.io.File;

public class BibliotecaApp {

	public static void main(String[] args) {
		
		File input = new File("libros.txt");
		File xmlOutputFile = new File("libros.xml");
		
		BibliotecaBuilder biblioBuilder = new ObjetosBibliotecaBuilder();
		BibliotecaBuilder xmlBuilder = new XMLBibliotecaBuilder(xmlOutputFile);
		
		LibrosParser toBiblioteca = new LibrosParser(input, biblioBuilder);
		LibrosParser toXML = new LibrosParser(input, xmlBuilder);
		
		toBiblioteca.parse();
		toXML.parse();
		
		// Visualizamos los libros que hay en la biblioteca
		System.out.print( ((ObjetosBibliotecaBuilder)biblioBuilder).getBiblioteca() );
	}
}
