package CalculadoraNominas;

public class Trienio extends Complemento {

	private int numTrienios;
	
	public Trienio(Nomina base, int tri) {
		super(base);
		this.numTrienios = tri;
	}

	@Override
	public float calcularNomina() {
		return this.getNominaBase().calcularNomina() + 10 * this.numTrienios;
	}

}
