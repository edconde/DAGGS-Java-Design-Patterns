package ds.miniframework;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class App implements Observer {
	
	private Logger appLogger;
	public abstract List<Operation> createOperations();

	public void start() {
		appLogger = Logger.getInstance();
		List<Operation> operations = this.createOperations();
		List<String> opNames = operations.stream().map(i -> i.getName()).collect(Collectors.toList());
		while(true) {
			int op = this.menu(opNames);
			if( op == -1 ) break;
			if( op == 0 ) continue;
			Operation toExecute = operations.get(op-1);
			appLogger.log("Ejecutando operación " + toExecute.getName() + ".", Logger.INFO);
			List<String> params = toExecute.getParameters();
			System.out.println(toExecute.execute(params));
			appLogger.log("Ejecución de operación " + toExecute.getName() + " finalizada.", Logger.INFO);
			}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Operation observado = (Operation) o;
		System.out.println(" Operación en proceso...  "
				+ (observado.getProgress()*100 + "%"));
	}
	
	public int menu(List<String> opNames) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("\n MENÚ - CUTRECALC\n ----------------");
		for(int i = 1; i <= opNames.size(); i++) {
			System.out.println(" " + i + " -> " + 
					opNames.get(i-1));
		}
		System.out.println(" * Pulsa 'q' para salir de la aplicación.");
		String op = scan.nextLine();
		if(op.equals("q")) {
			return -1;
		}
		else {
			int n = Integer.parseInt(op);
			if( (n >= 1) && (n<= opNames.size()) ) {
				return n;
			} else {
				System.out.println(" >> Selecciona una opción válida. <<");
				return 0;
			}
		}
	}

}