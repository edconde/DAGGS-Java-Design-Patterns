package CalculadoraNominas;

public abstract class Complemento implements Nomina {

	private Nomina nominaBase;
	
	public Complemento(Nomina base) {
		this.nominaBase = base;
	}
	
	public abstract float calcularNomina();

	public Nomina getNominaBase() {
		return nominaBase;
	}
}
