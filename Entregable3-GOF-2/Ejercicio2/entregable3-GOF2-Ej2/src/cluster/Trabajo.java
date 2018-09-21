package cluster;

import java.util.ArrayList;
import java.util.List;

public abstract class Trabajo implements Runnable { 
	
	private List<Runnable> subprogramas = new ArrayList<Runnable>();
	
	public void addSubtrabajo(Runnable r) {
		this.subprogramas.add(r);
	}
	
	public List<Runnable> getSubprogramas(){
		return this.subprogramas;
	}

}
