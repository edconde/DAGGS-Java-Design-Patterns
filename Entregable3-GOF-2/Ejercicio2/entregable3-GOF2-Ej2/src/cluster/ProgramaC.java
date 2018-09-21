package cluster;

public class ProgramaC extends Programa {

	public void _run() {
		try {
			System.out.println("[Inicio] ProgramaC");
			Thread.sleep(10);
			System.out.println("[Fin] ProgramaC");
			} catch(InterruptedException e){
				throw new RuntimeException(e);
			}
	}
}
