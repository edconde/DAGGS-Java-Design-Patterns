package CalculadoraNominas;

import java.util.List;

public class NominaApp {

	public static void main(String[] args) {
		
		List<Empleado> empleados = Empleado.leerEmpleados("nominas.txt");
		for(Empleado e: empleados) {
			System.out.println(e.getNombre() + "\t" + e.importeNomina());
		}
	}
}