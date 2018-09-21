package biblioteca;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Biblioteca {
	
	private List<Libro> libros; 
	
	public Biblioteca() {
		this.libros = new ArrayList<Libro>();
	}
	
	public List<Libro> getLibros(){
		return libros;
	}
	
	public String toString() {
		String toret = "Catálogo de la biblioteca:\n---------------------------";
		Iterator<Libro> itr = this.getLibros().iterator();
		while(itr.hasNext()) {
			Libro libro = itr.next();
			toret += "\n\"" + libro.getTitulo() + "\", de " +
					libro.getAutor().getNombre() + ". ISBN: " + libro.getIsbn();
		}
		return toret;
	}
	
}