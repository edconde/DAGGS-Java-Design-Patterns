package converterapp;

public class ConsoleWriter implements Writer {

	@Override
	public void write(String output) {
		System.out.println(output);
	}

	@Override
	public void close() {
		System.out.close();
	}
	
}
