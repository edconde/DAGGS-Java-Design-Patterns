package ds.calculator;
import java.util.ArrayList;
import java.util.List;

import ds.miniframework.*;

public class Calculadora extends App{

	public List<Operation> createOperations(){
		
		ArrayList<Operation> operations = new ArrayList<>();
		operations.add(new Suma());
		operations.add(new Division());
		operations.add(new ProtectedOperation(new Raiz()));
		/*	Monitorización de operaciones, opcional	*/
		for(Operation op: operations) op.addObserver(this);
		
		return operations;
	}
	
	public static void main(String[] args) {
		
		Calculadora calculadora = new Calculadora();
		Logger logger = Logger.getInstance();
		logger.log(" ** Iniciando calculadora... ** ", Logger.INFO);
		calculadora.start();
		logger.log(" ** Apagando calculadora... ** ", Logger.INFO);
	}
	
}