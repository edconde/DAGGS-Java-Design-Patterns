package juegoestrategia;

public class HarkonenSoldadoFactory implements SoldadoFactory {

	@Override
	public Artillero crearArtillero() {
		return new ArtilleroHarkonen();
	}

	@Override
	public Zapador crearZapador() {
		return new ZapadorHarkonen();
	}

}
