package cluster;

import java.util.ArrayList;
import java.util.List;

public class TrabajoBuilder {
	
	private boolean isParalell;
	private List<Runnable> hijos = new ArrayList<Runnable>();
	
	public TrabajoBuilder(boolean isParalell) {
		this.isParalell = isParalell;
	}
	
	public static TrabajoBuilder newParalell() {
		return new TrabajoBuilder(true);
	}
	
	public static TrabajoBuilder newSerial() {
		return new TrabajoBuilder(false);
	}
	
	public TrabajoBuilder thatRuns(Runnable r) {
		hijos.add(r);
		return this;
	}
	
	public TrabajoBuilder andAlsoRuns(Runnable r) { //Es lo mismo que thatRuns
		return thatRuns(r);
	}
	
	public Trabajo build() {
		Trabajo t = this.isParalell ? new TrabajoParalelo(): new TrabajoSerie();
		for(Runnable r: this.hijos) {
			t.addSubtrabajo(r);
		}
		return t;
	}
	
}
