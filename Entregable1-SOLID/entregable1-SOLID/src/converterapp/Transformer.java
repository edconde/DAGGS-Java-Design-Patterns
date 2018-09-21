package converterapp;

public interface Transformer {
	abstract String header();
	abstract String transform(String input);
	abstract String footer();
}
