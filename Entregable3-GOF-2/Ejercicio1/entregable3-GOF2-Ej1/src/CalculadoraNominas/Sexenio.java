package CalculadoraNominas;

public class Sexenio extends Complemento {

	private int numSexenios;
	
	public Sexenio(Nomina base, int sex) {
		super(base);
		this.numSexenios = sex; // ;)
	}

	@Override
	public float calcularNomina() {
		return this.getNominaBase().calcularNomina() + 50 * this.numSexenios;
	}
	
}
