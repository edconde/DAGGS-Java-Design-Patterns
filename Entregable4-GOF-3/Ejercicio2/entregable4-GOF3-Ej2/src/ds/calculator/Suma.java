package ds.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ds.miniframework.Operation;

public class Suma extends Operation {

	@Override
	public String _execute(List<String> params) {
		return "Resultado: " + String.valueOf( ( Integer.parseInt(params.get(0)) 
				+ Integer.parseInt(params.get(1)) ) );
	}

	@Override
	public String getName() {
		return "Suma";
	}

	@Override
	public List<String> getParameters() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		List<String> params = new ArrayList<String>();
		// Pedimos sumando A
		System.out.println("Introduce el sumando A:");
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("No es un número entero.");
		}
		String sumandoA = scan.next();
		params.add(sumandoA);
		// Pedimos sumando B
		System.out.println("Introduce el sumando B:");
		while(!scan.hasNextFloat()) {
			scan.next();
			System.out.println("No es un número entero.");
		}
		String sumandoB = scan.next();
		params.add(sumandoB);
		
		return params;
	}

}
