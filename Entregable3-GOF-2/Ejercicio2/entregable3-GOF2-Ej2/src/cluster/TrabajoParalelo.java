package cluster;

import java.util.ArrayList;
import java.util.List;

public class TrabajoParalelo extends Trabajo {

	public void run() {
		List<Thread> hilosHijo = new ArrayList<Thread>();
		for(Runnable r: this.getSubprogramas()){
			Thread t = new Thread(r);
			hilosHijo.add(t);
		}
		for(Thread t: hilosHijo) {
			t.start();
		}
		for(Thread t: hilosHijo) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
