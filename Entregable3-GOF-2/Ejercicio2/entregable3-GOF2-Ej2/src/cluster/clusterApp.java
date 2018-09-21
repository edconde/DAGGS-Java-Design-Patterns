package cluster;

public class clusterApp {

	public static void main(String[] args) {
		
		AvisoConsolaObserver avisador = new AvisoConsolaObserver();
		Programa pa = new ProgramaA();
		pa.addObserver(avisador);
		Programa pb = new ProgramaB();
		pb.addObserver(avisador);
		Programa pc = new ProgramaC();
		pc.addObserver(avisador);
		
		/* Ejemplo simple de trabajo principal en serie:
		** Ejecución de	Programa A seguida de ejecución de subtrabajo en paralelo (ProgramaB y ProgramaC)
		*/
		Trabajo trabajoPrincipal = TrabajoBuilder.newSerial().thatRuns(pa)
									.andAlsoRuns(TrabajoBuilder.newParalell().thatRuns(pb)
																.andAlsoRuns(pc)
																.build())
									.build();
		trabajoPrincipal.run();
	}
	
}
