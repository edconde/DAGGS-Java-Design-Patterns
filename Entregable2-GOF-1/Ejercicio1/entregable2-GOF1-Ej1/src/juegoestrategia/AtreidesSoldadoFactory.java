package juegoestrategia;

public class AtreidesSoldadoFactory implements SoldadoFactory {

	@Override
	public Artillero crearArtillero() {
		return new ArtilleroAtreides();
	}

	@Override
	public Zapador crearZapador() {
		return new ZapadorAtreides();
	}

}
