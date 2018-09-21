package juegoestrategia;

public class JugadorMaquina extends Jugador {
	
	public JugadorMaquina(SoldadoFactory ejercito) {
		super(ejercito);
	}

	@Override
	public void jugar() {
		//disparamos!
		for (Artillero artillero : artilleros){
			artillero.disparar();
		}
		
		//ponemos bombas!
		for (Zapador zapador: zapadores){
			zapador.ponerBomba();
		}

	}

}
