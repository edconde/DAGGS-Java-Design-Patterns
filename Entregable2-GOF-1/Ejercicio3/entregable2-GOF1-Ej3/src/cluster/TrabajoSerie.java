package cluster;

public class TrabajoSerie extends Trabajo {

	@Override
	public void run() {
		for(Runnable r: this.getSubprogramas()) {
			r.run();
		}
	}

}