package ds.miniframework;

public class ConsoleLogger extends Logger {

	public ConsoleLogger(Logger next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	public void _log(String msg) {
		System.out.println(msg);
	}
	
}
