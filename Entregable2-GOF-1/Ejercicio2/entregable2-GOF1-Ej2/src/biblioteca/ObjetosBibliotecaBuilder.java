package biblioteca;

public class ObjetosBibliotecaBuilder implements BibliotecaBuilder {
	
	private Biblioteca biblioteca;
	
	public ObjetosBibliotecaBuilder() {
		this.biblioteca = new Biblioteca();
	}
	
	@Override
	public void addLibro(String titulo, String nombreAutor, String isbn) {
		Autor autor = new Autor(nombreAutor);
		Libro libro = new Libro(titulo, isbn, autor);
		this.biblioteca.getLibros().add(libro);
	}
	
	public Biblioteca getBiblioteca() {
		return this.biblioteca;
	}

}
