package biblioteca;

public class Libro {
	
	private String titulo;
	private String isbn;
	private Autor autor;
	
	public Libro(String titulo, String isbn, Autor autor) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public Autor getAutor() {
		return autor;
	}


}
