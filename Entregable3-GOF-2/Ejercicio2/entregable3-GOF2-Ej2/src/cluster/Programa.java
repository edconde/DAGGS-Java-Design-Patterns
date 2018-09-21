package cluster;
import java.util.Observable;

public abstract class Programa extends Observable implements Runnable {

	protected boolean finalizado = false;
	
	@Override
	public void run() {
		super.setChanged();
		super.notifyObservers(); //llamar a update de mis Observer
		_run();
		finalizado = true;
		super.setChanged();
		super.notifyObservers();
	}
	
	protected abstract void _run();
	
}
