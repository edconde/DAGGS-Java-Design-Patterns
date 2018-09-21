package converterapp;

public class TABtoXMLTransformer implements Transformer {

	@Override
	public String header() {
		return "<products>";
	}

	@Override
	public String transform(String line) {
		String[] tokens = line.split("\t");
		if (tokens.length != 2) {
			throw new IllegalArgumentException(
					"the line does not contain 2 tokens");
		}

		return "<product>\n\t<name>" + tokens[0] + "</name>\n\t<price>"
				+ tokens[1] + "</price>\n</product>";
	}

	@Override
	public String footer() {
		return "</products>";
	}

}
