package ds.miniframework;

import java.util.List;
import java.util.Observable;

public abstract class Operation extends Observable {
	
	private double progress = 0;
	
	public String execute(List<String> params) {
		for(int i=0; i<=3; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setProgress((this.getProgress() + 0.2));
			super.setChanged();
			super.notifyObservers(); //llamar a update de mis Observer
		}
		
		String result =_execute(params);
		this.setProgress(1);
		super.setChanged();
		super.notifyObservers();
		return result;
	}
	
	public abstract String _execute(List<String> params);
	
	public abstract String getName();
	
	public abstract List<String> getParameters();
	
	public double getProgress() {
		return this.progress;
	}
	protected void setProgress(double p) {
		this.progress = p;
	}

}
