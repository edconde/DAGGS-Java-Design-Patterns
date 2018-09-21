package converterapp;

public class Converter {

	private Reader reader;
	private Transformer transformer;
	private Writer writer;
	public Converter(Reader reader, Transformer transformer, Writer writer) {
		this.reader = reader;
		this.transformer = transformer;
		this.writer = writer;
	}
	
	public void convert() {
		
		writer.write(transformer.header());
		while(true) {
			String line = reader.getLine();
			if(line != null) {
				writer.write(transformer.transform(line));
			} else {
				break;
			}
		}
		writer.write(transformer.footer());
		writer.close();
	}

}
