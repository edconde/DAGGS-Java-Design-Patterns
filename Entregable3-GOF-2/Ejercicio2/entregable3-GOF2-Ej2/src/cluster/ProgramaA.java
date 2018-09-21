package cluster;

public class ProgramaA extends Programa {
	
	public void _run() {
		try {
			System.out.println("[Inicio] ProgramaA");
			Thread.sleep(10);
			System.out.println("[Fin] ProgramaA");
			} catch(InterruptedException e){
				throw new RuntimeException(e);
			}
	}

}