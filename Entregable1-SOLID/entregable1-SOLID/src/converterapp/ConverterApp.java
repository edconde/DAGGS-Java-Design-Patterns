package converterapp;

import java.io.File;
public class ConverterApp {

	public static void main(String args[]) {
		
		File input = FilesUserInterface.getFile("input filename: ");
		Transformer transformer = new TABtoXMLTransformer();
		
		// Ejemplo con salida en fichero .xml
		File output = FilesUserInterface.getFile("output filename: ");
		Reader reader = new FileReader(input);
		Writer writer = new FileWriter(output);
		
		Converter fileConverter = new Converter(reader, transformer, writer);
		fileConverter.convert();
		
		// Ejemplo con salida por consola
		Reader reader2 = new FileReader(input);
		Writer writer2 = new ConsoleWriter();
		
		Converter fileConverter2 = new Converter(reader2, transformer, writer2);
		fileConverter2.convert();
		
	}
	
}
