package CalculadoraNominas;

public class Quinquenio extends Complemento {

private int numQuinquenios;
	
	public Quinquenio(Nomina base, int qui) {
		super(base);
		this.numQuinquenios = qui;
	}

	@Override
	public float calcularNomina() {
		return this.getNominaBase().calcularNomina() + 20 * this.numQuinquenios;
	}
}
