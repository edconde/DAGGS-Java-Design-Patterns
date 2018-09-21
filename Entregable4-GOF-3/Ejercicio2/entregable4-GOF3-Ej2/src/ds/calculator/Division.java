package ds.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ds.miniframework.Operation;

public class Division extends Operation {

	@Override
	public String _execute(List<String> params) {
		return "Resultado: " + String.valueOf( (float)( Integer.parseInt(params.get(0)) 
									/ (float)Integer.parseInt(params.get(1)) ) );
	}

	@Override
	public String getName() {
		return "División";
	}

	@Override
	public List<String> getParameters() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		List<String> params = new ArrayList<String>();
		// Pedimos dividendo
		System.out.println("Introduce el dividendo:");
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("No es un número entero.");
		}
		String dividendo = scan.next();
		params.add(dividendo);
		// Pedimos divisor
		System.out.println("Introduce el divisor:");
		while(!scan.hasNextFloat()) {
			scan.next();
			System.out.println("No es un número entero.");
		}
		String divisor = scan.next();
		params.add(divisor);
		
		return params;
	}

}
