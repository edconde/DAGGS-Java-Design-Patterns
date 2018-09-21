package cluster;

public class ProgramaB implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("[Inicio] ProgramaB");
			Thread.sleep(10);
			System.out.println("[Fin] ProgramaB");
			} catch(InterruptedException e){
				throw new RuntimeException(e);
			}
	}
}
