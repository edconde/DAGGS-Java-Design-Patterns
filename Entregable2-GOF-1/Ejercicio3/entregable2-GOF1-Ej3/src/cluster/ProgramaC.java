package cluster;

public class ProgramaC implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("[Inicio] ProgramaC");
			Thread.sleep(10);
			System.out.println("[Fin] ProgramaC");
			} catch(InterruptedException e){
				throw new RuntimeException(e);
			}
	}
}
