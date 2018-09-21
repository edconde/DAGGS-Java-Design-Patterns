package CalculadoraNominas;

public class CargoGestion extends Complemento {

	private boolean cargoGestion;
	
	public CargoGestion(Nomina base, boolean cargoG) {
		super(base);
		this.cargoGestion = cargoG;
	}

	@Override
	public float calcularNomina() {
		return this.getNominaBase().calcularNomina() + (this.cargoGestion ? 15:0);
	}
	
}
