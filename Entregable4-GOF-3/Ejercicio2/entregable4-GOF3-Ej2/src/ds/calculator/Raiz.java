package ds.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ds.miniframework.Operation;

public class Raiz extends Operation {

	@Override
	public String _execute(List<String> params) {
		return "Resultado: " + String.valueOf( Math.sqrt( Double.parseDouble(params.get(0)) ) );
	}

	@Override
	public String getName() {
		return "Raíz";
	}

	@Override
	public List<String> getParameters() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		List<String> params = new ArrayList<String>();
		// Pedimos número
		System.out.println("Introduce el número:");
		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("No es un número entero.");
		}
		String num = scan.next();
		params.add(num);
		
		
		return params;
	}

}
